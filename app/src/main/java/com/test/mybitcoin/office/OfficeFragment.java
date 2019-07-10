package com.test.mybitcoin.office;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.mybitcoin.R;
import com.test.mybitcoin.office.model.OfficeItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OfficeFragment extends Fragment {

    private String TITLE;
    private ViewPager viewPager;

    public static OfficeFragment newInstance() {
        return  new OfficeFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        TITLE = context.getResources().getString(R.string.menu_office);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_office, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), getOffices()));
        Objects.requireNonNull(getActivity()).setTitle(TITLE);
        return view;
    }

    private List<OfficeItem> getOffices(){
        List<OfficeItem> list = new ArrayList<>();
        list.add(new OfficeItem("LITECOIN", "15,93738928", "430 218.55"));
        list.add(new OfficeItem("BITCOIN", "15,93738928", "430 2158.55"));
        return list;
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter{

        private List<OfficeItem> list = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager fm, List<OfficeItem> list) {
            super(fm);
            this.list.addAll(list);
        }

        @Override
        public Fragment getItem(int i) {
            return OfficeItemFragment.newInstance(list.get(i));
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
