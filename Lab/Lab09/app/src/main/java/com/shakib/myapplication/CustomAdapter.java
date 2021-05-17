package com.shakib.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<DataSet> {


    private Activity context;
    private List<DataSet> dataSets;

    public CustomAdapter(Activity context, List<DataSet> dataSets) {
        super(null, R.layout.listview_layout,dataSets);
        this.context = context;
        this.dataSets = dataSets;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.listview_layout,null, true);

        DataSet dataSet = dataSets.get(position);


        TextView name = view.findViewById(R.id.nameTextFieldId);

        TextView id = view.findViewById(R.id.idTextFieldId);

        TextView school = view.findViewById(R.id.schoolTextFieldId);

        TextView dept = view.findViewById(R.id.deptTextFieldId);

        return view;
    }
}
