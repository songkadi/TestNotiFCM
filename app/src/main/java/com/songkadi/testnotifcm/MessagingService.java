/**
 * Copyright 2016 Google Inc. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.songkadi.testnotifcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import com.songkadi.testnotifcm.entity.ServerStatus;
import com.songkadi.testnotifcm.entity.StatusAmount;

import java.util.Map;

public class MessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";
    private static final Gson gson = new Gson();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        try {
            Map<String, String> data = remoteMessage.getData();
            if (data.size() > 0) {
                Log.i(TAG, "Message data payload: " + data);

                ServerStatus serverStatus = new ServerStatus(
                        data.get("startTime"),
                        data.get("uptime"),
                        data.get("timestamp"),
                        data.get("serverName"),
                        data.get("serverPort"),
                        gson.fromJson(data.get("memory"), StatusAmount.class),
                        gson.fromJson(data.get("thread"), StatusAmount.class)
                );

                sendNotification(serverStatus);
            }
        } catch (Exception e) {
            FirebaseCrash.report(e);
        }

        super.onMessageReceived(remoteMessage);
    }

    private void sendNotification(ServerStatus serverStatus) {
        Intent intent = new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_menu_manage)
                .setContentTitle(serverStatus.getServerName())
                .setContentText(serverStatus.getStartTime())
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify((int) System.currentTimeMillis(), notificationBuilder.build());
    }
}