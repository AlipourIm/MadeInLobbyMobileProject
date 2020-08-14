package com.example.myfirstandroiddevelopingexperience;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class SendEmailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
    }

    public void sendButtonTapped(View view){

        EditText personsEmail = findViewById(R.id.editTextTextEmailAddress);
        EditText goalPersonsEmail = findViewById(R.id.editTextTextPersonName3);
        EditText emailSubject = findViewById(R.id.editTextTextPersonName);
        EditText emailBody = findViewById(R.id.editTextTextPersonName2);

        String txtPersonsEmail = personsEmail.getText().toString();
        String txtGoalPersonsEmail = goalPersonsEmail.getText().toString();
        String txtEmailSubject = emailSubject.getText().toString();
        String txtEmailBody = emailBody.getText().toString();

        if(txtEmailSubject.matches("")){
            new AlertDialog.Builder(SendEmailActivity.this)
                    .setTitle("ERROR!")
                    .setMessage("Subject cannot be empty!")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }

        else if(txtPersonsEmail.matches("")){
            new AlertDialog.Builder(SendEmailActivity.this)
                    .setTitle("ERROR!")
                    .setMessage("You need to enter your email!")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }

        else if(txtGoalPersonsEmail.matches("")){
            new AlertDialog.Builder(SendEmailActivity.this)
                    .setTitle("ERROR!")
                    .setMessage("We need to know to whom you want to send that email!")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }

        else if( !isValid(txtGoalPersonsEmail) || !isValid(txtPersonsEmail) ){
            new AlertDialog.Builder(SendEmailActivity.this)
                    .setTitle("ERROR!")
                    .setMessage("Please enter valid emails =)")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }

        else{
            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{txtPersonsEmail});
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, txtEmailSubject);
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, txtEmailBody);

            SendEmailActivity.this.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        }
    }

    public boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
