package com.journaldev.customlistview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sijaw on 10/16/2017.
 */

public class RecylceAdapter extends RecyclerView.Adapter
        <RecylceAdapter.MyViewHolder> {
    private List<DataModel> list;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        ImageView dp;
        ImageView info;

        public MyViewHolder(View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.name);
            txtType = (TextView) view.findViewById(R.id.type);
            txtVersion = (TextView) view.findViewById(R.id.version_number);
            info = (ImageView) view.findViewById(R.id.item_info);
            dp = (ImageView) view.findViewById(R.id.itemimage);
        }
    }


    public RecylceAdapter(List<DataModel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, final int position) {
        DataModel dataModel = list.get(position);
        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtType.setText(dataModel.getType());
        viewHolder.txtVersion.setText(dataModel.getVersion_number());
        viewHolder.info.setTag(position);
        viewHolder.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);

                notifyDataSetChanged();
                notifyItemRangeChanged(position,list.size());

            }
        });
        Picasso.with(context).load(dataModel.getImgurl()).resize(150, 150).centerCrop().into(viewHolder.dp);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
