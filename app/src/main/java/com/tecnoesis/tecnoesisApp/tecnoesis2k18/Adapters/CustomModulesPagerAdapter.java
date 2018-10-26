package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Utils.Models.ModuleEvent;

import java.util.List;

public class CustomModulesPagerAdapter extends PagerAdapter {
    private Context mCtx;
    private TextView tvContactHeader,tvHeaderdesc, tvDesc, tvPstat, tvRegister, tvPdf, tvContact1, tvContact2,tvContact3, tvm1header, tvm1desc, tvm2header, tvm2desc, tvHeader, tvPrize, tvHeaderPstat;
    private List<ModuleEvent> list;

    public CustomModulesPagerAdapter(Context mCtx, List<ModuleEvent> list) {
        this.mCtx = mCtx;
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.module_slide, container, false);
        tvPstat = view.findViewById(R.id.tv_problem_statement_desc);
        tvRegister = view.findViewById(R.id.tv_register_link);
        tvPdf = view.findViewById(R.id.tv_pdf_link);
        tvContact1 = view.findViewById(R.id.tv_contact1);
        tvContact2 = view.findViewById(R.id.tv_contact2);
        tvHeader = view.findViewById(R.id.tv_robotron_header);
        tvPrize = view.findViewById(R.id.tv_robotron_prize);
        tvDesc = view.findViewById(R.id.tv_module_desc);
        tvHeaderPstat = view.findViewById(R.id.tv_header_problem_statement);
        tvContact3 = view.findViewById(R.id.tv_contact3);
        tvm1header = view.findViewById(R.id.tv_header_misc1);
        tvm1desc = view.findViewById(R.id.tv_desc_misc1);
        tvm2header = view.findViewById(R.id.tv_header_misc2);
        tvm2desc = view.findViewById(R.id.tv_desc_misc2);
        tvContactHeader = view.findViewById(R.id.tv_contact_header);
        tvHeaderdesc = view.findViewById(R.id.tv_header_desc);

        ModuleEvent currentEvent = list.get(position);


        tvm1header.setText(currentEvent.getM1header());
        tvm1desc.setText(currentEvent.getM1desc());
        tvm2header.setText(currentEvent.getM2header());
        tvm2desc.setText(currentEvent.getM2desc());
        if(currentEvent.getContact1().equals("")){
            tvContactHeader.setVisibility(View.GONE);
        }
        if(currentEvent.getPstat().equals("")){
            tvHeaderPstat.setVisibility(View.GONE);
        }
        if(currentEvent.getName().equals("COMING SOON!")){
            tvHeaderdesc.setVisibility(View.GONE);
        }
        tvDesc.setText(currentEvent.getDesc());
        tvPstat.setText(currentEvent.getPstat());
        tvContact1.setText(currentEvent.getContact1());
        tvContact2.setText(currentEvent.getContact2());
        tvPrize.setText(currentEvent.getPrizeMoney());
        tvHeader.setText(currentEvent.getName());
        container.addView(view);
        if(currentEvent.getRegisterLink().equals("")){
            tvRegister.setVisibility(View.GONE);
        }
        if (currentEvent.getPdfLink().equals("")){
            tvPdf.setVisibility(View.GONE);
        }
        tvRegister.setOnClickListener(getListener(currentEvent.getRegisterLink()));
        tvPdf.setOnClickListener(getListener(currentEvent.getPdfLink()));

        return view;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ScrollView)object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return ""+(position+1);
    }

    public View.OnClickListener getListener(final String url){
       View.OnClickListener listener = new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(Intent.ACTION_VIEW);
               i.setData(Uri.parse(url));
               mCtx.startActivity(i);
           }
       };
       return listener;
    }
}
