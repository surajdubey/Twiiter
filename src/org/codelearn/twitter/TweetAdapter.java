package org.codelearn.twitter;

import java.util.List;

import org.codelearn.twitter.models.Tweet;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TweetAdapter extends ArrayAdapter<Tweet> {
	
	private LayoutInflater inflator;
	List<Tweet> tweets;
	public TweetAdapter(Activity activity , List<Tweet> tweets)
	{
		super(activity, R.layout.row_tweet , tweets);
		this.tweets = tweets;
		inflator = activity.getWindow().getLayoutInflater();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		//if(convertView == null)
		convertView = inflator.inflate(R.layout.row_tweet, parent, false);
		
		TextView title = (TextView) convertView.findViewById(R.id.tweetTitle);
		title.setText(tweets.get(position).getTitle());
			
		return convertView;
	}

	
}
