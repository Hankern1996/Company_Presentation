package com.example.hannahkern.company_presentation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by hannahkern on 20.02.18.
 */

public class MenuActivity extends AppCompatActivity {

    boolean mIsDualPane;



    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(getLayoutResId());

        View companyView = findViewById(R.id.detail_fragment_container);
        mIsDualPane = companyView != null && companyView.getVisibility() == View.VISIBLE;


        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        Fragment fragment1 = fm.findFragmentById(R.id.detail_fragment_container);


        Intent intent = getIntent();
        String action =  intent.getAction();
        int value = intent.getIntExtra("id",0);

        if (mIsDualPane != true){
        if (fragment == null) {



            if (value ==0){
                fragment = new PresentationFragment();
                fm.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit();
            }
            else if (value ==1){

                fragment = new HomepageFragment();
                fm.beginTransaction()
                        .add(R.id.fragment_container,fragment)
                        .commit();
            }

            else if (value ==2){
                fragment = new ContactFragment();
                fm.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit();
            }
            else if (value == 4){
                Intent intent1 = new Intent(MenuActivity.this, MapsActivity.class);
                MenuActivity.this.startActivity(intent1);


                /*fragment1 = new ListViewFragment();


               fm.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit();*/
            }
            else if (value ==3){
                fragment = new RssReader();
                fm.beginTransaction()
                        .add(R.id.fragment_container, fragment)
                        .commit();
            }


            /*fragment = new PresentationFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();*/
        }}

        else{





            if (fragment == null) {



            if (value ==0){
                fragment = new PresentationFragment();
                fragment1 = new  ListViewFragment();
                fm.beginTransaction()
                        .add(R.id.fragment_container, fragment1).add(R.id.detail_fragment_container,fragment)
                        .commit();
            }

            else if (value ==1){

                fragment = new HomepageFragment();
                fragment1 = new  ListViewFragment();

                fm.beginTransaction()
                        .add(R.id.fragment_container,fragment1).add(R.id.detail_fragment_container,fragment)
                        .commit();
            }

            else if (value ==2){
                fragment = new ContactFragment();
                fragment1 = new  ListViewFragment();

                fm.beginTransaction()
                        .add(R.id.fragment_container, fragment1).add(R.id.detail_fragment_container,fragment)
                        .commit();
            }
            else if (value == 4){
                Intent intent1 = new Intent(MenuActivity.this, MapsActivity.class);
                MenuActivity.this.startActivity(intent1);


                fragment1 = new ListViewFragment();


                fm.beginTransaction()
                        .add(R.id.fragment_container, fragment1)
                        .commit();
            }

            else if (value ==3){
                fragment = new RssReader();
                fragment1 = new  ListViewFragment();

                fm.beginTransaction()
                        .add(R.id.fragment_container, fragment1).add(R.id.detail_fragment_container,fragment)
                        .commit();
            }

            else {

                    fragment = new PresentationFragment();
                    fragment1 = new  ListViewFragment();
                    fm.beginTransaction()
                            .add(R.id.fragment_container, fragment1).add(R.id.detail_fragment_container,fragment)
                            .commit();
                }






            }
           /* else {
                if (value ==0){
                    fragment = new PresentationFragment();
                    fragment1 = new  ListViewFragment();
                    fm.beginTransaction()
                            .add(R.id.fragment_container, fragment1).replace(R.id.detail_fragment_container,fragment)
                            .commit();
                }

                else if (value ==1){

                    fragment = new HomepageFragment();
                    fm.beginTransaction()
                            .add(R.id.fragment_container,fragment1).replace(R.id.detail_fragment_container,fragment)
                            .commit();
                }

                else if (value ==2){
                    fragment = new ContactFragment();
                    fm.beginTransaction()
                            .add(R.id.fragment_container, fragment1).replace(R.id.detail_fragment_container,fragment)
                            .commit();
                }
                else if (value ==3){
                    fragment = new RssReader();
                    fm.beginTransaction()
                            .add(R.id.fragment_container, fragment1).replace(R.id.detail_fragment_container,fragment)
                            .commit();


                }
            }*/}









    }


}
