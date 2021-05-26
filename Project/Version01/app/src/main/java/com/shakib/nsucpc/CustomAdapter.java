package com.shakib.nsucpc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<DataSet> {


    private Activity context;
    private List<DataSet> dataSets;

    public CustomAdapter(Activity context, List<DataSet> dataSets) {
        super(context, R.layout.sample_layout,dataSets);
        this.context = context;
        this.dataSets = dataSets;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_layout,null, true);

        DataSet dataSet = dataSets.get(position);


        TextView location = view.findViewById(R.id.locationViewID);

        TextView salary = view.findViewById(R.id.salaryViewID);

        TextView title = view.findViewById(R.id.jobTitleViewID);

        TextView deadline = view.findViewById(R.id.deadlineViewID);



        location.setText(dataSet.getLocation());
        salary.setText(dataSet.getSalary());
        title.setText(dataSet.getJobTitle());
        deadline.setText(dataSet.getDeadline());



        return view;
    }
}
