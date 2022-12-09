package com.example.quanlicongviecnhom5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quanlicongviecnhom5.database.KeHoachDatabase;
import com.example.quanlicongviecnhom5.model.KeHoach;

public class UpdateCVActivity extends AppCompatActivity {
    EditText edtUpdateCv;
    EditText edtUpdateMota;
    EditText edtUpdateNguoitao;
    EditText edtUpdateNgayBatDau;
    Button btnSaveUpdate;
    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cvactivity);
        edtUpdateCv = findViewById(R.id.edt_updatecv);
        edtUpdateMota = findViewById(R.id.edt_updatemota);
        edtUpdateNguoitao = findViewById(R.id.edt_updatenguoitao);
        edtUpdateNgayBatDau = findViewById(R.id.edt_updatengaybatdau);
        btnSaveUpdate = findViewById(R.id.btn_save_update);
        imgBack = findViewById(R.id.img_back_update);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundleUpdate");
        KeHoach keHoach = (KeHoach) bundle.getSerializable("dataUpdate");
        edtUpdateCv.setText(keHoach.getCongViec());
        edtUpdateMota.setText(keHoach.getMoTa());
        edtUpdateNguoitao.setText(keHoach.getNguoiTao());
        edtUpdateNgayBatDau.setText(keHoach.getNgayBatDau());
        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updateCV = edtUpdateCv.getText().toString();
                String updateMoTa = edtUpdateMota.getText().toString();
                String updateNguoiTao = edtUpdateNguoitao.getText().toString();
                String updateNgayBatDau = edtUpdateNgayBatDau.getText().toString();
                if(TextUtils.isEmpty(updateCV) || TextUtils.isEmpty(updateMoTa) || TextUtils.isEmpty(updateNguoiTao) || TextUtils.isEmpty(updateNgayBatDau)){
                    Toast.makeText(UpdateCVActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                keHoach.setCongViec(updateCV);
                keHoach.setMoTa(updateMoTa);
                keHoach.setNguoiTao(updateNguoiTao);
                keHoach.setNgayBatDau(updateNgayBatDau);
                KeHoachDatabase.getInstance(UpdateCVActivity.this).keHoachDAO().updateKeHoach(keHoach);
                Toast.makeText(UpdateCVActivity.this, "Update thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateCVActivity.this, DanhSachCVActivity.class);
                startActivity(intent);
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}