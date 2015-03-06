package com.thedeveloperworldisyours.writereadfromfile;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.thedeveloperworldisyours.writereadfromfile.utils.Utils;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	EditText mEditText;
	TextView mTextView;
	Button mButtonRead;
	Button mButtonSave;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mButtonRead = (Button) findViewById(R.id.activity_main_button_read);
		mButtonSave = (Button) findViewById(R.id.activity_main_button_save);
		mEditText = (EditText) findViewById(R.id.activity_main_editText1);
		mTextView = (TextView) findViewById(R.id.activity_main_textView);
		mEditText.setOnClickListener(this);
		mButtonSave.setOnClickListener(this);
		mButtonRead.setOnClickListener(this);
		mButtonSave.setEnabled(false);
		mEditText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (mEditText.getText().length() == 0) {
					setEnable(true);
				} else {
					setEnable(false);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.activity_main_button_save:
			Utils.writeToFile(mEditText.getText().toString(), MainActivity.this);
			break;

		case R.id.activity_main_button_read:
			mTextView.setText(Utils.readFromFile(MainActivity.this));
			break;
		default:
			break;
		}
	}

	public void setEnable(boolean bool) {
		if (bool) {
			mButtonSave.setEnabled(false);
		} else {
			mButtonSave.setEnabled(true);
		}
	}

}
