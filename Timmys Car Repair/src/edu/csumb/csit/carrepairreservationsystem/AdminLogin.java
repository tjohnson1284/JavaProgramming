package edu.csumb.csit.carrepairreservationsystem;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class AdminLogin extends Activity implements OnClickListener {
	
	ArrayList<Contacts> appt;
	int counter;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_login);
		
		appt = new ArrayList<Contacts>();
		View submit = findViewById(R.id.submit_button);
		submit.setOnClickListener(this);
		
		Bundle bundle = getIntent().getExtras();
		if(bundle != null)
		{
			appt = (ArrayList<Contacts>) bundle.get("appt");
			
		}
		
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		EditText input1, input2;
		input1 = (EditText)findViewById(R.id.admin_user);
		input2 = (EditText)findViewById(R.id.admin_pass);
		String username = input1.getText().toString();
		String password = input2.getText().toString().trim();
		
		
		if(v.getId() == R.id.submit_button)
		{
			if(username.equals("timmy") && password.equals("southpark"))
			{
				Intent i = new Intent(this, Admin.class);
				i.putExtra("appt", appt);  
				startActivity(i);
			}
			else if(counter < 3)
			{
				Toast.makeText(this, "Username and/or Password incorrect. Please try again.", Toast.LENGTH_SHORT).show();
				counter++;
			}
			else
			{			
				Intent i = new Intent(this, MainActivity.class);
				startActivity(i);
			}
			
		}
		
	}
	
}