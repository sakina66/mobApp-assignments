package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =

            Pattern.compile( "^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\\\S+$)" +
                    ".{5,8}" +
                    "$");
    private EditText editText2,editText3;
    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText2=(EditText)findViewById(R.id.email);
        editText3=(EditText)findViewById(R.id.password);
        Register=(Button)findViewById(R.id.Register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main4Activity();

            }
        });
    }
    public void Main4Activity(){
        Intent intent= new Intent(this,Main4Activity.class);
        startActivity(intent);
    }
    private boolean validateEmail(){
        String emailInput = editText2.getEditableText().getFilters().toString().trim();
        if(emailInput.isEmpty()){
            editText2.setError("Feild can't be empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){

            editText2.setError("please enter valid email");
            return false;
        }
        else{
            editText2.setError(null);
            return true;
        }
    }
    private boolean validatePassword(){
        String passwordInput = editText3.getEditableText().getFilters().toString().trim();
        if(passwordInput.isEmpty()){
            editText3.setError("Feild can't be empty");
            return false;
        }
        else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()){
            editText3.setError("Password too weak");
            return false;

        }
        else{
            editText3.setError(null);
            return true;
        }
    }

    public void confirm(View view) {
        if (!validateEmail() | validatePassword()) {
            String input = "Email:" + editText2.getEditableText().getFilters().toString();
            input += "\n";
            input += "password" + editText3.getEditableText().getFilters().toString();
            input += "\n";
            Toast.makeText(this,input, Toast.LENGTH_SHORT).show();
        }
    }




}
