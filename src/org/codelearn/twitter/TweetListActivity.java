package org.codelearn.twitter;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.codelearn.twitter.models.Tweet;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TweetListActivity extends ListActivity {
	
	private ListView tweetListView;
	private String stringArray[];
	private ArrayAdapter tweetItemArrayAdapter;
	List<Tweet> tweets;
	private static final String TWEETS_CACHE_FILE = "tweet_cache.ser";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tweet_list);

		//tweetListView = (ListView) findViewById(R.layout.id.);
		
		/*stringArray = new String[10];
		for(int i=0;i<stringArray.length;i++)
		{
			stringArray[i] = "String "+i;
		}
		
		itemArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringArray);
		tweetListView.setAdapter(itemArrayAdapter);*/
		
		/*itemArrayAdapter = new TweetAdapter(this, new String[10]);
		tweetListView.setAdapter(itemArrayAdapter);*/
		
		// Reading tweets from cached file
		
		tweets = new ArrayList<Tweet>();
		
		for(int i=0;i<15;i++)
		{
			Tweet tweet = new Tweet();
			tweet.setTitle("This is title for Tweet "+i);
			tweet.setBody("This is Nice Bosy for tweet Number "+i);
			tweets.add(tweet);
		}
		
		try{
		FileOutputStream fos = openFileOutput(TWEETS_CACHE_FILE, MODE_PRIVATE);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(tweets);
		oos.close();
		fos.close();
		
		Log.d("codelearn", "Successfully wrote tweets to the file.");
		
		tweetItemArrayAdapter = new TweetAdapter(this, tweets);
		setListAdapter(tweetItemArrayAdapter);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		/*TextView t = (TextView) v.findViewById(R.id.tweetTitle);
		t.setText("tweet Clicked!!");*/
		
		Intent intent = new Intent(getApplicationContext(), TweetDetailActivity.class);
		startActivity(intent);
	}


}
