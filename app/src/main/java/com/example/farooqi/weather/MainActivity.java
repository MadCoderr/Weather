package com.example.farooqi.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.farooqi.weather.Pojo.City;
import com.example.farooqi.weather.Pojo.NetwokUtils;
import com.example.farooqi.weather.adapter.MainAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import cz.msebera.android.httpclient.Header;
import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText cityName;
    RecyclerView recycler;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = findViewById(R.id.edt_city_name_main);
        recycler = findViewById(R.id.rec_view_main);

        recycler.setLayoutManager(new LinearLayoutManager(this));

    }

    public void searchCity(View view) {
        String name = cityName.getText().toString();
        String query = "http://api.apixu.com/v1/search.json?key=6bed69052a864d44a8e165653183008&q=" + name;

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(query, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(final int statusCode,
                    final Header[] headers, final JSONArray response) {
                adapter = new MainAdapter(MainActivity.this, City.getCities(response));
                recycler.setAdapter(adapter);
            }

            @Override
            public void onFailure(final int statusCode, final Header[] headers, final String responseString,
                    final Throwable throwable) {
                Toast.makeText(MainActivity.this,
                        "no city found", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
