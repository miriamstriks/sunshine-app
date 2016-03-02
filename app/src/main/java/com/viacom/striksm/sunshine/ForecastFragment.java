package com.viacom.striksm.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by striksm on 2/25/16.
 */
public class ForecastFragment extends Fragment {

    private static final String TAG = ForecastFragment.class.getSimpleName();

    ArrayAdapter<String> mForecastAdapter;

    public ForecastFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add this line in order for this fragment to handle menu events.
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.forecast_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            FetchWeatherTask fetchWeatherTask = new FetchWeatherTask();
            fetchWeatherTask.execute();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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

        setHasOptionsMenu(true);

        return rootView;
    }

}
