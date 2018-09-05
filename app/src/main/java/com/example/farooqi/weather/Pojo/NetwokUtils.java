package com.example.farooqi.weather.Pojo;

import android.os.Debug;
import android.util.Log;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import cz.msebera.android.httpclient.Header;
import org.json.JSONArray;

/**
 * Created by Farooqi on 9/5/2018.
 */

public class NetwokUtils {
    public static void getCityNames(String query) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(query, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(final int statusCode,
                    final Header[] headers, final JSONArray response) {
                Log.i("network", response.toString());
            }
        });
    }
}
