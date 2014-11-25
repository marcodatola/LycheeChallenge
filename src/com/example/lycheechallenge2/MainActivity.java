package com.example.lycheechallenge2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

	public final static String USER_INPUT = "com.example.lycheechallenge2.USER_INPUT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    public void fibonacci(View view){
    	Intent intent = new Intent(getBaseContext(), GeneratedFibonacci.class); //creates binding between MainActivity and GeneratedFibonacci
    	EditText editText = (EditText) findViewById(R.id.editText1); //stores the user's input in an EditText variable named editText
    	String number = editText.getText().toString(); //transforms editText to string then to integer
    	System.out.println(number);
    	intent.putExtra(USER_INPUT,number); //stores the user's input in the intent object and names it as the USER_INPUT string
    	startActivity(intent); //starts the new activity
    }
    
    
}
