package com.thoughtworks.notifications.test;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import com.thoughtworks.notifications.NewToDoActivity;
import com.thoughtworks.notifications.R;

import static com.thoughtworks.notifications.NotificationsConstants.TITLE_KEY;

@TargetApi(8)
public class NewToDoActivityTest extends ActivityInstrumentationTestCase2<NewToDoActivity> {

  private NewToDoActivity activity;
  public String akash;

  public NewToDoActivityTest(){
    super(NewToDoActivity.class);
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();
    Intent intent = new Intent();
    intent.putExtra(TITLE_KEY,"super title");
    this.setActivityIntent(intent);
    activity = this.getActivity();

  }

  public void testPrepopulateTitle() throws Exception {
    EditText editText = (EditText) activity.findViewById(R.id.todoText);
    assertEquals("super title",editText.getText().toString());
  }
	
  public void testShouldPrePopulateDescription() throws InterruptedException{
		Activity activity = getActivity();
		setEditText(R.id.description, "This is a desc.", activity);
		EditText title = (EditText) activity.findViewById(R.id.description);
		assertEquals("This is a desc.", title.getText().toString());
	}
	
	private void setEditText(final EditText editText, final String text, Activity currentActivity) {
		currentActivity.runOnUiThread(new Runnable() {
			public void run() {
				editText.setText(text);
			}
		});
		getInstrumentation().waitForIdleSync();
	}
	
	private void setEditText(int id, String text, Activity currentActivity){
		EditText editText = (EditText) currentActivity.findViewById(id);
		setEditText(editText, text, currentActivity);
	}
	
}

