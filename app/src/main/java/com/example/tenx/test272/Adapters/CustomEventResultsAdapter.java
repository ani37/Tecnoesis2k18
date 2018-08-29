package com.example.tenx.test272.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tenx.test272.DatabaseElements.Models.Notification;
import com.example.tenx.test272.ListItems.ListItem;
import com.example.tenx.test272.ListItems.ResultListItemII;
import com.example.tenx.test272.ListItems.ResultListitem;
import com.example.tenx.test272.ListItems.ResultsHeader;
import com.example.tenx.test272.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomEventResultsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mCtx;
    private List<ListItem> mList;
    private int textSize=15;
    private int gravity=3;

    public CustomEventResultsAdapter(Context mCtx, List<ListItem> mList) {
        this.mCtx = mCtx;
        this.mList = mList;
    }public CustomEventResultsAdapter(Context mCtx) {
        this.mCtx = mCtx;
        mList = new ArrayList<>();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(mCtx).inflate(R.layout.viewholder_robotron_results_listitem, parent, false);
        View view2 = LayoutInflater.from(mCtx).inflate(R.layout.viewholder_results_header, parent, false);
        View view3 = LayoutInflater.from(mCtx).inflate(R.layout.viewholder_event_result_type2, parent, false);
        if(viewType == ListItem.TYPE_EVENT){
            return new ListitemViewHolder(view1);
        }else if(viewType == ListItem.TYPE_HEADER){
            return new HeaderViewHolder(view2);
        }else if(viewType == ListItem.TYPE_EVENT2){
            return new ResultItemHolderII(view3);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if(type == ListItem.TYPE_EVENT){
            ((ListitemViewHolder) holder).tvTextView.setText(((ResultListitem) mList.get(position)).getName());
            ((ListitemViewHolder) holder).tvTextView.setTextSize(textSize);
            ((ListitemViewHolder) holder).tvTextView.setGravity(gravity);

        }else if(type == ListItem.TYPE_HEADER){
            ((HeaderViewHolder) holder).tvPlace.setText(((ResultsHeader) mList.get(position)).getName());
            ((HeaderViewHolder) holder).tvEventName.setText(((ResultsHeader) mList.get(position)).getEventName());
        }else if(type == ListItem.TYPE_EVENT2){
            ((ResultItemHolderII) holder).tvPlace.setText(((ResultListItemII) mList.get(position)).getmPlace());
            ((ResultItemHolderII) holder).tvName.setText(((ResultListItemII) mList.get(position)).getName());

        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class ListitemViewHolder extends RecyclerView.ViewHolder{
        TextView tvTextView;
        public ListitemViewHolder(View itemView) {
            super(itemView);
            tvTextView = itemView.findViewById(R.id.tv_results_header);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{
        TextView tvPlace, tvEventName;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            this.tvPlace = itemView.findViewById(R.id.tv_results_header);
            this.tvEventName = itemView.findViewById(R.id.tv_results_event_name);
        }
    }

    class ResultItemHolderII extends RecyclerView.ViewHolder{
        TextView tvPlace, tvName;

        public ResultItemHolderII(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_winner_name);
            tvPlace = itemView.findViewById(R.id.tv_place_header);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getType();
    }

    public void insertItemAndRefresh(ListItem item){
        mList.add(item);
        notifyItemInserted(mList.size() - 1);
    }

        public void setTextGravityAndSize(int size, int gravity){
        this.textSize = size;
        this.gravity = gravity;
        }

        public void clearList(){
        mList.clear();
        }
        public List<ListItem> getList(){
        return mList;
        }
}
