package com.punjabi.nitnem;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ScrollView;
import android.widget.TextView;

public class PathText extends Activity {

	Typeface punjabi;
	ScrollView scrollview;
	int scrollX, scrollY;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patth_);
		TextView tv = (TextView) findViewById(R.id.patth);
		scrollview = (ScrollView) findViewById(R.id.scrollText);
		punjabi = Typeface.createFromAsset(getAssets(),
				"fonts/AnmolUniHeavy.ttf");
		Locale local = new Locale("pj");
		Locale.setDefault(local);
		Configuration config = new Configuration();
		config.locale = local;
		getBaseContext().getResources().updateConfiguration(config,
				getBaseContext().getResources().getDisplayMetrics());

		InputStream inputStream = null;
		try {
			inputStream = getAssets().open("sample.txt");

			byte[] b = new byte[inputStream.available()];
			inputStream.read(b);
			tv.setText(new String(b));
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		tv.setTypeface(punjabi);

	}

	@Override
	protected void onDestroy() {
		scrollX = scrollview.getScrollX();
		scrollY = scrollview.getScrollY();
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		System.out.println("onresume");
		scrollview.scrollTo(scrollX, scrollY);
		
		// TODO Auto-generated method stub
		super.onResume();
	}
	

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.path_text, menu);
		return true;
	}

}
