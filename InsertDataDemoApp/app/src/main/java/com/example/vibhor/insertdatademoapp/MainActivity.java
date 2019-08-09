package com.example.vibhor.insertdatademoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText usernameText , passwordText ;
    VibhDatabaseAdapter vibhDatabaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibhDatabaseAdapter = new VibhDatabaseAdapter(this);


        usernameText = (EditText) findViewById(R.id.username_edittext);
        passwordText = (EditText) findViewById(R.id.passsword_edittext);
    }


    public void onAddUser(View view)
    {
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        long id=vibhDatabaseAdapter.insertData(username,password);
        if(id<0)
        {
            Message.message(this, "data is saved successfully");
        }else{
            Message.message(this,"something went wrong");
        }



    }
}
