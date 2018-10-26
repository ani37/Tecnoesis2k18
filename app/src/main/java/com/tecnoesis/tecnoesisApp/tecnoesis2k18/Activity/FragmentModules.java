package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Adapters.CustomModulesAdapter;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Adapters.CustomWorkshopAdapter;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;

public class FragmentModules extends Fragment{

    RecyclerView recyclerView;
    CustomModulesAdapter adapter;
    public static final int KEY_ROBOTRON = 0;
    public static final int KEY_SHOWCASE = 1;
    public static final int KEY_AMAZERS = 2;
    public static final int KEY_CONFERENZA = 3;
    public static final int KEY_CYBERWARP = 4;
    public static final int KEY_VWARZ = 5;
    public static final int KEY_SMARKCITY = 6;
    public static final int KEY_MYNDSNARE = 7;
    public static final int KEY_EMPRESSARIO = 8;
    public static final int KEY_SCHOOLGENIUS = 9;
    public static final int KEY_ASME = 10;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modules, container, false);
        recyclerView = view.findViewById(R.id.modules_recycler);
        adapter = new CustomModulesAdapter(getActivity());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
