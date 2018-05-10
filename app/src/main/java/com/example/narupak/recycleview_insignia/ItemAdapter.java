package com.example.narupak.recycleview_insignia;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Narupak on 14/3/2561.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private Context context;
    private ArrayList<Item> itemList;
    public ItemAdapter(Context context, ArrayList<Item> itemList){
            this.context = context;
            this.itemList = itemList;
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        Picasso.get()
                .load(item.img)
                .placeholder(R.drawable.ic_launcher_background)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.ivImage);
        holder.tvDesc.setText(item.text);
    }

    @Override
    public int getItemCount() {
        if(itemList != null){
            return itemList.size();
        }
        return 0;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public CardView cvItem;
        public TextView tvDesc;
        public ImageView ivImage;
        public ItemViewHolder(View itemView){

            super(itemView);
            cvItem = (CardView)itemView.findViewById(R.id.cvItem);
            tvDesc = (TextView)itemView.findViewById(R.id.tvText);
            ivImage = (ImageView)itemView.findViewById(R.id.img_superman);
        }

    }

}
