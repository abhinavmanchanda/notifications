package com.thoughtworks.notifications;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import static com.thoughtworks.notifications.NotificationsConstants.*;


public class NewToDoActivity extends Activity{
  private static final int REQUEST_CODE = 100;
  private Uri fileUri;

  @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		setContentView(R.layout.newtodo);
		((EditText)findViewById(R.id.todoText)).setText(intent.getStringExtra(TITLE_KEY));
	}

  public void pickImage(View View) {
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

//TODO: Store captured image in a file
//    fileUri = getOutputMediaFileUri();
//    intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
    startActivityForResult(intent, REQUEST_CODE);
  }

  private Uri getOutputMediaFileUri() {
    return Uri.fromFile(getOutputMediaFile());
  }

  private File getOutputMediaFile() {

    File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "NotificationImages");
    if(!mediaStorageDir.exists()){
      if(!mediaStorageDir.mkdirs()){
        Log.d("NotificationImages", "Failed to create directory");
        return null;
      }
    }

    return new File(mediaStorageDir.getPath() + File.separator + "IMAGE_1.jpg");
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_CODE){
      if(resultCode == Activity.RESULT_OK){
        Toast.makeText(this, "Image captured", Toast.LENGTH_LONG).show();
        ImageView imageView = (ImageView) findViewById(R.id.image);
        Bitmap bitmapImage = (Bitmap) data.getExtras().get("data");
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageBitmap(bitmapImage);
      }else if(resultCode == RESULT_CANCELED){
        Toast.makeText(this, "Image capturing cancelled", Toast.LENGTH_LONG).show();
      }else{
        Toast.makeText(this, "failed", Toast.LENGTH_LONG).show();
      }
    }

  }

  public void submit(View view) {
		String todoText = ((EditText)findViewById(R.id.todoText)).getText().toString();
		DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker);
		int day = datePicker.getDayOfMonth();
		int month = datePicker.getMonth();
		int year = datePicker.getYear();
		String description = ((EditText)findViewById(R.id.description)).getText().toString();
		Intent intent = new Intent();
		intent.putExtra(DAY_KEY, day);
		intent.putExtra(MONTH_KEY, month);
		intent.putExtra(YEAR_KEY, year);
		intent.putExtra(TITLE_KEY, todoText);
		intent.putExtra(DESCRIPTION,description);
		setResult(RESULT_OK, intent);
		finish();
	}

}
