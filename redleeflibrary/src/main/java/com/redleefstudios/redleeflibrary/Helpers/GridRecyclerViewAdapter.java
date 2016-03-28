package com.redleefstudios.redleeflibrary.Helpers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redleefstudios.redleeflibrary.R;

import java.util.List;


public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewHolders> {

    private List<GridViewObject> itemList;
    private Context context;

    public GridRecyclerViewAdapter(Context context, List<GridViewObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public GridRecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid, null);
        GridRecyclerViewHolders rcv = new GridRecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(GridRecyclerViewHolders holder, int position) {
        holder.countryName.setText(itemList.get(position).getName());
        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}