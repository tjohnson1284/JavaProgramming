package edu.csumb.csit.carrepairreservationsystem;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Create extends Activity implements OnClickListener, OnItemSelectedListener {
	
	Spinner months, spinner2, spinner3;
	ArrayList<Contacts> selection;
	@SuppressWarnings({ "unchecked" })
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create);
		
		selection = new ArrayList<Contacts>();
		Bundle bundle = getIntent().getExtras();
		if(bundle != null)
		{
			selection = (ArrayList<Contacts>) bundle.get("appt");
		}
		months = (Spinner) findViewById(R.id.month_spinner);
		months.setOnItemSelectedListener(this);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		
		
		View submitButton = findViewById(R.id.submit_button);
		submitButton.setOnClickListener(this);
	}
	public void onClick(View v) {
		EditText input1, input2;
		String name, number, month, time, day, text;		
		boolean flag = true;
		
		
		
		
		if(v.getId() == R.id.submit_button)
		{
			input1 = (EditText)findViewById(R.id.name);
			input2 = (EditText)findViewById(R.id.number);
			name = input1.getText().toString().trim();
			number = input2.getText().toString().trim();
			month = months.getSelectedItem().toString();
			day = spinner2.getSelectedItem().toString();
			time = spinner3.getSelectedItem().toString();
			
			
			if(selection.size() > 0)
			{
				
			    for(int i = 0; i < selection.size(); i++)
			    {
			       
				   if(selection.get(i).conflict(month,day,time))
				   {		   
					   flag = false;
				   }
				   
			    }
			    if(!flag)
			    {
			    	
			    	text = "Selected day and time are already taken.";
			    	Toast.makeText(this, text, Toast.LENGTH_LONG).show();
			    }
			} 
			else 
			{
				flag = true;			
			}
			
			if(name.equals("") || number.equals(""))
			{
				Toast.makeText(this, "Name and/or phone number are blank.", Toast.LENGTH_SHORT).show();
				flag = false;
			}
			
			if(flag)
			{
				Contacts temp = new Contacts(name,number,month,day,time);
				selection.add(temp);
				text = "Appointment scheduled.";
				Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
				
				Intent i = new Intent(this, MainActivity.class);
				i.putExtra("appt", selection);  
				startActivity(i);
				
			}
			
			
			
			
		
		}

	}
	public int monthSet(String month)
	{
		if (month.equals("January")) {
			return 31;
		} 
		else if (month.equals("February")) {
			return 28;
		} 
		else if (month.equals("March")) {
			return 31;
		} 
		else if (month.equals("April")) {
			return 30;
		} 
		else if (month.equals("May")) {
			return 31;
		} 
		else if (month.equals("June")) {
			return 30;
		} 
		else if (month.equals("July")) {
			return 31;
		} 
		else if (month.equals("August")) {
			return 31;
		} 
		else if (month.equals("September")) {
			return 30;
		} 
		else if (month.equals("October")) {
			return 31;
		} 
		else if (month.equals("November")) {
			return 30;
		} 
		else if (month.equals("December")) {
			return 31;
		}
		else
			return 0;
	}
	public void daySpinnerUpdate(int j)
	{
		Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
		List<String> list = new ArrayList<String>();
		
		for(int i = 1 ; i <= j; i++)
		   {
			   list.add(Integer.toString(i));
		   }
		
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner2.setAdapter(dataAdapter);
			dataAdapter.notifyDataSetChanged();
	}
	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
		
        // An item was selected. You can retrieve the selected item using
        
		daySpinnerUpdate(monthSet(months.getSelectedItem().toString()));
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}