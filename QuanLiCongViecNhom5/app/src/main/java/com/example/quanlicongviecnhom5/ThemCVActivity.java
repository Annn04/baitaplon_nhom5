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

public class ThemCVActivity extends AppCompatActivity {
    EditText edtCongViec;
    EditText edtMoTa;
    EditText edtNguoiTao;
    EditText edtNgayBatDau;
    Button btnSave;
    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_cvactivity);
        edtCongViec = findViewById(R.id.edt_themcv);
        edtMoTa = findViewById(R.id.edt_mota);
        edtNguoiTao = findViewById(R.id.edt_nguoitao);
        edtNgayBatDau = findViewById(R.id.edt_ngaybatdau);
        btnSave = findViewById(R.id.btn_luu);
        imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String congViec = edtCongViec.getText().toString();
                String moTa = edtMoTa.getText().toString();
                String nguoiTao = edtNguoiTao.getText().toString();
                String ngayBatDau = edtNgayBatDau.getText().toString();
                if(TextUtils.isEmpty(congViec) || TextUtils.isEmpty(moTa) || TextUtils.isEmpty(nguoiTao) || TextUtils.isEmpty(ngayBatDau)){
                    Toast.makeText(ThemCVActivity.this, "error", Toast.LENGTH_SHORT).show();
                    return;
                }
                KeHoach keHoach = new KeHoach(congViec, moTa, nguoiTao, ngayBatDau);
                KeHoachDatabase.getInstance(ThemCVActivity.this).keHoachDAO().inSert(keHoach);
                Toast.makeText(ThemCVActivity.this, "insert", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ThemCVActivity.this, DanhSachCVActivity.class);
                startActivity(intent);
            }
        });
    }
}