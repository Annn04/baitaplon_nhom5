package com.example.quanlicongviecnhom5.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "KeHoach")
public class KeHoach implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int id;
    String congViec;
    String moTa;
    String nguoiTao;
    String ngayBatDau;
    public KeHoach(String congViec, String moTa, String nguoiTao, String ngayBatDau){
        this.congViec = congViec;
        this.moTa = moTa;
        this.nguoiTao = nguoiTao;
        this.ngayBatDau = ngayBatDau;
    }

    public int getId() {
        return id;
    }

    public String getCongViec() {
        return congViec;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public void setId(int id) {
        this.id = id;
    }
}
