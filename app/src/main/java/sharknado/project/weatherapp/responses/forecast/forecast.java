package sharknado.project.weatherapp.responses.forecast;

/**
 * Created by Michael Leffert on 12/9/2015.
 */
public class forecast {

    simpleforecast simpleforecast;
    txt_forecast txt_forecast;


    public sharknado.project.weatherapp.responses.forecast.simpleforecast getSimpleforecast() {
        return simpleforecast;
    }

    public void setSimpleforecast(sharknado.project.weatherapp.responses.forecast.simpleforecast simpleforecast) {
        this.simpleforecast = simpleforecast;
    }

    public sharknado.project.weatherapp.responses.forecast.txt_forecast getTxt_forecast() {
        return txt_forecast;
    }

    public void setTxt_forecast(sharknado.project.weatherapp.responses.forecast.txt_forecast txt_forecast) {
        this.txt_forecast = txt_forecast;
    }

}
