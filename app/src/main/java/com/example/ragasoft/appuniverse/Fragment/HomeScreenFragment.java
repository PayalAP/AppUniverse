package com.example.ragasoft.appuniverse.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ragasoft.appuniverse.Adapter.ViewPager_Image_Adapter;
import com.example.ragasoft.appuniverse.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class HomeScreenFragment extends Fragment
{
    View view;
    int i;
    Handler handler;
    Timer swipeTimer;
    Runnable update;
    private ViewPager viewPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.

    private static Integer[] images= {R.drawable.cool,R.drawable.nature,R.drawable.download};
    ArrayList<Integer> imagearray;
    CirclePageIndicator circleIndicator;

    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home_screen, container, false);
        viewPager = view.findViewById(R.id.viewPager);

        circleIndicator = view.findViewById(R.id.circlePageIndicator);


        initViewPager();

        return view;
    }


    public void initViewPager()
    {
        imagearray = new ArrayList<>();
        for(i=0;i<images.length;i++)imagearray.add(images[i]);
        viewPager.setAdapter(new ViewPager_Image_Adapter(getActivity(),imagearray));
        viewPager.setOffscreenPageLimit(3);
        circleIndicator.setViewPager(viewPager);
        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        circleIndicator.setRadius(5 * density);
        NUM_PAGES =images.length;
        // Auto start of viewpager
         handler = new Handler();
         
        update = new Runnable()
        {
            public void run()
            {
                if (currentPage == NUM_PAGES-1)
                {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };
        
         swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 1000, 1000);

        // Pager listener over indicator
        circleIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position)
            {
                currentPage = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
