package org.codelearn.twitter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	Button _loginBtn;
	EditText username , password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		final SharedPreferences prefs = getSharedPreferences("codelearn_twitter", MODE_PRIVATE);
		
		// check if this needs to be skipped
		if(prefs.getString("key_for_username", "")!="")
		{
			Intent intent = new Intent(getApplicationContext() , TweetListActivity.class);
			startActivity(intent);
			finish();
			
		}
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		_loginBtn = (Button) findViewById(R.id.btn_login);
		username = (EditText) findViewById(R.id.fld_username);
		password = (EditText) findViewById(R.id.fld_pwd);
		_loginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String usernameValue = username.getText().toString();
				String passValue = password.getText().toString();

				
				Editor edit = prefs.edit();
				edit.putString("key_for_username", usernameValue);
				edit.putString("key_for_password", passValue);
				
				edit.commit();
				
				Log.d("twitter", usernameValue);
				Log.d("twitter", passValue);
				Intent intent = new Intent(getApplicationContext() , TweetListActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
