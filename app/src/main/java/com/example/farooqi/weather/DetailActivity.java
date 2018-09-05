package com.example.farooqi.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.example.farooqi.weather.Pojo.Forecast;
import com.example.farooqi.weather.adapter.DetailAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import cz.msebera.android.httpclient.Header;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity {

    TextView cityName, countryName, regionName;
    RecyclerView recycler;
    DetailAdapter adapter;

    String date, condition, sunSet, sunRise, moonSet, moonRise;
    double maxTemp, minTemp, humidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        cityName = findViewById(R.id.lbl_city_name);
        countryName = findViewById(R.id.lbl_country_name);
        regionName = findViewById(R.id.lbl_reqion_name);
        recycler = findViewById(R.id.rec_view_detail);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        String name = getIntent().getStringExtra("city_name");
        int days = 10;
        String url = "http://api.apixu.com/v1/forecast.json?key=6bed69052a864d44a8e165653183008&q=";
        String query = url + name + "&days=" + days;


        AsyncHttpClient client = new AsyncHttpClient();
        client.get(query, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(final int statusCode,
                    final Header[] headers, final JSONObject response) {
                try {

                    cityName.setText(response.getJSONObject("location").getString("name"));
                    regionName.setText(response.getJSONObject("location").getString("region"));
                    countryName.setText(response.getJSONObject("location").getString("country"));

                    adapter = new DetailAdapter(DetailActivity.this,
                            getForecasts(response));
                    recycler.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(final int statusCode, final Header[] headers, final String responseString,
                    final Throwable throwable) {
                Toast.makeText(DetailActivity.this,
                        "no result found", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public List<Forecast> getForecasts(JSONObject object) throws JSONException {
        List<Forecast> list = new ArrayList<>();
        JSONArray forecast = object.getJSONObject("forecast").getJSONArray("forecastday");
        Log.i("forecast", forecast.toString());
        for (int i = 0; i < forecast.length(); i++) {
            JSONObject ob = forecast.getJSONObject(i);
            date = ob.getString("date");
            maxTemp = ob.getJSONObject("day").getDouble("maxtemp_c");
            minTemp = ob.getJSONObject("day").getDouble("mintemp_c");
            humidity = ob.getJSONObject("day").getDouble("avghumidity");
            condition = ob.getJSONObject("day").getJSONObject("condition").getString("text");

            JSONObject astro = ob.getJSONObject("astro");
            sunSet = astro.getString("sunset");
            sunRise = astro.getString("sunrise");
            moonSet = astro.getString("moonset");
            moonRise = astro.getString("moonrise");

            list.add(new Forecast(date, maxTemp, minTemp, humidity,
                   condition, sunRise, sunSet, moonRise, moonSet));
        }

        return list;
    }
}
