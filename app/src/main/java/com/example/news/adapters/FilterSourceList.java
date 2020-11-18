package com.example.news.adapters;

import android.widget.Filter;

import com.example.news.activities.MainActivity;
import com.example.news.models.ModelSourceList;

import java.util.ArrayList;

public class FilterSourceList extends Filter {

    private MainActivity adapter;
    private ArrayList<ModelSourceList> fillerList;

    // constructor
    public FilterSourceList(MainActivity adapter, ArrayList<ModelSourceList> fillerList) {
        this.adapter = adapter;
        this.fillerList = fillerList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        FilterResults results = new FilterResults();
        // check constraint validity
        if (constraint != null && constraint.length() > 0){
            // change to uppar case to make it not case sensitive
            constraint = constraint.toString().toUpperCase();
            // store our filtered records
            ArrayList<ModelSourceList> filteredModels = new ArrayList<>();
            for(int i=0; i<fillerList.size(); i++){
                if(fillerList.get(i).getName().toUpperCase().contains(constraint)){
                    filteredModels.add(fillerList.get(i));
                }
            }

            results.count = filteredModels.size();
            results.values = filteredModels;
        }
        else {
            results.count = fillerList.size();
            results.values = fillerList;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
    }
}
