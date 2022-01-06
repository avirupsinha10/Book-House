package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    EditText t1,t2,un,Phone;
    Button Register;
    TextView tv;
    SharedPreferences pf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("Sign Up");
        // t1,t2,Register
        t1=(EditText) findViewById(R.id.mEmail);
        t2=(EditText)findViewById(R.id.mPassword); //password
        Register=(Button)findViewById(R.id.Login);
        tv=(TextView)findViewById(R.id.tv);
        un=(EditText)findViewById(R.id.mUsername); //username
        Phone=(EditText)findViewById(R.id.Phone);

        checkRecord();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pf=getSharedPreferences("credentials",MODE_PRIVATE);
                SharedPreferences.Editor editor=pf.edit();
                editor.putString("username",un.getText().toString());
                editor.putString("password",t2.getText().toString());
                editor.apply();
                t1.setText("");
                t2.setText("");
                un.setText("");
                Phone.setText("");
                tv.setText("Credentials Saved Successfully");
                tv.setTextColor(Color.GREEN);
            }
        });
    }

    public void checkRecord()
    {
        SharedPreferences pf=getSharedPreferences("credentials",MODE_PRIVATE);
        if(pf.contains("username"))
        {
            un.setText(pf.getString("username",""));
            t2.setText(pf.getString("password",""));
        }
        else
        {
            tv.setText("Record Not Found!");
            tv.setTextColor(Color.RED);

        }
    }
}