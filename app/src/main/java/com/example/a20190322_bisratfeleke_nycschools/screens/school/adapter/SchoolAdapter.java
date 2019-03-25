package com.example.a20190322_bisratfeleke_nycschools.screens.school.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a20190322_bisratfeleke_nycschools.R;
import com.example.a20190322_bisratfeleke_nycschools.model.SchoolResponse;

import java.util.List;


public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.SchoolAdapterViewHolder> {



    ItemClickListener itemClickListener;
    private List<SchoolResponse> schoolResponseList;


    public SchoolAdapter(List<SchoolResponse> schoolResponseList, ItemClickListener itemClickListener) {

        this.schoolResponseList = schoolResponseList;
        this.itemClickListener = itemClickListener;

    }

    @NonNull
    @Override
    public SchoolAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_listing, parent, false);

        SchoolAdapterViewHolder viewHolder = new SchoolAdapterViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SchoolAdapterViewHolder holder, int position) {
        holder.bind(schoolResponseList.get(position));
    }

    @Override
    public int getItemCount() {
        return schoolResponseList.size();
    }

    public class SchoolAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView schoolName, schoolAddress, schoolPhoneNumber;

        public SchoolAdapterViewHolder(View itemView) {
            super(itemView);
            schoolName = itemView.findViewById(R.id.tv_school_name);
            schoolAddress = itemView.findViewById(R.id.tv_school_address);
            schoolPhoneNumber = itemView.findViewById(R.id.tv_phone);

        }

        void bind(SchoolResponse response) {
            itemView.setOnClickListener(v -> itemClickListener
                    .onItemClick(schoolResponseList.get(getAdapterPosition())));
            schoolName.setText(response.getSchoolName());
            schoolAddress.setText(response.getPrimaryAddressLine1());
            schoolPhoneNumber.setText(response.getPhoneNumber());
        }
    }

}
