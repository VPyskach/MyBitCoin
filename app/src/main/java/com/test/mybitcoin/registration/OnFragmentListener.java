package com.test.mybitcoin.registration;

import android.support.v4.app.Fragment;

interface OnFragmentListener {
    void startLoading();
    void finishLoading(int resultCode);
    void back();
    void goToMainActivity();
    void changeFragment(Fragment fragment);
}
