package com.navigationview_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by SONU on 21/03/16.
 */
public class Dummy_Fragment extends Fragment {

    public Dummy_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dummy_fragment, container, false);

        TextView text = (TextView) view.findViewById(R.id.fragment_textview);

        //Get bundle data from arguments and set text over textview
        String title = getArguments().getString("data");
        text.setText(title);

        return view;
    }
}
