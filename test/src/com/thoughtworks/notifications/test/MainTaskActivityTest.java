package com.thoughtworks.notifications.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.thoughtworks.notifications.MainTaskActivity;
import com.thoughtworks.notifications.R;
import com.thoughtworks.notifications.test.stubs.DataRepositoryStub;
import com.thoughtworks.notifications.test.utils.TestUtilities;


public class MainTaskActivityTest extends ActivityInstrumentationTestCase2<MainTaskActivity> {


    private MainTaskActivity activity;

    public MainTaskActivityTest() {
        super(MainTaskActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = this.getActivity();
        activity.setDataRepository(new DataRepositoryStub(getInstrumentation().getTargetContext()));
    }

    public void testButtonAddsItemToList() throws InterruptedException {
        TestUtilities.setEditText(R.id.txtTaskTitle, "Notification!", activity, this);
        ImageButton button = (ImageButton) activity.findViewById(R.id.btnAddTask);
        TouchUtils.clickView(this, button);
        ListView list = (ListView) activity.findViewById(android.R.id.list);
        assertEquals(1, list.getChildCount());
        assertEquals("Notification!", ((TextView) list.getChildAt(0)).getText());
    }


}
