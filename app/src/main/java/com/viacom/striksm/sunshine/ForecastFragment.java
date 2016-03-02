package com.viacom.striksm.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by striksm on 2/25/16.
 */
public class ForecastFragment extends Fragment {

    private static final String TAG =ForecastFragment.class.getSimpleName();

    ArrayAdapter<String> mForecastAdapter;

    public ForecastFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        ArrayList<String> mockData = new ArrayList<>();
        mockData.add("today - sunny - 88/63");
        mockData.add("tomorrow - foggy - 70/46");
        mockData.add("weds - foggy - 70/46");
        mockData.add("thurs - foggy - 70/46");
        mockData.add("fri - foggy - 70/46");
        mockData.add("sat - foggy - 70/46");
        mockData.add("today - sunny - 88/63");
        mockData.add("tomorrow - foggy - 70/46");
        mockData.add("weds - foggy - 70/46");
        mockData.add("thurs - foggy - 70/46");
        mockData.add("fri - foggy - 70/46");
        mockData.add("sat - foggy - 70/46");


        mForecastAdapter = new ArrayAdapter<>(getActivity(),
                R.layout.list_item_forecast, R.id.list_item_forecast_textview, mockData);

        container.removeAllViews();
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listview = (ListView) rootView.findViewById(R.id.listview_forecast);
        listview.setAdapter(mForecastAdapter);

        return rootView;
    }

}
