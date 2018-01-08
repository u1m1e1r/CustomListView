package com.journaldev.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener {
    private ArrayList<DataModel> dataSet;
    Context mContext;
    ImageView imageView;
    boolean anim = false;

    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        ImageView dp;
        ImageView info;
    }

    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        Object object = getItem(position);
        DataModel dataModel = (DataModel) object;
        switch (v.getId()) {
            case R.id.item_info:
                dataSet.remove(position);

                this.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataModel dataModel = getItem(position);
        ViewHolder viewHolder; // view lookup cache stored in tag
        final View result;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
            viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.version_number);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);
            viewHolder.dp = (ImageView) convertView.findViewById(R.id.itemimage);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtType.setText(dataModel.getType());
        viewHolder.txtVersion.setText(dataModel.getVersion_number());
        viewHolder.info.setOnClickListener(this);
        viewHolder.info.setTag(position);
        viewHolder.dp.setImageResource(android.R.drawable.btn_plus);
        return convertView;
    }


}
