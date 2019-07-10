package com.test.mybitcoin.buy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.test.mybitcoin.R;

import java.util.Objects;

public class BuyBTCFragment2 extends Fragment{

    public static BuyBTCFragment2 newInstance() {
        return new BuyBTCFragment2();
    }

    private String TITLE;
    private Context context;
    private OnBuyBTCFragment2Listener onBuyBTCFragment2Listener;
    private TextView textYouBuy;
    private TextView textToPay;
    private TextView textSend;
    private TextView textWalletNumber;
    private TextView textComment;
    private ImageView imageCopy1;
    private ImageView imageCopy2;
    private Button buttonPaid;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof OnBuyBTCFragment2Listener) {
            onBuyBTCFragment2Listener = (OnBuyBTCFragment2Listener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        TITLE = context.getResources().getString(R.string.buy_BTC);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_btcfragment2, container, false);
        buttonPaid = view.findViewById(R.id.buttonPaid);
        buttonPaid.setOnClickListener(buttonPaidOnClick);
        textYouBuy = view.findViewById(R.id.textYouBuy);
        textToPay = view.findViewById(R.id.textToPay);
        textSend = view.findViewById(R.id.textSend);
        textWalletNumber = view.findViewById(R.id.textWalletNumber);
        textComment = view.findViewById(R.id.textComment);
        imageCopy1 = view.findViewById(R.id.imageCopy1);
        imageCopy1.setOnClickListener(imageCopy1OnClick);
        imageCopy2 = view.findViewById(R.id.imageCopy2);
        imageCopy2.setOnClickListener(imageCopy2OnClick);
        Objects.requireNonNull(getActivity()).setTitle(TITLE);
        return view;
    }

    private View.OnClickListener buttonPaidOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBuyBTCFragment2Listener.goToBuyBTCFragment3();
        }
    };

    private View.OnClickListener imageCopy1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            v.startAnimation(AnimationUtils.loadAnimation(context, R.anim.imag_animation));
            Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener imageCopy2OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            v.startAnimation(AnimationUtils.loadAnimation(context, R.anim.imag_animation));
            Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onDetach() {
        super.onDetach();
        onBuyBTCFragment2Listener = null;
        context = null;
    }

    public interface OnBuyBTCFragment2Listener {
        // TODO: Update argument type and name
        void goToBuyBTCFragment3();
    }
}
