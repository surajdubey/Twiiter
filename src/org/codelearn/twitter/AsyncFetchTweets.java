package org.codelearn.twitter;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.codelearn.twitter.models.Tweet;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


public class AsyncFetchTweets extends AsyncTask<Void, Void, Void>
{
	TweetListActivity activity;
	public static final String TWEETS_CACHE_FILE = "tweet_cache.ser";
	public AsyncFetchTweets(TweetListActivity activity)
	{
		this.activity = activity;
	}

	@Override
	protected Void doInBackground(Void... params) {
		
		try{
			
			Thread.sleep(5000);
			
			//generate random tweets
			List<Tweet> tweetsWrite = new ArrayList<Tweet>();
			for(int i=0;i<10;i++)
			{
				Tweet tweet = new Tweet();
				tweet.setTitle("A nice header for Tweet # "+i);
				tweet.setBody("This is new Nice Body for tweet Number "+i);
				tweetsWrite.add(tweet);
			}
	
			FileOutputStream newfos = activity.openFileOutput(TWEETS_CACHE_FILE,Context.MODE_PRIVATE);
			ObjectOutputStream newoos = new ObjectOutputStream(newfos);
			
			newoos.writeObject(tweetsWrite);
			
			Log.d("codelearn", "Successfully wrote tweets to the file.");
			
			newoos.close();
			newfos.close();

			//new AsyncWriteTweets(activity).execute(tweetsWrite);
			Log.d("codelearn", "AsyncFetchTweets class");
		}
		
		catch(Exception e)
		{
			Log.d("codelearn", e.getMessage());
		}
		
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		Log.d("codelearn", "AsyncFetchTweets POST");
		activity.renderTweets();
		Log.d("codelearn", "AsyncFetchTweets Render Tweet");
			
	}

	

	
	
}
