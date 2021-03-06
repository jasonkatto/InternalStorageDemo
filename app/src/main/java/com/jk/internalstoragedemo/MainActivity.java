package com.jk.internalstoragedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editName, editPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPass= findViewById(R.id.editPass);
        editName=findViewById(R.id.editName);

    }


    public void save(View view) {
        File file = null;
        String name = editName.getText().toString();
        String password= editPass.getText().toString();

        FileOutputStream fileOutputStream = null;
        try {
            name = name + " ";
            file=getFilesDir();
            fileOutputStream=openFileOutput("Code.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(name.getBytes());
            fileOutputStream.write(password.getBytes());
            Toast.makeText(this, "Saved \n " + "Path --"
                    + file+ "\tCode.txt", Toast.LENGTH_SHORT).show();
            editName.setText("");
            editPass.setText("");
            return;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void next(View view) {
        Toast.makeText(this, "NEXT", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
