package com.example.myfirstandroiddevelopingexperience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void emailButtonTapped(View view){
        Intent intent = new Intent(MainActivity.this, SendEmailActivity.class);

        startActivity(intent);
    }

    public void buttonTapped(View view) {
        EditText txtUsername = findViewById(R.id.txtUsername);
        EditText txtPassword = findViewById(R.id.txtPassword);
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        //final Intent intent = new Intent(this, EmailListActivity.class);
        //Toast.makeText(this, username, Toast.LENGTH_LONG).show();
        Gonnect.getData("http://spneshaei.com/mil/getEmails.php?username=" + username + "&password=" + password, this, new Gonnect.ResponseSuccessListener(){
            @Override
            public void responseRecieved(final String response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (response.equals("invalid-user")){
                            Toast.makeText(MainActivity.this, "Invalid user", Toast.LENGTH_LONG).show();
                        }else{
                            ArrayList<Email> emails = new Gson().fromJson(response, new TypeToken<ArrayList<Email>>(){}.getType());
                            //Email.setAllEmailActivities(emails); wrong :)) this is a different array list and adaptor doesn't have access to it :))
                            Email.getAllEmails().clear();
                            Email.getAllEmails().addAll(emails);
                            //adapter.notifyDatasetChanged()) when we want to tell adapter data has been modified, yep :))
                            Intent intent = new Intent(MainActivity.this, EmailListActivity.class);
                            //intent.getExtras();
                            startActivity(intent);
                        }
                    }
                });
            }
        }, new Gonnect.ResponseFailureListener() {
            @Override
            public void responseFailed(IOException exception) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Error in loading", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        //startActivity(intent);

    }
}