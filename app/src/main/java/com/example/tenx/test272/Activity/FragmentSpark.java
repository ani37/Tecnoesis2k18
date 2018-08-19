package com.example.tenx.test272.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tenx.test272.R;

public class FragmentSpark extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spark, container, false);
        ImageView mainPoster = view.findViewById(R.id.fragment_spark_image);
        Glide.with(getActivity()).load("http://tecnoesis.in/vr/images/Spark/spark.png").into(mainPoster);
        return view;
    }
}
