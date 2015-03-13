package edu.csumb.csit.carrepairreservationsystem;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class Cancel extends Activity implements OnClickListener {

	ArrayList<Contacts> appts;
	
	@SuppressWarnings("unchecked")
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cancel);
		
		appts = new ArrayList<Contacts>();
		Bundle bundle = getIntent().getExtras();
		if(bundle != null)
		{
			appts = (ArrayList<Contacts>) bundle.get("appt");
		}
		View cancel = findViewById(R.id.cancel_button);
		cancel.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		EditText input1, input2;
		String name, number;
		
		input1 = (EditText)findViewById(R.id.name);
		input2 = (EditText)findViewById(R.id.number);
		name = input1.getText().toString().trim();
		number = input2.getText().toString().trim();
		
		if(appts.size() > 0)
		{
			for(int i = 0 ; i < appts.size(); i++)
			{
				if(appts.get(i).cancelMatch(name, number))
				{
					Toast.makeText(this, "Appointment on: " + appts.get(i).monthString() + " " + appts.get(i).dayString() + ", at " 
							+ appts.get(i).timeString() + " cancelled.", Toast.LENGTH_SHORT).show();
					appts.get(0).cancel();
					appts.remove(i);		
					i = appts.size();
					
					Intent k = new Intent(this, MainActivity.class);
					k.putExtra("appt", appts);  
					startActivity(k);
				}
			}
			Toast.makeText(this, "No appointments under the name: " + name + " with the phone number: " + number, Toast.LENGTH_SHORT).show();
			Intent i = new Intent(this, MainActivity.class);
			startActivity(i);
		}
		else if(name.equals("") || number.equals(""))
		{
			Toast.makeText(this, "Name and/or phone number are blank.", Toast.LENGTH_SHORT).show();
		}
		else
		{
			Toast.makeText(this, "No Current Appointments", Toast.LENGTH_SHORT).show();
			Intent i = new Intent(this, MainActivity.class);
			startActivity(i);
		}
		
		
	}

}
