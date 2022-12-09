package com.example.quanlicongviecnhom5.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlicongviecnhom5.DeleteCVActivity;
import com.example.quanlicongviecnhom5.KeHoachDetailActivity;
import com.example.quanlicongviecnhom5.R;
import com.example.quanlicongviecnhom5.UpdateCVActivity;
import com.example.quanlicongviecnhom5.database.KeHoachDatabase;
import com.example.quanlicongviecnhom5.model.KeHoach;

import java.util.ArrayList;

public class CongViecAdapter extends RecyclerView.Adapter<CongViecAdapter.ItemHolder>{
    ArrayList<KeHoach> arrayList;
    Context context;
    public CongViecAdapter(ArrayList<KeHoach> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemdanhsachcv, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        int po = position;
        KeHoach keHoach = arrayList.get(position);
        holder.tvNgayBatdau.setText(arrayList.get(position).getNgayBatDau());
        holder.tvKeHoach.setText(arrayList.get(position).getCongViec());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, KeHoachDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", keHoach);
                intent.putExtra("bundle", bundle);
                context.startActivity(intent);
            }
        });
        holder.imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DeleteCVActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("dataDelete", keHoach);
                intent.putExtra("bundleDelete", bundle);
                context.startActivity(intent);
            }
        });
        holder.imgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateCVActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("dataUpdate", keHoach);
                intent.putExtra("bundleUpdate", bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        TextView tvNgayBatdau;
        TextView tvKeHoach;
        ImageView imgUpdate;
        ImageView imgCancel;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            tvNgayBatdau = itemView.findViewById(R.id.tv_startday);
            tvKeHoach = itemView.findViewById(R.id.tv_kehoach);
            imgUpdate = itemView.findViewById(R.id.img_update);
            imgCancel = itemView.findViewById(R.id.img_cancel);
        }
    }
}
