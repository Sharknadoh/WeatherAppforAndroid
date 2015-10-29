package sharknado.project.weatherapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public class Login extends Activity implements OnClickListener, OnTouchListener {

	public final String EXTRA_MESSAGE = "blah";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		View loginButton = findViewById(R.id.login_button_Login);
		loginButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.open_app_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.login_button_Login:
			//Intent intentl = new Intent(this, Login.class);
			//startActivity(intentl);
			break;
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (v.isInTouchMode() == true) {
			switch (v.getId()) {
			case R.id.login_button_Login:
				//Intent intentl = new Intent(this, Login.class);
				//startActivity(intentl);
				break;
			}
			return false;
		}
		return false;
	}
}
