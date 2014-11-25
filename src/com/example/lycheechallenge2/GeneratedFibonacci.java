package com.example.lycheechallenge2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class GeneratedFibonacci extends android.app.Activity {

	//when the second activity is launched...
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.generated_fibonacci); //displays the gui
		Bundle extras = this.getIntent().getExtras(); //receives the data that was saved with the putExtra.. 
		int userInputNumber = Integer.parseInt(this.getIntent().getStringExtra(MainActivity.USER_INPUT)); //..and stores it into an integer variable
		ArrayList<String> listOfNumbers = generatedList(userInputNumber); //creates an ArrayList of strings that stores the generated fibonacci sequence calling the generatedList method
		String stringList = listToString(listOfNumbers);//transforms the ArrayList into a string calling the listToString method
		setText(stringList);
		
		}
	
	public void setText(String list){
		TextView textview = (TextView) findViewById(R.id.TextView1);
		textview.setText(list);
	}
	
	//transforms the ArrayList into a string parsing all of the elements the list contains with a for cycle
	// and copying them in the declared String adding a space between the elements 
	private String listToString(ArrayList<String> listOfNum){
		String list = "";
		for(int i = 0; i < listOfNum.size(); i++){
			list = list + listOfNum.get(i) + ", ";
		}
		return list;
	}
	
	//creates and returns an ArrayList that contains the number of elements in the fibonacci sequence the user asked
	//the number of elements that the sequence should contain is the only value (integer) that the method receives
	private ArrayList<String> generatedList(int userStopNumber){
		ArrayList<String> listOfNumbers = new ArrayList<String>(); //creates the new ArrayList of strings (not integers as no calculation is done on the stored elements)
		//declare three integers on which the calculation is done and declare their value
		int firstNumber = 0;
		int secondNumber = 1;
		int thirdNumber = 0;
		//the for cycle creates the fibonacci sequence, doing the calculation on the three integers
		//and stores the generated element of the fibonacci sequence into the ArrayList listOfNumbers
		//this process is done as many times as the user asked for.
		for(int i=0; i<userStopNumber; i++){
			listOfNumbers.add(Integer.toString(secondNumber));
			thirdNumber=secondNumber+firstNumber;
			firstNumber=secondNumber;
			secondNumber=thirdNumber;
		}
		return listOfNumbers;	//it then returnes the created list
	}
			

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.generated_fibonacci, menu);
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
