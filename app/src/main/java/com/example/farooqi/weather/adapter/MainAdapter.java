package com.example.farooqi.weather.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.farooqi.weather.DetailActivity;
import com.example.farooqi.weather.Pojo.City;
import com.example.farooqi.weather.R;
import java.util.List;

/**
 * Created by Farooqi on 9/5/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private List<City> cities;
    private Context context;

    public  MainAdapter (Context context, List<City> list) {
        this.context = context;
        this.cities = list;
    }

    @Override
    public MainHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.main_list_item, parent, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(final MainHolder holder, final int position) {
        City city = cities.get(position);
        holder.cityName.setText(city.getCityName());
        holder.countryName.setText(city.getCountryName());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class MainHolder extends ViewHolder implements OnClickListener{

        TextView cityName;
        TextView countryName;

        public MainHolder(final View itemView) {
            super(itemView);

            cityName = itemView.findViewById(R.id.lbl_city_name_itme);
            countryName = itemView.findViewById(R.id.lbl_country_name_itme);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View view) {
            City city = cities.get(getAdapterPosition());
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("city_name", city.getCityName());
            context.startActivity(intent);
        }
    }
}
