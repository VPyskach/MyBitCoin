package com.test.mybitcoin.registration;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.test.mybitcoin.R;

public class ConfirmNumberFragment extends Fragment {

    public static ConfirmNumberFragment newInstance() {
        ConfirmNumberFragment fragment = new ConfirmNumberFragment();
        return fragment;
    }

    private OnFragmentListener onFragmentListener;
    private EditText editConfirmCode;
    private Button buttonConfirmNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirm_number, container, false);
        initViews(view);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentListener) {
            onFragmentListener = (OnFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        onFragmentListener = null;
    }
    private void initViews(View view){
        editConfirmCode = view.findViewById(R.id.editConfirmCode);
        buttonConfirmNumber = view.findViewById(R.id.buttonConfirmNumber);
        buttonConfirmNumber.setOnClickListener(buttonConfirmNumberOnClick);
    }

    private View.OnClickListener buttonConfirmNumberOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onFragmentListener.goToMainActivity();
        }
    };
}
