package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText subject,body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subject=findViewById(R.id.et_title);
        body=findViewById(R.id.et_message);

        Button WA_PK=findViewById(R.id.bt_WA_PK);
        WA_PK.setOnClickListener(v -> action("+92334456560"));

        Button WA_USA=findViewById(R.id.bt_WA_USA);
        WA_USA.setOnClickListener(v -> action("+1 (617) 960-7156"));

        Button WA_GB=findViewById(R.id.bt_WA_GB);
        WA_GB.setOnClickListener(v -> action("+919811364444"));

        Button bt_site=findViewById(R.id.bt_site);
        bt_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String websiteUrl="https://www.goodwordquran.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(websiteUrl));
                startActivity(intent);
            }
        });

        Button bt_mail=findViewById(R.id.bt_send);
        bt_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipientEmail="shabbymalik007@gmail.com";
                String emailSubject=subject.getText().toString();
                String emailBody=body.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipientEmail});
                intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
                intent.putExtra(Intent.EXTRA_TEXT, emailBody);
            }
        });
    }
    private void action(String num)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + num));
        startActivity(intent);
    }
}