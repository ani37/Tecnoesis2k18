package com.example.tenx.test272.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tenx.test272.Adapters.CustomEventResultsAdapter;
import com.example.tenx.test272.ListItems.HeaderItem;
import com.example.tenx.test272.ListItems.ResultListItemII;
import com.example.tenx.test272.ListItems.ResultListitem;
import com.example.tenx.test272.ListItems.ResultsHeader;
import com.example.tenx.test272.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import java.util.Map;

public class ChildFragmentConferenzaResults extends Fragment{
    ImageView mBack;
    TextView mHeader;
    FirebaseFirestore mDb = FirebaseFirestore.getInstance();
    RecyclerView recycler;
    CustomEventResultsAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_child_event_results, container, false);
        mBack = view.findViewById(R.id.iv_back);

        recycler = view.findViewById(R.id.recycler_robotron_events);

        mHeader = view.findViewById(R.id.header_title_results);
        mHeader.setText("Results!");

        CollectionReference mRef = mDb.collection("EventResults").document("conferenza").collection("events");

        mRef.addSnapshotListener(MetadataChanges.INCLUDE, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if(queryDocumentSnapshots != null){
                    if(!adapter.getList().isEmpty()){
                        adapter.clearList();
                        adapter.notifyDataSetChanged();
                    }
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for(DocumentSnapshot snap : list){
                        String eventname = snap.getId();
                        fetchData(snap, eventname);
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
        //setting up the adapter
        adapter = new CustomEventResultsAdapter(getActivity());
        adapter.setTextGravityAndSize(18, Gravity.CENTER);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);



    }


    public void fetchData(DocumentSnapshot documentSnapshot, String eventName){
        assert documentSnapshot != null;
        Map<String,Object> map = documentSnapshot.getData();
        assert map != null;
        adapter.insertItemAndRefresh(new ResultsHeader(eventName));
        for(Map.Entry<String, Object> entry : map.entrySet()){

            String data = entry.getValue().toString();
                adapter.insertItemAndRefresh(new ResultListItemII(entry.getKey().toUpperCase(), data));
        }
    }

    public void goBack(){
        android.support.v4.app.FragmentManager manager = getFragmentManager();
        assert manager != null;
        android.support.v4.app.FragmentTransaction ft = manager.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in, R.anim.slide_out);
        ft.replace(R.id.container_notif_frame, new FragmentNotificationFrame()).addToBackStack(null);
        ft.commit();
    }
}
