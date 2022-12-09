package com.example.quanlicongviecnhom5;

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
import com.example.quanlicongviecnhom5.helper.SQLiteHelper;
import com.example.quanlicongviecnhom5.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SingupActivity extends AppCompatActivity {
//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference myRef;
    //SQLiteHelper sqLiteHelper;
    //ArrayList<User> array = new ArrayList<>();
    TextView tvDacotaikhoan;
    EditText edtPhone;
    EditText edtpass;
    EditText edtconfirmPass;
    EditText edtTenNguoiDung;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        myRef = firebaseDatabase.getReference("list_user");
        tvDacotaikhoan = findViewById(R.id.tv_dacotk);
        edtPhone = findViewById(R.id.edt_sodienthoai_signup);
        edtpass = findViewById(R.id.edt_matkhau_signup);
        edtconfirmPass = findViewById(R.id.edt_xacnhanmatkhau_signup);
        edtTenNguoiDung = findViewById(R.id.edt_tennguoidung);
        btnSignUp = findViewById(R.id.btn_signup);
        tvDacotaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtTenNguoiDung.getText().toString();
                String phone = edtPhone.getText().toString();
                String pass = edtpass.getText().toString();
                String confirmpass = edtconfirmPass.getText().toString();
                if(TextUtils.isEmpty(phone) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(confirmpass) || !pass.equals(confirmpass)){
                    Toast.makeText(SingupActivity.this, "Vui lòng điền đúng thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    User user = new User(name, phone, pass);
                    UserDatabase.getInstance(SingupActivity.this).UserDAO().inSert(user);
//                    myRef.child(name).setValue(user);
                    Toast.makeText(SingupActivity.this, "đăng kí thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SingupActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
//        tvDacotaikhoan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SingupActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });

    }
}