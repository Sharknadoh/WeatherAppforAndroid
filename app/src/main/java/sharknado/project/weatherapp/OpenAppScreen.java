package sharknado.project.weatherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;

public class OpenAppScreen extends Activity implements OnClickListener, OnTouchListener {

	public final String EXTRA_MESSAGE = "blah";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_open_app_screen);
		View loginButton = findViewById(R.id.login_button);
		loginButton.setOnClickListener(this);
		View regButton = findViewById(R.id.create_account_button);
		regButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch(id){
		case R.id.settings:
			startActivity(new Intent(this, Prefs.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.create_account_button:
				Intent intentr = new Intent(this, Register.class);
				startActivity(intentr);
				break;
			case R.id.login_button:
				Intent intentl = new Intent(this, Login.class);
				startActivity(intentl);
				break;
			case R.id.search_button:
				Intent intent = new Intent(this, Weather.class);
				EditText editText = (EditText) findViewById(R.id.search_bar);
				String message = editText.getText().toString();
				intent.putExtra(EXTRA_MESSAGE, message);
				startActivity(intent);
				break;
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (v.isInTouchMode() == true) {
			switch (v.getId()) {
				case R.id.create_account_button:
					Intent intentr = new Intent(this, Register.class);
					startActivity(intentr);
					break;
				case R.id.login_button:
					Intent intentl = new Intent(this, Login.class);
					startActivity(intentl);
					break;
				case R.id.search_button:
					Intent intent = new Intent(this, Weather.class);
					EditText editText = (EditText) findViewById(R.id.search_bar);
					String message = editText.getText().toString();
					intent.putExtra(EXTRA_MESSAGE, message);
					startActivity(intent);
					break;
			}
			return false;
		}
		return false;
	}
}
