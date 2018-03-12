package com.example.ragasoft.appuniverse.Adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ragasoft.appuniverse.R;

/**
 * Created by Payal on 3/5/2018.
 */

public class Notification_Fragment_Adapter extends RecyclerView.Adapter<Notification_Fragment_Adapter.ViewHolder>
{

    String [] name;
    Context contextt;

    public Notification_Fragment_Adapter(Context context2 ,String[] values2)
    {
        contextt = context2;
        name  = values2;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ConstraintLayout constraintLayout;
        TextView user_name;

        public ViewHolder(View itemView)
        {
            super(itemView);
            user_name = itemView.findViewById(R.id.name);
        }
    }

    @Override
    public Notification_Fragment_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contextt).inflate(R.layout.notification_fragment_adapter,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.user_name.setText(name[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }


}
