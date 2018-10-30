package com.ricardogwill.notificationmanagerapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
// NOT WORKING!!!
// Based on the tutorial here: https://www.youtube.com/watch?v=GQPyXkbikXw&list=PLS1QulWo1RIbb1cYyzZpLFCKvdYV_yJ-E&index=29
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notifyMeButtonOnClick();
    }

    Button notifyMeButton;

    public void notifyMeButtonOnClick() {
        notifyMeButton = findViewById(R.id.notify_me_button);
        notifyMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notifyIntent = new Intent();
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, notifyIntent, 0);
                Notification notification = new Notification.Builder(MainActivity.this)
                        .setTicker("Ticker Title")
                        .setContentTitle("Content Title")
                        .setContentText("Content Text")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .addAction(R.drawable.ic_launcher_foreground, "Action 1", pendingIntent)
                        .addAction(R.drawable.ic_launcher_foreground, "Action 2", pendingIntent)
                        .setContentIntent(pendingIntent).getNotification();

                notification.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0, notification);
            }
        });
    }

}
