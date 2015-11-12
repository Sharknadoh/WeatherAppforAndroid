package sharknado.project.weatherapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import static android.widget.Toast.LENGTH_SHORT;

@EActivity(R.layout.activity_login)
public class Login extends Activity implements OnClickListener, OnTouchListener {



	@ViewById(R.id.check_login_button)
	Button logingButton;
	@ViewById(R.id.username_input)
	EditText txtUNField;
	@ViewById(R.id.pw_input)
	EditText txtPWField;


	public final String EXTRA_MESSAGE = "blah";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		View loginButton = findViewById(R.id.check_login_button);
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
		case R.id.check_login_button:
			//Intent intentl = new Intent(this, Login.class);
			//startActivity(intentl);
			break;
		}
	}
	@Click(R.id.check_login_button)
	void logMeInScotty(){
		String UserName = txtUNField.getText().toString();
		String PassWord = txtPWField.getText().toString();

		ParseUser.logInInBackground(UserName, PassWord, new LogInCallback() {
			public void done(ParseUser user, ParseException e) {
				if (user != null) {
					ParseUser currentUser = ParseUser.getCurrentUser();
					if (currentUser != null) {
						Toast toast = Toast.makeText(getBaseContext(), "Successfully Logged In", LENGTH_SHORT);
						toast.show();					} else {
						// show the signup or login screen
					}
				} else {
					// Signup failed. Look at the ParseException to see what happened.
				}
			}
		});
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (v.isInTouchMode() == true) {
			switch (v.getId()) {
			case R.id.check_login_button:
				//Intent intentl = new Intent(this, Login.class);
				//startActivity(intentl);
				break;
			}
			return false;
		}
		return false;
	}
}
