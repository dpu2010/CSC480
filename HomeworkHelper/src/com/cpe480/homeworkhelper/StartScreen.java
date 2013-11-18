package com.cpe480.homeworkhelper;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Spinner;

public class StartScreen extends Activity {

	protected EditText assignmentText;
	protected Spinner assignmentCategory;
	protected ArrayList<Task> taskList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_startscreen);
		
		
		
	}
	
	protected void initLayout() {
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_screen, menu);
		return true;
	}

}
