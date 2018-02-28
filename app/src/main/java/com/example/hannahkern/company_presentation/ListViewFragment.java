package com.example.hannahkern.company_presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by hannahkern on 19.02.18.
 */

public class ListViewFragment extends android.support.v4.app.Fragment{





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    String[] menue = { "About", "Homepage", "Contact", "RSS-Feed",
            "Location"};
    List<String> menueList = new ArrayList<>(Arrays.asList(menue));
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        ArrayAdapter<String> menueAdapter = new ArrayAdapter<>(getActivity(),R.layout.simple_row, R.id.rowTextView, menueList);

        ListView menueListView = (ListView)v.findViewById(R.id.mainListView);
        menueListView.setAdapter(menueAdapter);

        menueListView.setOnItemClickListener(mMessageClickHandler);

        return v;

    }
    private AdapterView.OnItemClickListener mMessageClickHandler = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent i = new Intent(getActivity(), MenuActivity.class);
            i.setAction(Intent.ACTION_SEND);
            i.putExtra("id",position);
            startActivity(i);

        }
    };






}
