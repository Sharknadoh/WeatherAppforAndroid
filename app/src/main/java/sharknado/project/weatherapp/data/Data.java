package sharknado.project.weatherapp.data;

import android.util.Log;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.MediaType;
import org.androidannotations.api.rest.RestClientErrorHandling;
import org.androidannotations.api.rest.RestClientHeaders;
import org.androidannotations.api.rest.RestClientRootUrl;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.io.IOException;
import java.util.HashMap;

import sharknado.project.weatherapp.responses.getCurrentWeather;

/**
 * Created by Michael Leffert on 12/8/2015.
 */
@Rest(rootUrl = "http://api.wunderground.com/api/c80219bfc61f264a/", converters = { FormHttpMessageConverter.class, GsonHttpMessageConverter.class, ByteArrayHttpMessageConverter.class}, interceptors = {HTTPLoggingInterceptor.class})
public interface Data extends RestClientHeaders, RestClientErrorHandling, RestClientRootUrl {
        void setRootUrl(String rootUrl);

        @Get("")
        getCurrentWeather GetCurrentWeather();


    }

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
