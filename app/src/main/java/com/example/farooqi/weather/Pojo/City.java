package com.example.farooqi.weather.Pojo;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// this pojo class well be used
// when user first search for city name
public class City {
    private String cityName;
    private String countryName;
    private double longitude;
    private double latitude;


    public City(final String cityName, final String countryName,
            final double longitude, final double latitude) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public City(final String cityName, final String countryName) {
        this.cityName = cityName;
        this.countryName = countryName;

    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(final double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(final double latitude) {
        this.latitude = latitude;
    }

    public static List<City> getCities(JSONArray array) {
        List<City> list = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {
            try {
                JSONObject object = array.getJSONObject(i);

                list.add(new City(object.getString("name"),
                              object.getString("country")));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return  list;
    }
}
