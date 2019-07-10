package com.test.mybitcoin.buy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.test.mybitcoin.R;

import java.util.Objects;

public class BuyBTCFragment1 extends Fragment {

    private String TITLE;

    public static BuyBTCFragment1 newInstance() {

        return new BuyBTCFragment1();
    }

    private OnBuyBTCFragment1Listener onBuyBTCFragment1Listener;
    private Button buttonGoToPay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_btcfragment1, container, false);
        buttonGoToPay = view.findViewById(R.id.buttonGoToPay);
        buttonGoToPay.setOnClickListener(buttonGoToPayOnClick);
        Objects.requireNonNull(getActivity()).setTitle(TITLE);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBuyBTCFragment1Listener) {
            onBuyBTCFragment1Listener = (OnBuyBTCFragment1Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnOfficeItemFragmentListener");
        }
        TITLE = context.getResources().getString(R.string.buy_BTC);
    }
    @Override
    public void onDetach() {
        super.onDetach();
        onBuyBTCFragment1Listener = null;
    }
    private View.OnClickListener buttonGoToPayOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBuyBTCFragment1Listener.goToBuyBTCFragment2();
        }
    };

    interface OnBuyBTCFragment1Listener{
        void goToBuyBTCFragment2();
    }
}
