package com.example.ragasoft.appuniverse.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ragasoft.appuniverse.Adapter.Notification_Fragment_Adapter;
import com.example.ragasoft.appuniverse.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NotificationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class NotificationFragment extends Fragment
{
    View view;
    Toolbar toolbar;
    Context context;
    RecyclerView recycler_View ;
    RecyclerView.Adapter recyclerView_adapter;
    RecyclerView.LayoutManager recyclerView_LayoutManager;
    private OnFragmentInteractionListener mListener;
    String[] name = {"Mehar Singh","Mehar Singh","Mehar Singh","Mehar Singh"};
    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_notification, container, false);
        context = getActivity();
        toolbar = view.findViewById(R.id.toolbar_notification);
        toolbar.setTitle("Notification");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.navicon);
        recycler_View = view.findViewById(R.id.recyclerview);
        recyclerView_LayoutManager = new GridLayoutManager(context,1);
        recycler_View.setLayoutManager(recyclerView_LayoutManager);
        recyclerView_adapter = new Notification_Fragment_Adapter(context,name);
        recycler_View.setAdapter(recyclerView_adapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
