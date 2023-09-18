package com.twentythree.studydemo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayoutMediator;
import com.twentythree.studydemo.activity.MainActivity;
import com.twentythree.studydemo.adapter.MyAdapter;
import com.twentythree.studydemo.databinding.FragmentMineBinding;

import java.util.ArrayList;

public class MineFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public MineFragment() {

    }


    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    FragmentMineBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMineBinding.inflate(inflater);
        // Fragment 如何从Activity 中获得数据
        String userName = ((MainActivity) requireActivity()).getUserName();
        binding.mineFragment.setText(userName);

        ArrayList<String> arrayList =new ArrayList<String>();
        arrayList.add("LeftTab");
        arrayList.add("RightTab");
        //viewpager 的 adapter
        MyAdapter myAdapter =new  MyAdapter();
        binding.viewPager2.setAdapter(myAdapter);
        myAdapter.bindData(arrayList);

        //viewpager2 与 tabLayout 联动
        new TabLayoutMediator(binding.tabLayout, binding.viewPager2, (tab, position) -> {
            tab.setText(arrayList.get(position));
        }).attach();
        return binding.getRoot();
    }

}