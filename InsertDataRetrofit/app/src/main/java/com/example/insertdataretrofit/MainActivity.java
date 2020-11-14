package com.example.insertdataretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText etName,etEmail;
    private Button insBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=(EditText)findViewById(R.id.et_name);
        etEmail=(EditText)findViewById(R.id.et_email);


        insBtn=(Button)findViewById(R.id.btn_insert);
        insBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

    }

    private void insertData() {
        String name=etName.getText().toString().trim();
        String email=etEmail.getText().toString().trim();

        if (name.isEmpty()) {
            etName.setError("Enter name");
            etName.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            etEmail.setError("enter email");
            etEmail.requestFocus();
            return;
        }

        Call<ResponseBody>call=MyClient.getInstance().getMyApi().insertdata(name,email);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(MainActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error" + t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}