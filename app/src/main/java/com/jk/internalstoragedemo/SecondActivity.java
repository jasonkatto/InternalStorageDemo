package com.jk.internalstoragedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;

public class SecondActivity extends AppCompatActivity {

    TextView getName, getPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getName=findViewById(R.id.getname);
        getPassword=findViewById(R.id.getpass);
    }

    public void load(View view) {
        try {
            FileInputStream fileInputStream=openFileInput("Code.txt");
            int read= -1;
            StringBuffer buffer = new StringBuffer();
            while((read =fileInputStream.read())!= -1){
                buffer.append((char)read);
            }
            Log.d("Code", buffer.toString());
            String name= buffer.substring(0, buffer.indexOf(" "));
            String pass= buffer.substring(buffer.indexOf(" ")+1);
            getName.setText(name);
            getPassword.setText(pass);
        }catch (Exception e){
            e.printStackTrace();
        }
        Toast.makeText(this, "Loadded", Toast.LENGTH_SHORT).show();
    }

    public void back(View view) {
        Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
