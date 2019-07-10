package com.test.mybitcoin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.test.mybitcoin.about.AboutFragment;
import com.test.mybitcoin.buy.BuyActivity;
import com.test.mybitcoin.history.HistoryFragment;
import com.test.mybitcoin.office.OfficeFragment;
import com.test.mybitcoin.office.OfficeItemFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OfficeItemFragment.OnOfficeItemFragmentListener {

    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        if (getSupportFragmentManager().getFragments().size() == 0)
            changeFragment(OfficeFragment.newInstance());
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerMain, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_office) {
            changeFragment(OfficeFragment.newInstance());
        } else if (id == R.id.nav_history) {
            changeFragment(HistoryFragment.newInstance());
        } else if (id == R.id.nav_about) {
            changeFragment(AboutFragment.newInstance());
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void goToBuyActivity(String title) {
        Intent intent = new Intent(MainActivity.this, BuyActivity.class);
        intent.putExtra(Constans.TITLE_ID, title);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data == null) {
            return;
        }else{
            int code = data.getIntExtra(Constans.ITEM_POSITION, 0);
            if(code == 1) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containerMain, HistoryFragment.newInstance())
                        .commitAllowingStateLoss();
                navigationView.getMenu().getItem(1).setChecked(true);
            }
        }

    }
}
