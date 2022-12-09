package com.example.quanlicongviecnhom5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.quanlicongviecnhom5.adapter.CongViecAdapter;
import com.example.quanlicongviecnhom5.database.KeHoachDatabase;
import com.example.quanlicongviecnhom5.model.KeHoach;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    ImageView imgSearch;
    EditText edtSearch;
    RecyclerView rcSearch;
    CongViecAdapter congViecAdapter;
    ArrayList<KeHoach> arrayList;
    ArrayList<KeHoach> arrayList1;
    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        imgSearch = findViewById(R.id.img_search1);
        edtSearch = findViewById(R.id.edt_search);
        rcSearch = findViewById(R.id.rc_search);
        //imgBack = findViewById(R.id.img_back);
        arrayList1 = new ArrayList<>();
        arrayList = new ArrayList<>();
        congViecAdapter = new CongViecAdapter(arrayList, SearchActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this);
        rcSearch.setLayoutManager(linearLayoutManager);
        rcSearch.setAdapter(congViecAdapter);
//        imgBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = edtSearch.getText().toString();
                arrayList1 = (ArrayList<KeHoach>) KeHoachDatabase.getInstance(SearchActivity.this).keHoachDAO().getListKeHoach();
                for(KeHoach keHoach : arrayList1){
                    if(keHoach.getCongViec().contains(search)){
                        arrayList.add(keHoach);
                    }
                }
                congViecAdapter.notifyDataSetChanged();
            }
        });
    }
}