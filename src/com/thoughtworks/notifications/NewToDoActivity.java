package com.thoughtworks.notifications;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import static com.thoughtworks.notifications.NotificationsConstants.*;


public class NewToDoActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newtodo);
	}
	
	public void submit(View view) {
		String todoText = ((EditText)findViewById(R.id.todoText)).getText().toString();
		DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker);
		int day = datePicker.getDayOfMonth();
		int month = datePicker.getMonth();
		int year = datePicker.getYear();
		Date date = new Date(year, month, day);
		Intent intent = new Intent();
		intent.putExtra(DAY_KEY, day);
		intent.putExtra(MONTH_KEY, month);
		intent.putExtra(YEAR_KEY, year);
		intent.putExtra(TITLE_KEY, todoText);
		setResult(RESULT_OK, intent);
		finish();
	}

}
