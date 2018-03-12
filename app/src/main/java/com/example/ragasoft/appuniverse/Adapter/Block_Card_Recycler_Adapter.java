package com.example.ragasoft.appuniverse.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ragasoft.appuniverse.R;

/**
 * Created by Payal on 3/7/2018.
 */

public class Block_Card_Recycler_Adapter extends RecyclerView.Adapter<Block_Card_Recycler_Adapter.ViewHolder>
{
    int[] image;
    Context context;

    public Block_Card_Recycler_Adapter(Context contextt,int[] img)
    {
        this.context = contextt;
        this.image = img;
    }

    @Override
    public Block_Card_Recycler_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.card_block_transaction_adapter,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Block_Card_Recycler_Adapter.ViewHolder holder, int position)
    {
        holder.imageView.setImageResource(image[position]);

    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;

        public ViewHolder(View itemView)
        {
            super(itemView);
            imageView = itemView.findViewById(R.id.circleImageView);
        }
    }
}
