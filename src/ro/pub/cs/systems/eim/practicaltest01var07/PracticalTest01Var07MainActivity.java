package ro.pub.cs.systems.eim.practicaltest01var07;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class PracticalTest01Var07MainActivity extends Activity {

	private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	
	private EditText nameText = null;
	private EditText groupText = null;
	
	private Button secondActivityButton = null;
	
	private CheckBox checkName = null;
	private CheckBox checkGroup = null;
	
	private SecondActivityButtonClickListener btnListener = new SecondActivityButtonClickListener();
	
    private class SecondActivityButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
        	String studentName = nameText.getText().toString();
        	String studentGroup = groupText.getText().toString();

			Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
			intent.putExtra("studentName", studentName);
			intent.putExtra("studentGroup", studentGroup);
			startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);         	
        }
    }	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var07_main);
		
		nameText = (EditText)findViewById(R.id.name_text);
		groupText = (EditText)findViewById(R.id.group_edit_text);
		
		nameText.setEnabled(false);
		groupText.setEnabled(false);
		
		checkName = (CheckBox)findViewById(R.id.name_checkbox);
		checkGroup = (CheckBox)findViewById(R.id.group_checkbox);
		
		secondActivityButton = (Button)findViewById(R.id.second_activity_button);
		secondActivityButton.setOnClickListener(btnListener);
		
		checkName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					nameText.setEnabled(true);
				} else {
					nameText.setEnabled(false);
				}
				
			}
		});
		
		checkGroup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					groupText.setEnabled(true);
				} else {
					groupText.setEnabled(false);
				}
			}
		});		
		
	}

	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putBoolean("isNameChecked", checkName.isChecked());
		savedInstanceState.putBoolean("isGroupChecked", checkGroup.isChecked());
	    savedInstanceState.putString("studentName", nameText.getText().toString());
	    savedInstanceState.putString("studentGroup", groupText.getText().toString());
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		if (savedInstanceState.containsKey("isNameChecked")) {
			if (savedInstanceState.getBoolean("isNameChecked")) {
				checkName.setChecked(true);
			} else {
				checkName.setChecked(false);
			}
		} else {
			checkName.setChecked(false);
		}
		
		if (savedInstanceState.containsKey("isGroupChecked")) {
			if (savedInstanceState.getBoolean("isGroupChecked")) {
				checkGroup.setChecked(true);
			} else {
				checkGroup.setChecked(false);
			}		
		} else {
			checkGroup.setChecked(false);
		}
		
		if (savedInstanceState.containsKey("studentName")) {
			nameText.setText(savedInstanceState.getString("studentName"));
		} else {
			nameText.setText("Perfect Student");
		}
		
		if (savedInstanceState.containsKey("studentGroup")) {
			groupText.setText(savedInstanceState.getString("studentGroup"));
		} else {
			groupText.setText("343C1");
		}		
		
	}	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
			Toast.makeText(this, "Activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
		}
	}		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var07_main, menu);
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
