package org.codelearn.twitter;

import org.codelearn.twitter.models.Tweet;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TweetDetailActivity extends Activity {
	TextView title,body,date;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tweet_detail);

		title = (TextView) findViewById(R.id.tweetTitle);
		body = (TextView) findViewById(R.id.tweetBody);
		date = (TextView) findViewById(R.id.tweetDate);
		Tweet tweet = (Tweet) getIntent().getSerializableExtra("value");
		
		title.setText(tweet.getTitle());
		body.setText(tweet.getBody());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tweet_detail, menu);
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
	

}
