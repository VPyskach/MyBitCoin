package com.test.mybitcoin.history;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.mybitcoin.R;
import com.test.mybitcoin.history.model.HistoryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class HistoryFragment extends Fragment {

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    private String TITLE;
    private RecyclerView recyclerView;
    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        TITLE = context.getResources().getString(R.string.menu_history);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.historyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new HistoryRecyclerAdapter(getList(), context));
        Objects.requireNonNull(getActivity()).setTitle(TITLE);
        return view;
    }

    List<HistoryItem> getList(){
        List<HistoryItem> list = new ArrayList<>();
        list.add(new HistoryItem(1, "15.12.2018", "492В-75С9-19ЕdfА-7АРС", "0,1 ВТС", "42 804.99 руб."));
        list.add(new HistoryItem(0, "15.12.2018", "492В-75С9-19ЕА-7АРС", "0,1 ВТС", "42 804.99 руб."));
        list.add(new HistoryItem(-1, "15.12.2018", "492В-75С9-19ЕА-7АРС", "0,1 ВТС", "42 804.99 руб."));
        list.add(new HistoryItem(1, "15.12.2018", "492В-75С9-19ЕА-7АРС", "0,1 ВТС", "42 804.99 руб."));
        list.add(new HistoryItem(1, "15.12.2018", "492В-75С9-19ЕА-7АРС", "0,1 ВТС", "42 804.99 руб."));
        return list;
    }

}
