package com.test.mybitcoin.buy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.mybitcoin.R;

import java.util.Objects;

public class BuyBTCLiteFragment extends Fragment {

    private String TITLE;

    public static BuyBTCLiteFragment newInstance() {

        return new BuyBTCLiteFragment();
    }

    private OnBuyBTCLiteFragmentListener onBuyBTCLiteFragmentListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_btclite, container, false);
        Objects.requireNonNull(getActivity()).setTitle(TITLE);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBuyBTCLiteFragmentListener) {
            onBuyBTCLiteFragmentListener = (OnBuyBTCLiteFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        TITLE = context.getResources().getString(R.string.buy_BTC);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onBuyBTCLiteFragmentListener = null;
    }

    public interface OnBuyBTCLiteFragmentListener {
        // TODO: Update argument type and name
        void goToSite();
    }
}
