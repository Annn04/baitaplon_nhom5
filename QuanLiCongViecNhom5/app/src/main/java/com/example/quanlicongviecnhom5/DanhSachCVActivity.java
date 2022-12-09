package com.example.quanlicongviecnhom5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.quanlicongviecnhom5.adapter.CongViecAdapter;
import com.example.quanlicongviecnhom5.database.KeHoachDatabase;
import com.example.quanlicongviecnhom5.model.KeHoach;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DanhSachCVActivity extends AppCompatActivity {
    FloatingActionButton fltAdd;
    RecyclerView rcDanhSach;
    ArrayList<KeHoach> arrayList;
    CongViecAdapter congViecAdapter;
    ImageView imgSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_cvactivity);
        fltAdd = findViewById(R.id.floatingAdd);
        rcDanhSach = findViewById(R.id.rc_danhsachcv);
        imgSearch = findViewById(R.id.img_search_list);
        arrayList = new ArrayList<>();
        arrayList = (ArrayList<KeHoach>) KeHoachDatabase.getInstance(DanhSachCVActivity.this).keHoachDAO().getListKeHoach();
        congViecAdapter = new CongViecAdapter(arrayList, DanhSachCVActivity.this);
        fltAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhSachCVActivity.this, ThemCVActivity.class);
                startActivity(intent);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DanhSachCVActivity.this);
        rcDanhSach.setLayoutManager(linearLayoutManager);
        rcDanhSach.setAdapter(congViecAdapter);
        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhSachCVActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}