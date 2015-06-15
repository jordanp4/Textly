package com.jordanpeterson.textly.messages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jordanpeterson.textly.R;
import com.jordanpeterson.textly.adapters.ImageAdapter;
import com.jordanpeterson.textly.ui.RecipientsActivity;
import com.jordanpeterson.textly.utils.ParseConstants;

public class MemeTextActivity extends Activity {

	protected EditText mEditMemeText;
	protected Button mSendMemeTextButton;
	protected String mTextTop;
	protected String mTextBottom;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meme_text);
		getActionBar().hide();
		
		Intent i = getIntent();
		final int position = i.getExtras().getInt(ParseConstants.KEY_MEME_IMAGE);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        ImageView imageView = (ImageView) findViewById(R.id.memeImageView);
        
        
        mTextTop = getIntent().getExtras().getString(ParseConstants.KEY_MEME_TOP_TEXT);
        mTextBottom = getIntent().getExtras().getString(ParseConstants.KEY_MEME_BOTTOM_TEXT);
       
        TextView topTest = (TextView)findViewById(R.id.textTopTest);
        topTest.setText(mTextTop);
        TextView bottomTest = (TextView)findViewById(R.id.textBottomTest);
        bottomTest.setText(mTextBottom);
	    
        
        
		mSendMemeTextButton = (Button) findViewById(R.id.sendMemeTextButton);
		mSendMemeTextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MemeTextActivity.this,
						RecipientsActivity.class);
				intent.putExtra(ParseConstants.KEY_FILE_TYPE, ParseConstants.TYPE_MEME);
				intent.putExtra(ParseConstants.KEY_MEME_IMAGE, position);
				intent.putExtra(ParseConstants.KEY_MEME_BOTTOM_TEXT, mTextBottom);
				intent.putExtra(ParseConstants.KEY_MEME_TOP_TEXT, mTextTop);
				startActivity(intent);
				finish();
			}
		});
		
		
		
		

	}

}
