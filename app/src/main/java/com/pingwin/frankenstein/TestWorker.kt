package com.pingwin.frankenstein

import android.content.Context
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class TestWorker(context: Context, workerParameters: WorkerParameters):
    Worker(context, workerParameters){
    override fun doWork(): Result {
        var builder = NotificationCompat.Builder(applicationContext,"Test")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Title Test")
            .setContentText("This is a test notification")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(applicationContext)){
            notify(1,builder.build())
        }
        return Result.success()
    }
}