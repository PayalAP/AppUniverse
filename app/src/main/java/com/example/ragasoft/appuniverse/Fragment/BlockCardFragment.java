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

import com.example.ragasoft.appuniverse.Adapter.Block_Card_Recycler_Adapter;
import com.example.ragasoft.appuniverse.Adapter.Notification_Fragment_Adapter;
import com.example.ragasoft.appuniverse.R;


public class BlockCardFragment extends Fragment
{
    View view;
    int images[] = {R.mipmap.ic_launcher,R.mipmap.ic_launcher_round};
    Toolbar toolbar;
    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerView_adapter;
    RecyclerView.LayoutManager recyclerView_LayoutManager;


    private OnFragmentInteractionListener mListener;

    public BlockCardFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_block_card, container, false);
        toolbar = view.findViewById(R.id.toolbar_card_block);
        toolbar.setVisibility(View.VISIBLE);
        toolbar.setTitle("Card Detail");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.arrow);
        context = getActivity();
        recyclerView = view.findViewById(R.id.recycler_card_block);
        recyclerView_LayoutManager = new GridLayoutManager(context,1);
        recyclerView.setLayoutManager(recyclerView_LayoutManager);
        recyclerView_adapter = new Block_Card_Recycler_Adapter(context,images);
        recyclerView.setAdapter(recyclerView_adapter);


        return view;
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
