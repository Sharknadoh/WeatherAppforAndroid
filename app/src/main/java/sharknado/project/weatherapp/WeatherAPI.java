package sharknado.project.weatherapp;

import android.util.Log;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.MediaType;
import org.androidannotations.api.rest.RestClientErrorHandling;
import org.androidannotations.api.rest.RestClientHeaders;
import org.androidannotations.api.rest.RestClientRootUrl;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Michael Leffert on 11/12/2015.
 */
@Rest(rootUrl = "https://rsd-inv-app.herokuapp.com", converters = { FormHttpMessageConverter.class, GsonHttpMessageConverter.class, ByteArrayHttpMessageConverter.class}, interceptors = {WeatherAPI.HTTPLoggingInterceptor.class})

public interface WeatherAPI extends RestClientHeaders, RestClientErrorHandling, RestClientRootUrl {
    void setRootUrl(String rootUrl);

//    @Post("/inventory/query/missingtags")
//    @RequiresHeader("Authorization")
//    GetMissingEPCs getMissingEPCs(HashMap<String,String> time);
//
//    @Post("/inventory/query/missingtags/test")
//    @RequiresHeader("Authorization")
//    GetMissingEPCs getMissingEPCsTest(HashMap<String,String> time);
//
//    @Post("/inventory/search")
//    @RequiresHeader("Authorization")
//    GetMissingEPCs searchEPCs(HashMap<String, String> epc);
//
//    @Post("/inventory/query/facilities")
//    @RequiresHeader("Authorization")
//    GetFacilities getFacilities();
//
//    @Post("/findtag/session/start")
//    @RequiresHeader("Authorization")
//    @Accept(MediaType.APPLICATION_JSON)
//    ResponseEntity <GetFacilities> startSession(HashMap<String, String> deviceId);
//
//
//    @Post ("/findtag/session/end")
//    @RequiresHeader("Authorization")
//    @Accept(MediaType.APPLICATION_JSON)
//    ResponseEntity endSession(HashMap<String, Object> deviceId);
//
//    @Post ("/findtag/session/update")
//    @RequiresHeader("Authorization")
//    @Accept(MediaType.APPLICATION_JSON)
//    ResponseEntity updateSession(HashMap<String, Object> deviceId);
//}

    class HTTPLoggingInterceptor implements ClientHttpRequestInterceptor {
        public static final String TAG = "CALL_RESTCLIENT";

        public HTTPLoggingInterceptor() {
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] data, ClientHttpRequestExecution execution) throws IOException {
            Log.v(TAG, request.getMethod() + " [URI] => " + request.getURI());
            Log.v(TAG, request.getMethod() + " [DATA] =>" + data);
            Log.v(TAG, request.getMethod() + " [HEADERS] => " + request.getHeaders());

            return execution.execute(request, data);
        }
    }
}