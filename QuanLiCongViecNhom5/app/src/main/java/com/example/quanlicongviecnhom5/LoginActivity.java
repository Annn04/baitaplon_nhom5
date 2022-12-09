package com.example.quanlicongviecnhom5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlicongviecnhom5.database.UserDatabase;
import com.example.quanlicongviecnhom5.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    TextView tvChuacotaikhoan;
    EditText edtphone;
    EditText edtpass;
    Button btnLogin;
//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference myRef;
    ArrayList<User> array = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        myRef = firebaseDatabase.getReference("list_user");
        tvChuacotaikhoan = findViewById(R.id.tv_chuacotaikhoan);
        edtphone = findViewById(R.id.edt_sodienthoai);
        edtpass = findViewById(R.id.edt_matkhau);
        btnLogin = findViewById(R.id.btn_login);
        tvChuacotaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SingupActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edtphone.getText().toString();
                String pass = edtpass.getText().toString();
//                firebaseDatabase = FirebaseDatabase.getInstance();
//                myRef = firebaseDatabase.getReference("list_user");
//                myRef.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        for(DataSnapshot dataSnapshot : snapshot.getChildren()){
//                            User user = dataSnapshot.getValue(User.class);
//                            if(TextUtils.isEmpty(phone) || TextUtils.isEmpty(pass) || !phone.equals(user.getPhoneNumber()) || !pass.equals(user.getPassWord())){
//
//                            }else {
//                                Intent intent = new Intent(LoginActivity.this, DanhSachCVActivity.class);
//                                startActivity(intent);
//                                break;
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
                array = (ArrayList<User>) UserDatabase.getInstance(LoginActivity.this).UserDAO().getListUser();
                for(User user : array){
                    if(TextUtils.isEmpty(phone) || TextUtils.isEmpty(pass) || !phone.equals(user.getPhoneNumber()) || !pass.equals(user.getPassWord())){
                        Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }else {
                        Intent intent = new Intent(LoginActivity.this, DanhSachCVActivity.class);
                                startActivity(intent);
                                break;
                    }
                }
            }
        });
    }
}