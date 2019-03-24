package com.example.a20190322_bisratfeleke_nycschools.screens.main.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a20190322_bisratfeleke_nycschools.R;
import com.example.a20190322_bisratfeleke_nycschools.model.school.SchoolResponse;

import java.util.List;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemViewHolder> {



    ItemClickListener itemClickListener;
    private List<SchoolResponse> itemList;


    public MainAdapter(List<SchoolResponse> itemList, ItemClickListener itemClickListener) {

        this.itemList = itemList;
        this.itemClickListener = itemClickListener;

    }

    @NonNull
    @Override
    public MainAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_listing, parent, false);

        ItemViewHolder viewHolder = new ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, int position) {

        holder.itemView.setOnClickListener(v -> itemClickListener
                .onItemClick(null,itemList.get(holder.getAdapterPosition())));
        holder.mSchoolName.setText(itemList.get(position).getSchoolName());
        holder.mAddress.setText(itemList.get(position).getPrimaryAddressLine1());
        holder.mPhone.setText(itemList.get(position).getPhoneNumber());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView mSchoolName,mAddress,mPhone;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mSchoolName = itemView.findViewById(R.id.tv_school_name);
            mAddress = itemView.findViewById(R.id.tv_school_address);
            mPhone = itemView.findViewById(R.id.tv_phone);

        }
    }

}
