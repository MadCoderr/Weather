package com.example.farooqi.weather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.farooqi.weather.Pojo.Forecast;
import com.example.farooqi.weather.R;
import java.util.List;

/**
 * Created by Farooqi on 9/5/2018.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailHolder> {

    private List<Forecast> forecastList;
    private Context context;

    public DetailAdapter(Context context, List<Forecast> list) {
        this.context = context;
        forecastList = list;
    }

    @Override
    public DetailHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.detail_list_main, parent, false);
        return new DetailHolder(view);
    }

    @Override
    public void onBindViewHolder(final DetailHolder holder, final int position) {
        Forecast forecast = forecastList.get(position);
        holder.date.setText(forecast.getDate());
        holder.maxTemp.setText(String.valueOf(forecast.getMaxTemp()));
        holder.minTemp.setText(String.valueOf(forecast.getMinTemp()));
        holder.humidity.setText(String.valueOf(forecast.getHumidity()));
        holder.condition.setText(forecast.getCondition());
        holder.sunSet.setText(forecast.getSunSet());
        holder.sunRise.setText(forecast.getSunRise());
        holder.moonSet.setText(forecast.getMoonSet());
        holder.moonRise.setText(forecast.getMoonRise());
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }


    public class DetailHolder extends ViewHolder {

        TextView date, maxTemp, minTemp, humidity, condition,
                 sunSet, sunRise, moonSet, moonRise;

        public DetailHolder(final View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.lbl_date_detail);
            maxTemp = itemView.findViewById(R.id.lbl_max_temp_detail);
            minTemp = itemView.findViewById(R.id.lbl_min_temp_detail);
            humidity = itemView.findViewById(R.id.lbl_hum_detail);
            condition = itemView.findViewById(R.id.lbl_cond_detail);
            sunSet = itemView.findViewById(R.id.lbl_sun_set_detail);
            sunRise = itemView.findViewById(R.id.lbl_sun_rise_detail);
            moonSet = itemView.findViewById(R.id.lbl_moon_set_detail);
            moonRise = itemView.findViewById(R.id.lbl_moon_rise_detail);


        }
    }

}
