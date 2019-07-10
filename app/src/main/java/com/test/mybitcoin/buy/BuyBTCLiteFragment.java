package com.test.mybitcoin.buy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.test.mybitcoin.R;

import java.util.Objects;

public class BuyBTCLiteFragment extends Fragment {

    public static BuyBTCLiteFragment newInstance() {
        return new BuyBTCLiteFragment();
    }

    private String TITLE;
    private OnBuyBTCLiteFragmentListener onBuyBTCLiteFragmentListener;
    private Button buttonBuyBTC;
    private EditText editBuyBTC;
    private EditText editAddress;
    private TextView textAvailableReserve;
    private TextView textCourseExchange;
    private TextView textToPay;


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_btclite, container, false);
        Objects.requireNonNull(getActivity()).setTitle(TITLE);
        buttonBuyBTC = view.findViewById(R.id.buttonBuyBTC);
        buttonBuyBTC.setOnClickListener(buttonBuyBTCOnClick);
        editBuyBTC = view.findViewById(R.id.editBuyBtcLite);
        editAddress = view.findViewById(R.id.editAddressLite);
        textAvailableReserve = view.findViewById(R.id.textAvailableReserveLite);
        textCourseExchange = view.findViewById(R.id.textCourseExchangeLite);
        textToPay = view.findViewById(R.id.textToPayLite);
        return view;
    }

    private View.OnClickListener buttonBuyBTCOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBuyBTCLiteFragmentListener.goToSite();
        }
    };

    @Override
    public void onDetach() {
        super.onDetach();
        onBuyBTCLiteFragmentListener = null;
    }

    public interface OnBuyBTCLiteFragmentListener {
        void goToSite();
    }
}
