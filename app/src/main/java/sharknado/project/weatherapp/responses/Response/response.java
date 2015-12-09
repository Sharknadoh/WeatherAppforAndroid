package sharknado.project.weatherapp.responses.Response;


import sharknado.project.weatherapp.responses.Response.features;

/**
 * Created by Michael Leffert on 11/12/2015.
 */
public class response {


    String version, termsofService;
    features features;

    public String getTermsofService() {
        return termsofService;
    }

    public void setTermsofService(String termsofService) {
        this.termsofService = termsofService;
    }

    public sharknado.project.weatherapp.responses.Response.features getFeatures() {
        return features;
    }

    public void setFeatures(sharknado.project.weatherapp.responses.Response.features features) {
        this.features = features;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


}
