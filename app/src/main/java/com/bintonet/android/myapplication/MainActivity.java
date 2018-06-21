package com.bintonet.android.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnFragmentInteractionListener, FragmentTwo.OnFragmentInteractionListener, FragmentThree.OnFragmentInteractionListener {


    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    onSectionAttached(1);
                    return true;
                case R.id.navigation_dashboard:
                    onSectionAttached(2);
                    return true;
                case R.id.navigation_notifications:
                    onSectionAttached(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        if (savedInstanceState == null) {
            // on first time to display view for first navigation item based on the number
            onSectionAttached(1); // set this number to the default fragment
            navigation.setSelectedItemId(R.id.navigation_home);
        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onSectionAttached(int number) {
        // update the main content by replacing fragments
        Fragment fragment = null;

        switch (number) {
            case 1:
                fragment = new FragmentOne();
                break;
            case 2:
                fragment = new FragmentTwo();
                break;
            case 3:
                fragment = new FragmentThree();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, fragment).commit();

        }
    }

}
