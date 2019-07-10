package com.test.mybitcoin.office;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.test.mybitcoin.R;
import com.test.mybitcoin.office.model.OfficeItem;

public class OfficeItemFragment extends Fragment {

    private static final String BITCOIN = "bitcoin";
    private static final String LITECOIN = "litecoin";
    private static final String ID_TITLE = "title";
    private static final String ID_RESERVE = "reserve";
    private static final String ID_COURSE = "course";
    private String title = "";
    private String reserve = "";
    private String course = "";
    private OnOfficeItemFragmentListener mListener;

    private TextView textTitle;
    private TextView textReserve;
    private TextView textCourse;
    private ImageView imageBtc1;
    private ImageView imageBtc2;
    private ImageView imageBtc3;
    private RelativeLayout buttonBuy;

    public static OfficeItemFragment newInstance(OfficeItem item) {
        OfficeItemFragment fragment = new OfficeItemFragment();
        Bundle args = new Bundle();
        args.putString(ID_TITLE, item.getTitle());
        args.putString(ID_RESERVE, item.getReserve());
        args.putString(ID_COURSE, item.getCourse());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ID_TITLE);
            reserve = getArguments().getString(ID_RESERVE);
            course = getArguments().getString(ID_COURSE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_office_item, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view){
        textTitle = view.findViewById(R.id.textTitle);
        textTitle.setText(title.toUpperCase());
        textReserve = view.findViewById(R.id.textReserve);
        textReserve.setText(reserve);
        textCourse = view.findViewById(R.id.textCourse);
        textCourse.setText( " = " + course);
        imageBtc1 = view.findViewById(R.id.btcImage1);
        imageBtc2 = view.findViewById(R.id.btcImage2);
        imageBtc3 = view.findViewById(R.id.btcImage3);
        if (title.toLowerCase().equals(LITECOIN.toLowerCase())) {
            imageBtc1.setVisibility(View.GONE);
            imageBtc2.setVisibility(View.GONE);
            imageBtc3.setVisibility(View.GONE);
        }
        buttonBuy = view.findViewById(R.id.buttonBuy);
        buttonBuy.setOnClickListener(buttonBuyOnClick);

    }

    private View.OnClickListener buttonBuyOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mListener.goToBuyActivity(title);
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnOfficeItemFragmentListener) {
            mListener = (OnOfficeItemFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnOfficeItemFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnOfficeItemFragmentListener {
        void goToBuyActivity(String title);
    }
}
