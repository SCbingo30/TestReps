package com.twentythree.studydemo.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twentythree.studydemo.MyItemRecyclerViewAdapter;
import com.twentythree.studydemo.PlaceholderItem;
import com.twentythree.studydemo.R;
import com.twentythree.studydemo.databinding.FragmentHomeBinding;
import com.twentythree.studydemo.databinding.FragmentHomeListBinding;


import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class HomeFragment extends Fragment {



    public HomeFragment() {
    }


    public static HomeFragment newInstance(int columnCount) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHomeListBinding binding = FragmentHomeListBinding.inflate(inflater);

        // recyclerView 的使用
        RecyclerView recyclerView = (RecyclerView) binding.list;

        recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));

        ArrayList<PlaceholderItem> list =new ArrayList<PlaceholderItem>();
        for (int i=0;i<25;i++){
            list.add(new PlaceholderItem(String.valueOf(i),"item"+i,""));
        }

        recyclerView.setAdapter(new MyItemRecyclerViewAdapter(list));

        return binding.getRoot();
    }
}