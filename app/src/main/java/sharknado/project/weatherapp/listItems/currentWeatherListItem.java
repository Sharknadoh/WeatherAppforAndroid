package sharknado.project.weatherapp.listItems;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import sharknado.project.weatherapp.R;
import sharknado.project.weatherapp.responses.CurrentObservations.current_observation;
import sharknado.project.weatherapp.responses.forecast.forecast;
import sharknado.project.weatherapp.responses.getCurrentWeather;
import sharknado.project.weatherapp.responses.hourly_forecast.hourly_forecast;

/**
 * Created by Michael Leffert on 12/8/2015.
 */
@EViewGroup(R.layout.current_weather_list_item)
public class currentWeatherListItem extends RelativeLayout {


    public currentWeatherListItem(Context context) {
        super(context);
    }


    @ViewById
    ImageView ivWeatherIcon;
    @ViewById
    TextView tvLocation;
    @ViewById
    TextView tvTemp;
    @ViewById
    TextView tvDescription;

    public void bind(getCurrentWeather current){
        current_observation currentObservation = current.getCurrent_observation();
        forecast currentForecast = current.getForecast();
        hourly_forecast [] curretHourlyForecast = current.getHourly_forecast();

    tvLocation.setText(currentObservation.getDisplay_location().getFull());
    tvTemp.setText(curretHourlyForecast[0].getTemp().getEnglish() + " \u2109");
    tvDescription.setText(currentObservation.getWeather());


    switch (currentObservation.getIcon()){

        case "chancerain":
           ivWeatherIcon.setImageResource(R.drawable.chancerain);
            break;
        case "chancesnow":
            ivWeatherIcon.setImageResource(R.drawable.chancesnow);

            break;
        case "chancetstorms":
            ivWeatherIcon.setImageResource(R.drawable.chancetstorms);

            break;
        case "clear":
            ivWeatherIcon.setImageResource(R.drawable.clear);

            break;
        case "cloudy":
            ivWeatherIcon.setImageResource(R.drawable.cloudy);

            break;
        case "fog":
            ivWeatherIcon.setImageResource(R.drawable.fog);
            break;
        case "mostlycloudy":
            ivWeatherIcon.setImageResource(R.drawable.mostlycloudy);
            break;
        case "mostlysunny":
            ivWeatherIcon.setImageResource(R.drawable.mostlysunny);
            break;
        case "partlycloudy":
            ivWeatherIcon.setImageResource(R.drawable.partialycloudy);
            break;
        case "partlysunny":
            ivWeatherIcon.setImageResource(R.drawable.partialysunny);
            break;
        case "rain":
            ivWeatherIcon.setImageResource(R.drawable.rain);
            break;
        case "sleet":
            ivWeatherIcon.setImageResource(R.drawable.sleet);
            break;
        case "snow":
            ivWeatherIcon.setImageResource(R.drawable.snow);
            break;
        case "tstorms":
            ivWeatherIcon.setImageResource(R.drawable.tstorms);
            break;
        default:
            break;
    }






    }


}
