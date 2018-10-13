package com.example.tenx.test272.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tenx.test272.Adapters.CustomSparkAdapter;
import com.example.tenx.test272.R;

public class FragmentSpark extends Fragment{

    RecyclerView recycler;
    CustomSparkAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spark, container, false);
        recycler = view.findViewById(R.id.recycler_spark_gallery);
        adapter = new CustomSparkAdapter(getActivity());
        recycler.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        recycler.setAdapter(adapter);
        return view;
    }
}
