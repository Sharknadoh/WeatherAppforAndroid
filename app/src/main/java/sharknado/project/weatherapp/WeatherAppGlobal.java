package sharknado.project.weatherapp;

import android.app.Application;

import org.androidannotations.annotations.EApplication;

/**
 * Created by Michael Leffert on 10/29/2015.
 */
@EApplication
public class WeatherAppGlobal extends Application{


    public boolean hasParseStarted = false;


    public boolean isHasParseStarted() {
        return hasParseStarted;
    }

    public void setHasParseStarted(boolean hasParseStarted) {
        this.hasParseStarted = hasParseStarted;
    }
}
