package com.example.ragasoft.appuniverse.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.ragasoft.appuniverse.R;


public class EditProfileFragment extends Fragment
{
    View view;
    Toolbar toolbar,activty_toolbar;

    private OnFragmentInteractionListener mListener;

    public EditProfileFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view =  inflater.inflate(R.layout.fragment_edit_profile, container, false);
        toolbar = view.findViewById(R.id.toolbar_edit_profile);

        activty_toolbar = ((AppCompatActivity)getActivity()).findViewById(R.id.toolbar_activity);
        if (activty_toolbar.getVisibility()==View.VISIBLE){
            activty_toolbar.setVisibility(View.GONE);
        }
        toolbar.setVisibility(View.VISIBLE);
        toolbar.setTitle("Edit Profile");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.close);
        toolbar.inflateMenu(R.menu.edit_profile_menu_icon);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                Toast.makeText(getActivity(), "click save", Toast.LENGTH_SHORT).show();
                return false;
            }
        });


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
