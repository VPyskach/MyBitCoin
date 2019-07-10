package com.test.mybitcoin.about;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.mybitcoin.R;

import java.util.Objects;

public class AboutFragment extends Fragment {

    public static AboutFragment newInstance() {
        return new AboutFragment();
    }

    private String TITLE;
    private TextView textAbout;
    private Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        TITLE = context.getResources().getString(R.string.menu_about);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        textAbout = view.findViewById(R.id.textAbout);
        textAbout.setText(context.getResources().getString(R.string.about_fragment));
        Objects.requireNonNull(getActivity()).setTitle(TITLE);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        context = null;
    }
}
