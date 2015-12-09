package sharknado.project.weatherapp.responses.forecast;

/**
 * Created by Michael Leffert on 12/9/2015.
 */
public class simpleforecast {

    simpleforecastday [] forecastday;

    public simpleforecastday[] getForecastday() {
        return forecastday;
    }

    public void setForecastday(simpleforecastday[] forecastday) {
        this.forecastday = forecastday;
    }
}
