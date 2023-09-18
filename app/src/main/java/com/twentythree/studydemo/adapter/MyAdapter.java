package com.twentythree.studydemo.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twentythree.studydemo.databinding.ViewpagerViewBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    ArrayList<String> list = new ArrayList<>();
    // 在这里定义适配器需要的数据结构
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建 ViewHolder 并关联视图布局
        ViewpagerViewBinding binding = ViewpagerViewBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.tv1.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void bindData(ArrayList<String> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ViewpagerViewBinding binding;
        public MyViewHolder(@NonNull ViewpagerViewBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

    }
}
