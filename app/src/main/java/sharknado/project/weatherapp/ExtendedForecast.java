package sharknado.project.weatherapp;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.SeekBarProgressChange;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import sharknado.project.weatherapp.responses.CurrentObservations.current_observation;
import sharknado.project.weatherapp.responses.forecast.forecast;
import sharknado.project.weatherapp.responses.getCurrentWeather;
import sharknado.project.weatherapp.responses.hourly_forecast.hourly_forecast;

/**
 * Created by Michael Leffert on 12/9/2015.
 */
@EActivity(R.layout.extended)
public class ExtendedForecast extends Activity {

    getCurrentWeather currentWeather;
    current_observation currentObservation;
    forecast currentForecast;
    hourly_forecast[] curretHourlyForecast;
    int offset;

    @App
    WeatherAppGlobal App;
    
    @ViewById
    ImageView mainImg, ivHourly, ivDay1, ivDay2, ivDay3, ivDay4,ivDay5;
    @ViewById
    TextView tvDay1, tvDay2, tvDay3, tvDay4, tvDay5,tvHourlyDate, tvHourlyConditions, tvHourlyTemp,
             tvLowTemp, tvHiTemp,tvDailyForecast, tvDate, tvExtendedLocation;
    @ViewById
    SeekBar sbHourly;
    ImageView [] dayImgs;
    TextView [] dayTv;

    @AfterViews
    void afterViews(){
        offset = 0;
        dayImgs = new ImageView[5];
        dayTv = new TextView[5];
        dayImgs[0] = ivDay1;
        dayImgs[1] = ivDay2;
        dayImgs[2] = ivDay3;
        dayImgs[3] = ivDay4;
        dayImgs[4] = ivDay5;
        dayTv[0] = tvDay1;
        dayTv[1] = tvDay2;
        dayTv[2] = tvDay3;
        dayTv[3] = tvDay4;
        dayTv[4] = tvDay5;

        currentWeather = App.getCurrentWeather().get(App.getSelectedIndex());
       currentObservation = currentWeather.getCurrent_observation();
       currentForecast = currentWeather.getForecast();
       curretHourlyForecast = currentWeather.getHourly_forecast(); 
       onProgressChanged(sbHourly, 0);
       setImage(mainImg,  currentForecast.getSimpleforecast().getForecastday()[0].getIcon());
       setMainTxt();
       setDays();
        
    }

    private void setDays(){

        for(int i = 0; i < 5; i++){
            setImage(dayImgs[i], currentForecast.getSimpleforecast().getForecastday()[i].getIcon());
            dayTv[i].setText(currentForecast.getSimpleforecast().getForecastday()[i].getDate().getWeekday());
        }

    }

    private void setMainTxt() {
        int myOffset = offset/24;

        tvExtendedLocation.setText(currentObservation.getDisplay_location().getFull());
        tvHiTemp.setText("High: " + currentForecast.getSimpleforecast().getForecastday()[0 + myOffset].getHigh().getFahrenheit() + " \u2109");
        tvLowTemp.setText("Low: " + currentForecast.getSimpleforecast().getForecastday()[0 + myOffset].getLow().getFahrenheit() + " \u2109");
        tvDate.setText(currentForecast.getSimpleforecast().getForecastday()[0 + myOffset].getDate().getMonthname() + " " +
                currentForecast.getSimpleforecast().getForecastday()[0 + myOffset].getDate().getDay() + ", " +
                currentForecast.getSimpleforecast().getForecastday()[0 + myOffset].getDate().getYear());

        if (curretHourlyForecast[0 + offset].getFCTTIME().getAmpm().equalsIgnoreCase("AM")) {
            tvDailyForecast.setText(currentForecast.getTxt_forecast().getForecastday()[0 + (myOffset * 2)].getFcttext());
        }else {
            tvDailyForecast.setText(currentForecast.getTxt_forecast().getForecastday()[1 + (myOffset * 2)].getFcttext());
        }


    }



    @SeekBarProgressChange(R.id.sbHourly)
    void onProgressChanged(SeekBar seekBar, int progress){
        tvHourlyConditions.setText(curretHourlyForecast[progress + offset].getWx());
        tvHourlyDate.setText(curretHourlyForecast[progress + offset].getFCTTIME().getPretty());
        tvHourlyTemp.setText(curretHourlyForecast[progress + offset].getTemp().getEnglish() + " \u2109");

         setImage(ivHourly, curretHourlyForecast[progress + offset].getIcon());


    }

    @Click({R.id.Day1, R.id.Day2, R.id.Day3, R.id.Day4, R.id.Day5 })
    void dayClicked(View clicked){
        int tag = Integer.parseInt(clicked.getTag().toString());
        offset = tag * 24;

        onProgressChanged(sbHourly, sbHourly.getProgress());
        setMainTxt();


    }


    public void setImage(ImageView view, String weather){
        switch (weather){
            case "chancerain":
                view.setImageResource(R.drawable.chancerain);
                break;
            case "chancesnow":
                view.setImageResource(R.drawable.chancesnow);

                break;
            case "chancetstorms":
                view.setImageResource(R.drawable.chancetstorms);

                break;
            case "clear":
                view.setImageResource(R.drawable.clear);

                break;
            case "cloudy":
                view.setImageResource(R.drawable.cloudy);

                break;
            case "fog":
                view.setImageResource(R.drawable.fog);
                break;
            case "mostlycloudy":
                view.setImageResource(R.drawable.mostlycloudy);
                break;
            case "mostlysunny":
                view.setImageResource(R.drawable.mostlysunny);
                break;
            case "partlycloudy":
                view.setImageResource(R.drawable.partialycloudy);
                break;
            case "partlysunny":
                view.setImageResource(R.drawable.partialysunny);
                break;
            case "rain":
                view.setImageResource(R.drawable.rain);
                break;
            case "sleet":
                view.setImageResource(R.drawable.sleet);
                break;
            case "snow":
                view.setImageResource(R.drawable.snow);
                break;
            case "tstorms":
                view.setImageResource(R.drawable.tstorms);
                break;
            default:
                break;
        }


    }


}
