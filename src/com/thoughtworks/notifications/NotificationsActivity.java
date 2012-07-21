package com.thoughtworks.notifications;

import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

public class NotificationsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void submit(View view){
    	Context ctx = getApplicationContext();
    	Button button = (Button)view;
		CharSequence button_text = "You clicked on " + button.getText();
		Toast toast = Toast.makeText(ctx, button_text, Toast.LENGTH_SHORT);
		toast.show();
		Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
        startActivityForResult(cameraIntent, 9999);
    }
    public void addToCalendar(View view){
    	Calendar calendar = Calendar.getInstance();
        Intent intent = new Intent(Intent.ACTION_EDIT);  
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("title", "Some title");
        intent.putExtra("description", "Some description");
        intent.putExtra("beginTime", calendar.getTimeInMillis());
        intent.putExtra("endTime", calendar.getTimeInMillis()+60*60*1000);
        startActivity(intent);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == 9999) {  
            Bitmap photo = (Bitmap) data.getExtras().get("data"); 
            ((ImageView) findViewById(R.id.imageView)).setImageBitmap(photo);
        }  
    } 
}