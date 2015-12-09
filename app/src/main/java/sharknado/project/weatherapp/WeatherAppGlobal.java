package sharknado.project.weatherapp;

import android.app.Application;

import org.androidannotations.annotations.EApplication;

import java.util.ArrayList;
import java.util.List;

import sharknado.project.weatherapp.responses.getCurrentWeather;

/**
 * Created by Michael Leffert on 10/29/2015.
 */
@EApplication
public class WeatherAppGlobal extends Application{


    public boolean hasParseStarted = false;
    public int selectedIndex;
    public List<String> locations;
    public List<getCurrentWeather> currentWeather;

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public void setCurrentWeather(List<getCurrentWeather> currentWeather) {
        this.currentWeather = currentWeather;
    }

    public List<getCurrentWeather> getCurrentWeather() {
        return currentWeather;
    }

    public boolean isHasParseStarted() {
        return hasParseStarted;
    }

    public void setHasParseStarted(boolean hasParseStarted) {
        this.hasParseStarted = hasParseStarted;
    }
}
