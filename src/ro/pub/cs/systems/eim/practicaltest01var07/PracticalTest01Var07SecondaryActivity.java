package ro.pub.cs.systems.eim.practicaltest01var07;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class PracticalTest01Var07SecondaryActivity extends Activity {

	Button okButton = null;
	Button cancelButton = null;
	
	EditText nameEditText = null;
	EditText groupEditText = null;
	
	ButtonClickListener secondBtnListener = new ButtonClickListener();
	
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
        	if (view.getId() == R.id.cancel_button) {
        		setResult(RESULT_CANCELED, null);
        	}
        	if (view.getId() == R.id.ok_button) {
        		setResult(RESULT_OK, null);
        	}
        	finish();
        }
    }		
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var07_secondary);
		
		nameEditText = (EditText)findViewById(R.id.name_text);
		groupEditText = (EditText)findViewById(R.id.group_edit_text);
		
		Intent intent = getIntent();
		if (intent != null && intent.getExtras().containsKey("studentName") && intent.getExtras().containsKey("studentGroup")) {
			String name = intent.getStringExtra("studentName");
			String group = intent.getStringExtra("studentGroup");
			nameEditText.setText(name);
			groupEditText.setText(group);
		}
		
		okButton = (Button)findViewById(R.id.ok_button);
		okButton.setOnClickListener(secondBtnListener);
		cancelButton = (Button)findViewById(R.id.cancel_button);
		cancelButton.setOnClickListener(secondBtnListener);		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var07_secondary, menu);
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
}
