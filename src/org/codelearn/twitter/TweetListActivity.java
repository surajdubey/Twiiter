package org.codelearn.twitter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
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
	
	/*FileInputStream fis;
	FileOutputStream newfos;
	ObjectOutputStream newoos;
	ObjectInputStream ois;
	*/
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
		try{

			
		List<Tweet> tweetsRead = new ArrayList<Tweet>();
		FileInputStream fis = openFileInput(TWEETS_CACHE_FILE);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		tweetsRead = (List<Tweet>) ois.readObject();

		Log.d("codelearn", "Successfully read tweets to the file.");
		List<Tweet> tweetsWrite = new ArrayList<Tweet>();
		for(int i=0;i<10;i++)
		{
			Tweet tweet = new Tweet();
			tweet.setTitle("This is new title for Tweet "+i);
			tweet.setBody("This is new Nice Bosy for tweet Number "+i);
			tweetsWrite.add(tweet);
			
		}

		FileOutputStream newfos = openFileOutput(TWEETS_CACHE_FILE, MODE_PRIVATE);
		ObjectOutputStream newoos = new ObjectOutputStream(newfos);
		
		newoos.writeObject(tweetsWrite);
		
		/*tweets = new ArrayList<Tweet>();
		
		for(int i=0;i<15;i++)
		{
			Tweet tweet = new Tweet();
			tweet.setTitle("This is title for Tweet "+i);
			tweet.setBody("This is Nice Bosy for tweet Number "+i);
			tweets.add(tweet);
		}
		
		
		FileOutputStream fos = openFileOutput(TWEETS_CACHE_FILE, MODE_PRIVATE);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(tweets);
		
		
		
		oos.close();
		fos.close();
		*/
		Log.d("codelearn", "Successfully wrote tweets to the file.");
		
		tweetItemArrayAdapter = new TweetAdapter(this, tweetsRead);
		setListAdapter(tweetItemArrayAdapter);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally{
			/*try{
			fis.close();
			ois.close();
			newfos.close();
			newoos.close();
			}
			catch(Exception e)
			{
				
			}*/
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
