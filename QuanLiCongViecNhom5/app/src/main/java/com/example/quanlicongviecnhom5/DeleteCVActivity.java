package com.example.quanlicongviecnhom5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quanlicongviecnhom5.database.KeHoachDatabase;
import com.example.quanlicongviecnhom5.model.KeHoach;

public class DeleteCVActivity extends AppCompatActivity {
    Button btnCancel;
    Button btnConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_cvactivity);
        btnCancel = findViewById(R.id.btn_cancel);
        btnConfirm = findViewById(R.id.btn_confirm);
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle = intent.getBundleExtra("bundleDelete");
        KeHoach keHoach = (KeHoach) bundle.getSerializable("dataDelete");
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeHoachDatabase.getInstance(DeleteCVActivity.this).keHoachDAO().deleteKeHoach(keHoach);
                Intent intent = new Intent(DeleteCVActivity.this, DanhSachCVActivity.class);
                startActivity(intent);
                Toast.makeText(DeleteCVActivity.this, "delete", Toast.LENGTH_SHORT).show();
            }
        });
    }
}