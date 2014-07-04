package org.codelearn.twitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TweetListActivity extends Activity {
	
	private ListView tweetListView;
	private String stringArray[];
	private ArrayAdapter itemArrayAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tweet_list);

		tweetListView = (ListView) findViewById(R.id.tweetList);
		stringArray = new String[10];
		for(int i=0;i<stringArray.length;i++)
		{
			stringArray[i] = "String "+i;
		}
		
		itemArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringArray);
		tweetListView.setAdapter(itemArrayAdapter);
	}


}
