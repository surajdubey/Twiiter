package org.codelearn.twitter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class TweetAdapter extends ArrayAdapter {
	
	private LayoutInflater inflator;

	public TweetAdapter(Activity activity , String[] items)
	{
		super(activity, R.layout.row_tweet , items);
		inflator = activity.getWindow().getLayoutInflater();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return inflator.inflate(R.layout.row_tweet, parent, false);
	}

	
}
