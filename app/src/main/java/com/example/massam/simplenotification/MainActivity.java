package com.example.massam.simplenotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view){
        //Notif Selected
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pIntent =  PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT );


        Notification noti = new Notification.Builder(this)
                .setContentTitle("New mail from " + "test@gmail.com")
                .setContentText("Subject").setSmallIcon(R.drawable.ic_launcher_background )
                .setContentIntent(pIntent)
                .addAction(R.drawable.ic_launcher_background , "Call", pIntent)
                .addAction(R.drawable.ic_launcher_background , "More", pIntent)
                .addAction(R.drawable.ic_launcher_background , "And more", pIntent).build();


        //
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        NotificationManager.notify().
        noti.flags |= Notification.FLAG_AUTO_CANCEL;
        mNotificationManager.notify(001, noti);
    }
}
