package org.codelearn.twitter;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.codelearn.twitter.models.Tweet;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class AsyncWriteTweets extends AsyncTask<List<Tweet>, Void, Void>{

	TweetListActivity activity;
	public static final String TWEETS_CACHE_FILE = "tweet_cache.ser";

	
	public AsyncWriteTweets(TweetListActivity activity) {
		this.activity = activity;
	}
	@Override
	protected Void doInBackground(List<Tweet>... params) {
		try{
		
		
			
/*		List<Tweet> tweetsWrite = new ArrayList<Tweet>();
		for(int i=0;i<10;i++)
		{
			Tweet tweet = new Tweet();
			tweet.setTitle("A nice header for Tweet # "+i);
			tweet.setBody("This is new Nice Body for tweet Number "+i);
			tweetsWrite.add(tweet);
		}
*/
		FileOutputStream newfos = activity.openFileOutput(TWEETS_CACHE_FILE,Context.MODE_PRIVATE);
		ObjectOutputStream newoos = new ObjectOutputStream(newfos);
		
		newoos.writeObject(params[0]);
		
		Log.d("codelearn", "Successfully wrote tweets to the file.");
		
		newoos.close();
		newfos.close();
		}
		
		catch(Exception e)
		{
			Log.d("codelearn", e.getMessage());
		}
		
		return null;
	}


}
