package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText username;
    EditText emailaddress;
    EditText password;
    EditText phonenumber;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        emailaddress = findViewById(R.id.editText3);
        phonenumber = findViewById(R.id.editText4);
        cb = findViewById(R.id.checkBox);
        cb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(cb.isChecked())
                    cb.setTextColor(Color.BLACK);

            }
        });
    }


    public void onClickSubmitButton(View v){
//
        String name = username.getText().toString();
        String pass = password.getText(). toString();
        String email = emailaddress.getText(). toString();
        String phone = phonenumber.getText(). toString();
        boolean error = false;
        if(name != null && name.equalsIgnoreCase(""))
        {
            username.setError("Enter Valid Name");
            error =true;
        }
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
       // if (email !=("@") && email !=(".com"))
        //{
          //  emailaddress.setError("Enter @ and .com");
           // error = true;
        //}
        if(phone != null && phone.equalsIgnoreCase(""))
        {
            phonenumber.setError("Enter Valid Name");
            error =true;
        }
        if(!cb.isChecked()){
            cb.setTextColor(Color.RED);
            error = true;
        }

        if(!error){
            Intent intend = new Intent(this, Main3Activity.class);
            startActivity(intend);
        }



    }

}
