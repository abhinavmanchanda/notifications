package com.thoughtworks.notifications.test;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import com.thoughtworks.notifications.NewToDoActivity;
import com.thoughtworks.notifications.R;

import static com.thoughtworks.notifications.NotificationsConstants.TITLE_KEY;

public class NewToDoActivityTest extends ActivityInstrumentationTestCase2<NewToDoActivity> {

  private NewToDoActivity activity;

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

}
