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

public class MainActivity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =

            Pattern.compile( "^" +
            "(?=.*[0-9])" +
            "(?=.*[a-z])" +
            "(?=.*[A-Z])" +
            "(?=.*[@#$%^&+=])" +
            "(?=\\\\S+$)" +
            ".{4,6}" +
            "$");
    private EditText email,password;
    private Button signup,confirm,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        signup=(Button)findViewById(R.id.signup);
        confirm=(Button)findViewById(R.id.confirm) ;
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main3Activity();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity();
            }
        });
    }
    public void Main3Activity(){
        Intent intent=new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
    public void Main2Activity(){
        Intent intent= new Intent(this,Main2Activity.class);
        startActivity(intent);
    }



    private boolean validateEmail(){
        String emailInput = email.getEditableText().getFilters().toString().trim();
        if(emailInput.isEmpty()){
            email.setError("Feild can't be empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){

            email.setError("please enter valid email");
            return false;
        }
        else{
            email.setError(null);
            return true;
        }
    }
    private boolean validatePassword(){
        String passwordInput = password.getEditableText().getFilters().toString().trim();
        if(passwordInput.isEmpty()){
            password.setError("Feild can't be empty");
            return false;
        }
        else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()){
            password.setError("Password too weak");
            return false;

        }
        else{
            password.setError(null);
            return true;
        }
    }

    public void confirm(View view) {
        if (!validateEmail() | validatePassword()) {
            String input = "Email:" + email.getEditableText().getFilters().toString();
            input += "\n";
            input += "password" + password.getEditableText().getFilters().toString();
            input += "\n";
            Toast.makeText(this,input, Toast.LENGTH_SHORT).show();
        }
    }

}
