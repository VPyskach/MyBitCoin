package com.test.mybitcoin.registration;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.test.mybitcoin.MainActivity;
import com.test.mybitcoin.R;

public class RegistrationActivity extends AppCompatActivity implements OnFragmentListener{

    final String TAG = "myRegistrationActivity";
    private RelativeLayout contentLayout;
    private RelativeLayout loadLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        contentLayout = findViewById(R.id.contentLayout);
        loadLayout = findViewById(R.id.loadLayout);

        Log.i(TAG, String.valueOf(getSupportFragmentManager().getFragments().size()));
        if(getSupportFragmentManager().getFragments().size() == 0)
        showCreateAccountFragment();
    }

    private void showCreateAccountFragment(){
        Log.i(TAG, "CreateAccountFragment create");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, CreateAccountFragment.newInstance())
                .commit();
    }

    private void showConfirmNumberFragment(){
        Log.i(TAG, "ConfirmNumberFragment create");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, ConfirmNumberFragment.newInstance())
                .commit();
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void finishLoading(int resultCode){
        if(resultCode == 100){
            showConfirmNumberFragment();
        }
    }

    @Override
    public void back() {

    }

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void changeFragment(Fragment fragment) {
        Log.i(TAG,  fragment.toString() + " create");
        Log.i(TAG, String.valueOf(getSupportFragmentManager().getFragments().size()));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
