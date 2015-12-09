package sharknado.project.weatherapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;



import com.google.gson.Gson;

import com.parse.Parse;


import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;

import sharknado.project.weatherapp.adapter.currentWeatherAdapter;
import sharknado.project.weatherapp.data.Data;
import sharknado.project.weatherapp.data.DataRestErrorHandler;
import sharknado.project.weatherapp.eventBus.weatherEventBus;
import sharknado.project.weatherapp.responses.getCurrentWeather;


@EActivity(R.layout.activity_open_app_screen)
@OptionsMenu(R.menu.dashboard)
public class OpenAppScreen extends Activity {

    Context context;
    String rootUrl;
    ProgressDialog pd;
    List<getCurrentWeather> current;
    getCurrentWeather weather;
    List<String> location;
    int pref;

    @Pref
    PrefsShared_ PrefsShared;
    @Bean
    weatherEventBus bus;
    @Bean
    DataRestErrorHandler restClientErrorHandler;
    @RestService
    Data restClient;

    @Bean
    currentWeatherAdapter adapter;

    @ViewById
    ListView listCurrent;
    @App
    WeatherAppGlobal App;

    @ViewById(R.id.create_account_button)
    Button createAccount;
    @ViewById(R.id.log_in_button)
    Button logInButton;
    public final String EXTRA_MESSAGE = "blah";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @AfterInject
    void AfterInject(){
        pref = 0;
        pd = new ProgressDialog(this);

        context = this.context;
        if (!App.isHasParseStarted()) {
            Parse.enableLocalDatastore(this);
            Parse.initialize(this, "xSzxcqwQzUSj8AFZC0kTjp2yMasY691lJwexUYqj", "uzpIm0bNx439JgNID1DHQDgBBRvM6qgdOLyDJrGY");
            App.setHasParseStarted(true);
            Log.d("PaRSE", "IN IF STATEMENT");
        }



        setContentView(R.layout.activity_open_app_screen);


        location = new ArrayList<String>();
        current = new ArrayList<getCurrentWeather>();

        if(PrefsShared.lastSearched0().exists()) {
            location.add(PrefsShared.lastSearched0().get());
        }
        if(PrefsShared.lastSearched1().exists()) {
            location.add(PrefsShared.lastSearched1().get());
        }
        if(PrefsShared.lastSearched2().exists()) {
            location.add(PrefsShared.lastSearched2().get());
        }
        rootUrl = restClient.getRootUrl();


        getWeather();
        pd = ProgressDialog.show(this, "Loading", "Loading Saved Locations",true);




    }

    @OptionsItem(R.id.search)
    void searchClicked(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Search");
        alertDialogBuilder.setPositiveButton("Cancel", null);
        alertDialogBuilder.setCancelable(false);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.searchbox, null);

        alertDialogBuilder.setView(dialogView);
        Button submitZip = (Button) dialogView.findViewById(R.id.btnZipSubmit);
        Button submitCity = (Button) dialogView.findViewById(R.id.btnStateSubmit);
        final EditText etZip = (EditText) dialogView.findViewById(R.id.etZip);
        final EditText etCity = (EditText) dialogView.findViewById(R.id.etCity);
        final EditText etState = (EditText) dialogView.findViewById(R.id.etState);


        final AlertDialog alertDialog = alertDialogBuilder.create();

        submitZip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            updateWeather(etZip.getText().toString());
//                pd = ProgressDialog.show(context, "Loading", "Loading Saved Locations",true);
            alertDialog.dismiss();
            }
        });

        submitCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location;
                location = etState.getText().toString() + "/" + etCity.getText().toString();
                updateWeather(location);
//                pd = ProgressDialog.show(context, "Loading", "Loading Saved Locations",true);
                alertDialog.dismiss();
            }
        });

        alertDialog.show();

    }
    public void updatePref(String location){
        if(pref == 0){
            pref = 1;
            PrefsShared.lastSearched0().put(location);
            Log.d("prefs", PrefsShared.lastSearched0().get());
        }else if(pref == 1){
            pref = 2;
            PrefsShared.lastSearched1().put(location);
            Log.d("prefs", PrefsShared.lastSearched1().get());
        }else if(pref == 2){
            pref = 0;
            PrefsShared.lastSearched2().put(location);
            Log.d("prefs", PrefsShared.lastSearched2().get());
        }


    }

    @Override
    public void onStart(){
        bus.register(this);
        super.onStart();
    }
    @Override
    public void onStop(){

        bus.unregister(this);
        super.onStop();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.dashboard, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//        switch (id) {
//            case R.id.se:
//
//                return true;
//        }
        return super.onOptionsItemSelected(item);
    }

    @Click(R.id.create_account_button)
    void createAccount() {
        Intent intentr = new Intent(this, Register_.class);
        startActivity(intentr);
    }

    @Click(R.id.log_in_button)
    void login() {

        Intent intentl = new Intent(this, Login_.class);
        startActivity(intentl);

    }

    @Background
    void updateWeather(String newLocation){
        location.add(newLocation);
        restClient.setRootUrl(rootUrl + "conditions/forecast10day/hourly10day/q/" + newLocation + ".json");

        try {
            weather = restClient.GetCurrentWeather();

        } catch (RestClientException e) {
            Log.d("shiz", "Login done messed up " + e.getMessage());
        }
        if (weather != null) {
            Gson gson = new Gson();
            Log.d("responses ", "Surveys json response " + gson.toJson(weather));


            current.add(weather);

        }


        App.setCurrentWeather(current);
        updatePref(newLocation);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (App.getCurrentWeather() == null) {
                    setListener();
//                    pd.dismiss();
                }else{
                    adapter.notifyDataSetChanged();
//                    pd.dismiss();
                }
            }
        });

    }

    @Background
    void getWeather() {

        if (App.getCurrentWeather() == null   ) {

            for (int i = 0; i < location.size(); i++) {

                restClient.setRootUrl(rootUrl + "conditions/forecast10day/hourly10day/q/" + location.get(i) + ".json");

                try {
                    weather = restClient.GetCurrentWeather();

                } catch (RestClientException e) {
                    Log.d("shiz", "Login done messed up " + e.getMessage());
                }
                if (weather.getCurrent_observation() != null) {
                    Gson gson = new Gson();
                    Log.d("responses ", "Surveys json response " + gson.toJson(weather));


                    current.add(weather);

                }else{

                }

            }
            App.setCurrentWeather(current);

        }else{
            current = App.getCurrentWeather();

        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setListener();
                pd.dismiss();
            }
        });

    }



    @UiThread
    void setListener(){
        adapter.setCurrent(current);
        listCurrent.setAdapter(adapter);

        listCurrent.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                App.setSelectedIndex(i);
                Intent intentl = new Intent(getBaseContext(), ExtendedForecast_.class);
                startActivity(intentl);




//                Toast toast = Toast.makeText(context, " " + fakelego.get(i).getName(), Toast.LENGTH_SHORT);
//                toast.show();
//                bus.post(new EventSurveySelected());
            }
        });
    }




}
