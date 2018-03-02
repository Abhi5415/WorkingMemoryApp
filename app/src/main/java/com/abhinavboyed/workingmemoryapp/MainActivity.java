package com.abhinavboyed.workingmemoryapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button userIsReady, userWantsToCheck;
    private ProgressBar progressBar;
    private EditText firstDigit, secondDigit, thirdDigit, fourthDigit;
    private TextView trainingWindow;
    private int numberArray[] = new int[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userIsReady = (Button) findViewById(R.id.readyButton);
        userWantsToCheck = (Button) findViewById(R.id.checkButton);
        firstDigit = (EditText) findViewById(R.id.editText1);
        secondDigit = (EditText) findViewById(R.id.editText2);
        thirdDigit = (EditText) findViewById(R.id.editText3);
        fourthDigit = (EditText) findViewById(R.id.editText4);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = "The answer was: " + numberArray[0] + ", "+ numberArray [1] +", "+ numberArray [2] +", "+numberArray [3];
                Snackbar.make(view, answer, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createNumberString(){

        for(int x=0; x<4; x++){
            int currentNumber = (int) (Math.random()*100);
            numberArray[x]=currentNumber;
        }

    }

    public void checkNumberString(int[] a){
        boolean isCorrect = true;
        for(int x=0; x<4; x++){
           if(a[x]!=numberArray[x]){
               isCorrect = false;
           }
        }
        if(isCorrect){
            Toast.makeText(this, "You are right!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "You are wrong!", Toast.LENGTH_LONG).show();

        }

    }



    public void userReady(View view) {
        createNumberString();
        for(int x=0; x<4; x++){
            String output = "Number: " + numberArray[x];
            Toast.makeText(this, output, Toast.LENGTH_SHORT).show();
        }

    }

    public void fab(View view){
        String answer = "The answer was: " + numberArray[0] + ", "+ numberArray [1] +", "+ numberArray [2] +", "+numberArray [3];
        Snackbar.make(view, answer, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void userCheck(View view) {
        int[] inputAr = new int [4];
        inputAr[0] = Integer.parseInt(String.valueOf(firstDigit.getText()));
        inputAr[1] = Integer.parseInt(String.valueOf(secondDigit.getText()));
        inputAr[2] = Integer.parseInt(String.valueOf(thirdDigit.getText()));
        inputAr[3] = Integer.parseInt(String.valueOf(fourthDigit.getText()));
        checkNumberString(inputAr);
        String answer = "The answer was: " + numberArray[0] + ", "+ numberArray [1] +", "+ numberArray [2] +", "+numberArray [3];
        Snackbar.make(view, answer, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
