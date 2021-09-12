package com.Eco_Semana4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.InetAddress;

public class MainActivity extends AppCompatActivity {

    private EditText ipNumber1;
    private EditText ipNumber2;
    private EditText ipNumber3;
    private EditText ipNumber4;

    private Button buttonPing;
    private Button buttonSearch;

    private TextView txtMyIP;
    private TextView txtIP;

    private String localIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipNumber1 = findViewById(R.id.IPnumber1);
        ipNumber2 = findViewById(R.id.IPnumber2);
        ipNumber3 = findViewById(R.id.IPnumber3);
        ipNumber4 = findViewById(R.id.IPnumber4);

        buttonPing = findViewById(R.id.bnPing);
        buttonSearch = findViewById(R.id.bnSearch);

        txtMyIP = findViewById(R.id.txtMyIP);
        txtIP = findViewById(R.id.txtIP);


        Thread getIP = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    localIP = inetAddress.getHostAddress();
                    txtIP.setText(localIP);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        getIP.start();

        buttonPing.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this, PingActivity.class);
                    startActivity(i);
                }
        );
    }
}