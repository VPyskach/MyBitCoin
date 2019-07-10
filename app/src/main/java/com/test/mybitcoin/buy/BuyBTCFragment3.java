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


public class BuyBTCFragment3 extends Fragment{


    public static BuyBTCFragment3 newInstance() {
        return new BuyBTCFragment3();
    }

    private String TITLE;
    private OnBuyBTCFragment3Listener onBuyBTCFragment3Listener;
    private Button buttonGoToHistory;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBuyBTCFragment3Listener) {
            onBuyBTCFragment3Listener = (OnBuyBTCFragment3Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        TITLE = context.getResources().getString(R.string.payment_processing);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_btcfragment3, container, false);
        buttonGoToHistory = view.findViewById(R.id.buttonGoToHistory);
        buttonGoToHistory.setOnClickListener(buttonGoToHistoryOnClick);
        Objects.requireNonNull(getActivity()).setTitle(TITLE);
        return view;
    }

    private View.OnClickListener buttonGoToHistoryOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBuyBTCFragment3Listener.goToHistory();
        }
    };

    @Override
    public void onDetach() {
        super.onDetach();
        onBuyBTCFragment3Listener = null;
    }

    public interface OnBuyBTCFragment3Listener {
        void goToHistory();
    }
}
