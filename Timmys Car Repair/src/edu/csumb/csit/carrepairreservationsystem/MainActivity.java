package edu.csumb.csit.carrepairreservationsystem;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener {
	
	ArrayList<Contacts> appt;
	int control = 0;
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		View create = findViewById(R.id.create_button);
		create.setOnClickListener(this);
		
		View cancel = findViewById(R.id.cancel_button);
		cancel.setOnClickListener(this);
		
		View admin = findViewById(R.id.admin_button);
		admin.setOnClickListener(this);
		
		if(control == 0)
		{
			appt = new ArrayList<Contacts>();
		}
		Bundle bundle = getIntent().getExtras();
		if(bundle != null)
		{
			appt = (ArrayList<Contacts>) bundle.get("appt");
			
		}

	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v.getId() == R.id.create_button)
		{
			control = 1;
			Intent i = new Intent(this, Create.class);
			i.putExtra("appt", appt);  
			startActivity(i);
			
		}
		else if(v.getId() == R.id.cancel_button)
		{
			control = 1;
			Intent i = new Intent(this, Cancel.class);
			i.putExtra("appt", appt);  
			startActivity(i);
			
		}
		else if(v.getId() == R.id.admin_button)
		{
			control = 1;
			Intent i = new Intent(this, AdminLogin.class);
			i.putExtra("appt", appt);  
			startActivity(i);
		}
	}
	
}
