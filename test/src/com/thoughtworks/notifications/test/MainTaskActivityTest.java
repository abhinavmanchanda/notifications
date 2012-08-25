package com.thoughtworks.notifications.test;
import com.thoughtworks.notifications.MainTaskActivity;
import com.thoughtworks.notifications.R;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.thoughtworks.notifications.test.stubs.DataRepositoryStub;


public class MainTaskActivityTest extends ActivityInstrumentationTestCase2<MainTaskActivity>{

	
	private MainTaskActivity activity;

	public MainTaskActivityTest() {
		super(MainTaskActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		activity = this.getActivity();
        activity.setDataRepository(new DataRepositoryStub(getInstrumentation().getTargetContext()));
	}
	
	public void testButtonAddsItemToList() throws InterruptedException{
		setEditText(R.id.txtTaskTitle, "Notification!", activity);
		Button button = (Button) activity.findViewById(R.id.btnAddTask);
		TouchUtils.clickView(this, button);
		ListView list = (ListView) activity.findViewById(android.R.id.list);
		assertEquals(1, list.getChildCount());
		assertEquals("Notification!", ((TextView)list.getChildAt(0)).getText());
	}
	
		
	private void setEditText(final EditText editText,	final String text, Activity currentActivity) {
		currentActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				editText.setText(text);
			}
		});
		getInstrumentation().waitForIdleSync();
	}
	
	private void setEditText(int id, String text, Activity currentActivity){
		EditText editText = (EditText) currentActivity.findViewById(id);
		setEditText(editText, "Notification!", activity);
	}
	

}
