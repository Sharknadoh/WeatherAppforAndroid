package sharknado.project.weatherapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import sharknado.project.weatherapp.listItems.currentWeatherListItem;
import sharknado.project.weatherapp.listItems.currentWeatherListItem_;
import sharknado.project.weatherapp.responses.CurrentObservations.current_observation;
import sharknado.project.weatherapp.responses.getCurrentWeather;

/**
 * Created by Michael Leffert on 12/8/2015.
 */
@EBean
public class currentWeatherAdapter extends BaseAdapter {

    List<getCurrentWeather> current = new ArrayList<getCurrentWeather>();

    @AfterInject
    void onAfterInject(){

    }

    @RootContext
    Context context;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       currentWeatherListItem currentItemView;
        if (convertView == null) {
            currentItemView = currentWeatherListItem_.build(context);
        } else {
            currentItemView = (currentWeatherListItem) convertView;
        }


        currentItemView.bind((getCurrentWeather) getItem(position));

        return currentItemView;


    }


    @Override
    public int getCount() {
        return current.size();
    }

    @Override
    public Object getItem(int position) {
        return current.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setCurrent (List<getCurrentWeather> current){
        this.current = current;
    }




}
