package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Utils.TeamHeader;

import java.util.List;

public class CustomTeamEpandableAdapter extends BaseExpandableListAdapter{
    private Context mCtx;
    private List<TeamHeader> mList;

    public CustomTeamEpandableAdapter(Context mCtx, List<TeamHeader> mList) {
        this.mCtx = mCtx;
        this.mList = mList;
    }

    @Override
    public int getGroupCount() {
        return mList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mList.get(i).getTeamList().size();
    }

    @Override
    public Object getGroup(int i) {
        return mList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mList.get(i).getTeamList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View v1 = view;
        if(v1 == null){
            v1 = LayoutInflater.from(mCtx).inflate(R.layout.vh_team_header, null);
        }
        TextView tvHeader = v1.findViewById(R.id.tv_team_header);
        tvHeader.setText(mList.get(i).getHeaderName());

        return v1;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View v1 = view;
        if(v1 == null){
            v1 = LayoutInflater.from(mCtx).inflate(R.layout.vh_team_member_display, null);
        }
        TextView tvName = v1.findViewById(R.id.tv_team_name);
        ImageView ivImg = v1.findViewById(R.id.iv_team_image);
        TextView tvRole = v1.findViewById(R.id.tv_team_role);
        tvName.setText(mList.get(i).getTeamList().get(i1).getName());
        tvRole.setText(mList.get(i).getTeamList().get(i1).getMemberRole());
        ivImg.setImageResource(mList.get(i).getTeamList().get(i1).getImgRes());
        return v1;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
