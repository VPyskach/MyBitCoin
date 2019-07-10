package com.test.mybitcoin.buy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.test.mybitcoin.Constans;
import com.test.mybitcoin.R;


public class BuyActivity extends AppCompatActivity implements BuyBTCFragment1.OnBuyBTCFragment1Listener,
        BuyBTCFragment2.OnBuyBTCFragment2Listener, BuyBTCFragment3.OnBuyBTCFragment3Listener,
        BuyBTCLiteFragment.OnBuyBTCLiteFragmentListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarBuy);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Intent intent = getIntent();
        String title = intent.getStringExtra(Constans.TITLE_ID);
        if (getSupportFragmentManager().getFragments().size() == 0)
            if (title.equals("LITECOIN"))
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containerBuy, BuyBTCLiteFragment.newInstance())
                        .commit();
            else
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containerBuy, BuyBTCFragment1.newInstance())
                        .commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void goToBuyBTCFragment2() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerBuy, BuyBTCFragment2.newInstance())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToBuyBTCFragment3() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerBuy, BuyBTCFragment3.newInstance())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToHistory() {
        Intent intent = new Intent();
        intent.putExtra(Constans.ITEM_POSITION, 1);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void goToSite() {

    }
}
