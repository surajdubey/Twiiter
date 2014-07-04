package org.codelearn.twitter;

import java.util.ArrayList;
import java.util.List;

import org.codelearn.twitter.models.Tweet;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TweetListActivity extends ListActivity {
	
	private ListView tweetListView;
	private String stringArray[];
	private ArrayAdapter tweetItemArrayAdapter;
	List<Tweet> tweets;
	

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
		
		
		tweets = new ArrayList<Tweet>();
		
		for(int i=0;i<15;i++)
		{
			Tweet tweet = new Tweet();
			tweet.setTitle("This is title for Tweet "+i);
			tweet.setBody("This is Nice Bosy for tweet Number "+i);
			tweets.add(tweet);
		}
		tweetItemArrayAdapter = new TweetAdapter(this, tweets);
		setListAdapter(tweetItemArrayAdapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		/*TextView t = (TextView) v.findViewById(R.id.tweetTitle);
		t.setText("tweet Clicked!!");*/
		
		Intent intent = new Intent(getApplicationContext(), TweetDetailActivity.class);
		startActivity(intent);
	}


}
