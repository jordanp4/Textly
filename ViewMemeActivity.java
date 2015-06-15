package com.jordanpeterson.textly.messages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jordanpeterson.textly.R;
import com.jordanpeterson.textly.adapters.ImageAdapter;
import com.jordanpeterson.textly.utils.ParseConstants;
import com.squareup.picasso.Picasso;

public class ViewMemeActivity extends Activity {
	protected int mMemeImage;
	protected String mTopText;
	protected String mBottomText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_meme);
		getActionBar().hide();
		
		Intent i = getIntent();

		// Selected image id
		final int position = i.getExtras().getInt(ParseConstants.KEY_MEME_IMAGE);
		ImageAdapter imageAdapter = new ImageAdapter(this);
		
		mMemeImage = getIntent().getExtras().getInt(ParseConstants.KEY_MEME_IMAGE);
		ImageView memeImageView = (ImageView) findViewById(R.id.viewMemeImage);
		memeImageView.setImageResource(imageAdapter.mThumbIds[position]);
		
		mTopText = getIntent().getExtras().getString(ParseConstants.KEY_MEME_TOP_TEXT);
        mBottomText = getIntent().getExtras().getString(ParseConstants.KEY_MEME_BOTTOM_TEXT);
       
		
		TextView topTextView = (TextView)findViewById(R.id.memeTopWords);
		topTextView.setText(mTopText);
		
		TextView bottomTextView = (TextView)findViewById(R.id.memeBottomWords);
		bottomTextView.setText(mBottomText);
		
		
	}

	
}
