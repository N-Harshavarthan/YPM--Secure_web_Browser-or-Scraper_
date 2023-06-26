package com.ypm.webbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/*import org.apache.commons.io.FileUtils;*/

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.lang.Thread;


class ConnectToIPAddress {
    public static void main(String[] args) {
        try {


            Object Crnt ;
            String[] proxy_list = {"62.171.189.81", "187.204.68.176","34.23.45.223","49.0.2.242","157.254.193.139","43.255.113.232","190.61.88.147"};
            int[] port_list = {80, 53281, 80, 8090, 80, 8082, 8080};
            String Demo_proxies[]= {};
            while(true)
            {
                for (int i = 0; i < 7; i++)
                {

                    InetAddress ipAddress_crnt = InetAddress.getByName(proxy_list[i]);

                    int port = port_list[i];
                    Socket socket = new Socket(ipAddress_crnt, port);

                    // Connection with the socket...
                    Thread.sleep(33000);

                    // Close the socket
                    socket.close();
                }
            }
        }
        catch (IOException | InterruptedException e) {
            // Handling any errors that occurred while connecting
            e.printStackTrace();
        }
    }
}

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText urlET = findViewById(R.id.urlET);

        final LinearLayout instagramBtn = findViewById(R.id.instagramBtn);
        final LinearLayout facebookBtn = findViewById(R.id.facebookBtn);
        final LinearLayout linkednBtn = findViewById(R.id.linkednBtn);
        final LinearLayout pinterestBtn = findViewById(R.id.pinterestBtn);
        final LinearLayout twitterBtn = findViewById(R.id.twitterBtn);
        final LinearLayout youtubeBtn = findViewById(R.id.youtubeBtn);


        urlET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    final String urlTxt = urlET.getText().toString();

                    if (!urlTxt.isEmpty()) {

                        urlET.setText("");
                        Intent intent = new Intent(MainActivity.this, BrowserView.class);
                        intent.putExtra("url", urlTxt);

                        startActivity(intent);
                    }
                }
                return false;
            }
        });

        instagramBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, BrowserView.class);
                intent.putExtra("url", "www.instagram.com");

                startActivity(intent);
            }
        });

        facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BrowserView.class);
                intent.putExtra("url", "www.facebook.com");

                startActivity(intent);
            }
        });

        linkednBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BrowserView.class);
                intent.putExtra("url", "www.linkedin.com");

                startActivity(intent);
            }
        });

        pinterestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BrowserView.class);
                intent.putExtra("url", "www.pinterest.com");

                startActivity(intent);
            }
        });
        twitterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BrowserView.class);
                intent.putExtra("url", "www.twitter.com");

                startActivity(intent);
            }
        });
        youtubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BrowserView.class);
                intent.putExtra("url", "www.youtube.com");

                startActivity(intent);
            }
        });
    }
}


