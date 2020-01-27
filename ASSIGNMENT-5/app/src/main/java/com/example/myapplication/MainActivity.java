package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText emailaddress;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailaddress = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
    }
    public void OnClickSubmitButton (View v){
        Intent intend = new Intent(this,Main2Activity.class);
        startActivity(intend);
    }
    public void Clickbutton(View v){

        String pass = password.getText(). toString();
        String email = emailaddress.getText(). toString();
        boolean error = false;
        if(pass != null && pass.equalsIgnoreCase(""))
        {
            password.setError("Enter Valid Name");
            error =true;
        }
        if(email != null && email.equalsIgnoreCase(""))
        {
            emailaddress.setError("Enter Valid Name");
            error =true;
        }
        if(!error){
            Intent intend = new Intent(this,Main3Activity.class);
            startActivity(intend);
        }


    }
}
