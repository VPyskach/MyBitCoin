package com.test.mybitcoin.buy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.test.mybitcoin.R;

import java.util.Objects;

public class BuyBTCFragment1 extends Fragment {


    public static BuyBTCFragment1 newInstance() {

        return new BuyBTCFragment1();
    }

    private String TITLE;
    private Context context;
    private OnBuyBTCFragment1Listener onBuyBTCFragment1Listener;
    private ImageView imageScanner;
    private Button buttonGoToPay;
    private EditText editBuyBTC;
    private EditText editAddress;
    private EditText editAppointment;
    private TextView textAvailableReserve;
    private TextView textCourseExchange;
    private TextView textToPay;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof OnBuyBTCFragment1Listener) {
            onBuyBTCFragment1Listener = (OnBuyBTCFragment1Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnOfficeItemFragmentListener");
        }
        TITLE = context.getResources().getString(R.string.buy_BTC);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_btcfragment1, container, false);
        Objects.requireNonNull(getActivity()).setTitle(TITLE);
        imageScanner = view.findViewById(R.id.imageScanner);
        imageScanner.setOnClickListener(imageScannerOnClick);
        buttonGoToPay = view.findViewById(R.id.buttonGoToPay);
        buttonGoToPay.setOnClickListener(buttonGoToPayOnClick);
        editBuyBTC = view.findViewById(R.id.editBuyBtc);
        editAddress = view.findViewById(R.id.editAddress);
        editAppointment = view.findViewById(R.id.editAppointment);
        textAvailableReserve = view.findViewById(R.id.textAvailableReserve);
        textCourseExchange = view.findViewById(R.id.textCourseExchange);
        textToPay = view.findViewById(R.id.textToPay);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onBuyBTCFragment1Listener = null;
        context = null;
    }
    private View.OnClickListener buttonGoToPayOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBuyBTCFragment1Listener.goToBuyBTCFragment2();
        }
    };

    private View.OnClickListener imageScannerOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            v.startAnimation(AnimationUtils.loadAnimation(context, R.anim.imag_animation));
            Toast.makeText(context, "Open scanner", Toast.LENGTH_SHORT).show();
        }
    };

    interface OnBuyBTCFragment1Listener{
        void goToBuyBTCFragment2();
    }
}
