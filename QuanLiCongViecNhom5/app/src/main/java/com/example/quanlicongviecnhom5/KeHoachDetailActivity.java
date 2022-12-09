package com.example.quanlicongviecnhom5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlicongviecnhom5.model.KeHoach;

public class KeHoachDetailActivity extends AppCompatActivity {
    TextView tvNgayBatDau;
    TextView tvKeHoach;
    TextView tvMoTa;
    TextView tvNguoitao;
    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke_hoach_detail);
        tvNgayBatDau = findViewById(R.id.tv_startday_detail);
        tvKeHoach = findViewById(R.id.tv_kehoach_detail);
        tvMoTa = findViewById(R.id.tv_mota_detail);
        tvNguoitao = findViewById(R.id.tv_nguoitao_detail);
        imgBack = findViewById(R.id.img_back_detail);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        KeHoach keHoach = (KeHoach) bundle.getSerializable("data");
        tvNgayBatDau.setText(keHoach.getNgayBatDau());
        tvKeHoach.setText(keHoach.getCongViec());
        tvMoTa.setText(keHoach.getMoTa());
        tvNguoitao.setText(keHoach.getNguoiTao());
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}