package com.journaldev.customlistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
public class BlankFragment extends Fragment {
    View view;
    static ArrayList<DataModel> dataModels;
    private static RecylceAdapter adapter;
    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_blank, container, false);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        dataModels = new ArrayList<>();
        int count=1;
        for (int i = 0; i < 999; i++) {
            String url="https://www.gstatic.com/webp/gallery3/"+count+".sm.png";
            if(count>5)
            {
                int temp=count-5;
                url="http://lorempixel.com/output/animals-q-c-640-480-"+temp+".jpg";
            }
            else if(count>15)
            {
                int temp=count-15;
                url="http://lorempixel.com/output/cats-q-c-640-480-"+temp+".jpg";
            }
            else if(count>20)
            {
                count=1;
            }
            count++;
            dataModels.add(new DataModel("Name " + i, "Number " + i, "Model " + i, "Version " + i,url));
        }
        adapter = new RecylceAdapter(dataModels,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (view.getId() == R.id.item_info) {

                } else {
                    DataModel dataModel = dataModels.get(position);
                    Gson gson=new Gson();
                    String datatosend=gson.toJson(dataModel);
                    onButtonPressed(datatosend);
                }

            }
            @Override
            public void onLongClick(View view, int position) {
            }
        }));
        return view;
    }

    public void onButtonPressed(String string) {
        if (mListener != null) {
            mListener.onFragmentInteraction(string);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    public void show(Context mContext)
    {
        Toast.makeText(mContext,"done",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String string);
    }
}
