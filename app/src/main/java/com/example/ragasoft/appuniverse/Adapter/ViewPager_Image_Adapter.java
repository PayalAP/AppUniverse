package com.example.ragasoft.appuniverse.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ragasoft.appuniverse.R;
import com.example.ragasoft.appuniverse.interfaces.LoopingPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Payal on 2/28/2018.
 */

public class ViewPager_Image_Adapter extends PagerAdapter
{
    private ArrayList<Integer> images;
    private LayoutInflater inflater;
    private Context context;

    public ViewPager_Image_Adapter(Context context,ArrayList<Integer>images)
    {
        this.context = context;
        this.images=images;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount()
    {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        View imagelayout = inflater.inflate(R.layout.viewpager_images,container,false);
        assert imagelayout != null;
        ImageView image = imagelayout.findViewById(R.id.cool);
        image.setImageResource(images.get(position));
        container.addView(imagelayout,0);
        return imagelayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }


}
