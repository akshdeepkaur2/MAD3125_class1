package com.akshdeep.loginexample;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.xml.validation.Validator;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.EditName);
        Password = (EditText) findViewById(R.id.EditPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);
Info.setText("No. of attempts remaining: 5");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          validate(Name.getText().toString() ,Password.getText().toString());
            }
        });

    }

        private void validate(String userName , String userPassword){
        if( (userName == "Admin")&&( userPassword == "1234")){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText("No. of attempts remaining:" + String.valueOf(counter));
            Login.setEnabled(false);
        }
        }
    }
