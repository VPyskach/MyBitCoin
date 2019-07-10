package com.test.mybitcoin.registration;

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

public class CreateAccountFragment extends Fragment {

    public static CreateAccountFragment newInstance() {
        CreateAccountFragment fragment = new CreateAccountFragment();
        return fragment;
    }

    private OnFragmentListener onFragmentListener;
    private EditText editPhoneNumber;
    private Button buttonCreateAccount;
    private TextView textHaveAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_create_account, container, false);
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
        editPhoneNumber = view.findViewById(R.id.editPhoneNumber);
        buttonCreateAccount = view.findViewById(R.id.buttonCreateAccount);
        buttonCreateAccount.setOnClickListener(buttonCreateAccountOnClick);
        textHaveAccount = view.findViewById(R.id.textHaveAccount);
        textHaveAccount.setOnClickListener(textHaveAccountOnClick);
    }

    private View.OnClickListener buttonCreateAccountOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (onFragmentListener != null){
                onFragmentListener.changeFragment(ConfirmNumberFragment.newInstance());
            }
        }
    };

    private View.OnClickListener textHaveAccountOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

}
