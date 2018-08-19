package com.example.tenx.test272.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tenx.test272.Adapters.CustomModulesAdapter;
import com.example.tenx.test272.Adapters.CustomWorkshopAdapter;
import com.example.tenx.test272.R;

public class FragmentModules extends Fragment{

    RecyclerView recyclerView;
    CustomModulesAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modules, container, false);
        recyclerView = view.findViewById(R.id.modules_recycler);
        adapter = new CustomModulesAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
