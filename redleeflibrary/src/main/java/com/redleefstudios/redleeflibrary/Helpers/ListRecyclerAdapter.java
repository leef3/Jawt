package com.redleefstudios.redleeflibrary.Helpers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.redleefstudios.redleeflibrary.R;

import java.util.ArrayList;

/**
 * Created by Fred on 3/28/2016.
 */
public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.ViewHolder> {

    private ArrayList<TwoLineDataObject> itemData;

    public ListRecyclerAdapter(ArrayList<TwoLineDataObject> itemData)
    {
        this.itemData = itemData;
    }

    @Override
    public ListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_list, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        viewHolder.mLargeText.setText(itemData.get(position).GetLargeText());
        viewHolder.mSmallText.setText(itemData.get(position).GetSmallText());
        viewHolder.mImage.setImageResource(itemData.get(position).GetImageUrl());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mLargeText;
        public TextView mSmallText;
        public ImageView mImage;

        public ViewHolder(View itemLayoutView)
        {
            super(itemLayoutView);
            mLargeText = (TextView)itemLayoutView.findViewById(R.id.cardTextLarge);
            mSmallText = (TextView)itemLayoutView.findViewById(R.id.cardTextSmall);
            mImage = (ImageView)itemLayoutView.findViewById(R.id.small_card_image);
        }
    }

    @Override
    public int getItemCount()
    {
        return itemData.size();
    }
}
