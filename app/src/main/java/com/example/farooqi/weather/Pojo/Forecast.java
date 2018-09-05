package com.example.farooqi.weather.Pojo;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Farooqi on 9/5/2018.
 */

public class Forecast {
    private String date;
    private double maxTemp;
    private double minTemp;
    private double humidity;
    private String condition;
    private String sunRise;
    private String sunSet;
    private String moonRise;
    private String moonSet;

    public Forecast(final String date, final double maxTemp, final double minTemp, final double humidity,
            final String condition,
            final String sunRise, final String sunSet, final String moonRise, final String moonSet) {
        this.date = date;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.humidity = humidity;
        this.condition = condition;
        this.sunRise = sunRise;
        this.sunSet = sunSet;
        this.moonRise = moonRise;
        this.moonSet = moonSet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(final double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(final double minTemp) {
        this.minTemp = minTemp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(final double humidity) {
        this.humidity = humidity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(final String condition) {
        this.condition = condition;
    }

    public String getSunRise() {
        return sunRise;
    }

    public void setSunRise(final String sunRise) {
        this.sunRise = sunRise;
    }

    public String getSunSet() {
        return sunSet;
    }

    public void setSunSet(final String sunSet) {
        this.sunSet = sunSet;
    }

    public String getMoonRise() {
        return moonRise;
    }

    public void setMoonRise(final String moonRise) {
        this.moonRise = moonRise;
    }

    public String getMoonSet() {
        return moonSet;
    }

    public void setMoonSet(final String moonSet) {
        this.moonSet = moonSet;
    }

}
