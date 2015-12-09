
package sharknado.project.weatherapp.responses;

import sharknado.project.weatherapp.responses.CurrentObservations.current_observation;
import sharknado.project.weatherapp.responses.Response.response;
import sharknado.project.weatherapp.responses.forecast.forecast;
import sharknado.project.weatherapp.responses.hourly_forecast.hourly_forecast;

/**
 * Created by Michael Leffert on 11/12/2015.
 */
public class getCurrentWeather {

    response response;
    current_observation current_observation;
    forecast forecast;
    hourly_forecast[] hourly_forecast;

    public sharknado.project.weatherapp.responses.forecast.forecast getForecast() {
        return forecast;
    }

    public void setForecast(sharknado.project.weatherapp.responses.forecast.forecast forecast) {
        this.forecast = forecast;
    }

    public sharknado.project.weatherapp.responses.CurrentObservations.current_observation getCurrent_observation() {
        return current_observation;
    }

    public void setCurrent_observation(sharknado.project.weatherapp.responses.CurrentObservations.current_observation current_observation) {
        this.current_observation = current_observation;
    }

    public sharknado.project.weatherapp.responses.Response.response getResponse() {
        return response;
    }

    public void setResponse(sharknado.project.weatherapp.responses.Response.response response) {
        this.response = response;
    }

    public sharknado.project.weatherapp.responses.hourly_forecast.hourly_forecast[] getHourly_forecast() {
        return hourly_forecast;
    }

    public void setHourly_forecast(sharknado.project.weatherapp.responses.hourly_forecast.hourly_forecast[] hourly_forecast) {
        this.hourly_forecast = hourly_forecast;
    }
}
