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

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import static android.widget.Toast.LENGTH_SHORT;

@EActivity(R.layout.activity_register)
public class Register extends Activity implements OnClickListener, OnTouchListener {

	@ViewById (R.id.create_account_check)
	Button create_account_check;
	@ViewById (R.id.username_input)
	EditText userName;
	@ViewById (R.id.input_set_pw)
	EditText passWord;
	@ViewById (R.id.email_input)
	EditText email;

	public final String EXTRA_MESSAGE = "blah";
	public boolean parse;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// Enable Local Datastore.






		setContentView(R.layout.activity_register);
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

	@Click(R.id.create_account_check)
	void createAccount()
	{
		ParseUser user = new ParseUser();
		user.setUsername(userName.getText().toString());
		user.setPassword(passWord.getText().toString());
		user.setEmail(email.getText().toString());

		user.signUpInBackground(new SignUpCallback() {
			public void done(ParseException e) {
				if (e == null) {
					Toast toast = Toast.makeText(getBaseContext(), "Successfully Created Account", LENGTH_SHORT);
					toast.show();				} else {
					// Sign up didn't succeed. Look at the ParseException
					// to figure out what went wrong
				}
			}
		});

	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (v.isInTouchMode() == true) {
			switch (v.getId()) {
				
			}
			return false;
		}
		return false;
	}
}
