package edu.csumb.csit.carrepairreservationsystem;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class Admin extends Activity implements OnClickListener{
	
	ArrayList<Contacts> appt;
	int counter = 0;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin);
		
		View home = findViewById(R.id.home_button);
		home.setOnClickListener(this);
		
		Bundle bundle = getIntent().getExtras();
		if(bundle != null)
		{
			appt = (ArrayList<Contacts>) bundle.get("appt");
			
		}
		TextView myTextView1 = (TextView) findViewById(R.id.admin1_def);
		TextView myTextView2 = (TextView) findViewById(R.id.admin2_def);
		if(appt.size() > 0)
		{
			myTextView1.setText(Integer.toString(appt.get(0).created()));
			myTextView2.setText(Integer.toString(appt.get(0).cancellations()));
		}
		
		
		

	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v.getId() == R.id.home_button)
		{
			Intent i = new Intent(this, MainActivity.class);
			startActivity(i);
		}
	}
	
	
}