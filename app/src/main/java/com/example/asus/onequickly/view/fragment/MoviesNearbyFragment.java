package com.example.asus.onequickly.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.onequickly.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesNearbyFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_nearby, container, false);
        return  view;

    }

}
