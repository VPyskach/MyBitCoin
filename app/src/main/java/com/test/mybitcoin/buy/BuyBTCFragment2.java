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

public class BuyBTCFragment2 extends Fragment{

    private String TITLE;

    public static BuyBTCFragment2 newInstance() {
        return new BuyBTCFragment2();
    }

    private OnBuyBTCFragment2Listener onBuyBTCFragment2Listener;
    private Button buttonPaid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_btcfragment2, container, false);
        buttonPaid = view.findViewById(R.id.buttonPaid);
        buttonPaid.setOnClickListener(buttonPaidOnClick);
        Objects.requireNonNull(getActivity()).setTitle(TITLE);
        return view;
    }

    private View.OnClickListener buttonPaidOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBuyBTCFragment2Listener.goToBuyBTCFragment3();
        }
    };
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBuyBTCFragment2Listener) {
            onBuyBTCFragment2Listener = (OnBuyBTCFragment2Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        TITLE = context.getResources().getString(R.string.buy_BTC);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onBuyBTCFragment2Listener = null;
    }

    public interface OnBuyBTCFragment2Listener {
        // TODO: Update argument type and name
        void goToBuyBTCFragment3();
    }
}
