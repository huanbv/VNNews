package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterSourceList extends RecyclerView.Adapter<AdapterSourceList.HolderSourceList> {

    private Context context;
    private ArrayList<ModelSourceList> sourceLists;

    // constructor
    public AdapterSourceList(Context context, ArrayList<ModelSourceList> sourceLists) {
        this.context = context;
        this.sourceLists = sourceLists;
    }

    @NonNull
    @Override
    public HolderSourceList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflare layout row_source_list.xml
        View view = LayoutInflater.from(context).inflate(R.layout.row_source_list, parent, false);

        return new HolderSourceList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderSourceList holder, int position) {
    // get data
        ModelSourceList model = sourceLists.get(position);
        String id = model.getId();
        String name = model.getName();
        String description = model.getDescription();
        String country = model.getCountry();
        String category = model.getCategory();
        String language = model.getLanguage();

        // set data to ui views
        holder.nameTv.setText(name);
        holder.descriptionTv.setText(description);
        holder.countryTv.setText("country: "+country);
        holder.categoryTv.setText("category: "+category);
        holder.languageTv.setText("language: "+language);

        // handle clicks
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return sourceLists.size(); // return size of list
    }

    // view holder class
    class HolderSourceList extends RecyclerView.ViewHolder{

        // UI views form row_source_list.xml
        TextView nameTv, descriptionTv, countryTv, categoryTv, languageTv;


        public HolderSourceList(@NonNull View itemView) {
            super(itemView);

         // init ui views
            nameTv = itemView.findViewById(R.id.nameTv);
            descriptionTv = itemView.findViewById(R.id.descriptionTv);
            countryTv = itemView.findViewById(R.id.countryTv);
            categoryTv = itemView.findViewById(R.id.categoryTv);
            languageTv = itemView.findViewById(R.id.languageTv);
        }
    }
}
