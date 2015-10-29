package sharknado.project.weatherapp;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.MenuItem;

public class SettingsFragment extends PreferenceFragment{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		
		
		return super.onOptionsItemSelected(item);
	}
}
