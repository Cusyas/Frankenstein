package com.pingwin.frankenstein.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.work.*
import com.pingwin.frankenstein.R
import com.pingwin.frankenstein.TestWorker
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * A simple [Fragment] subclass.
 */
class WorkManagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work_manager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_work_5minute).setOnClickListener {
            val testWorkRequest = OneTimeWorkRequestBuilder<TestWorker>()
                .setInitialDelay(5, TimeUnit.SECONDS)
                .build()
            WorkManager.getInstance(view.context).enqueue(testWorkRequest)
        }

        view.findViewById<Button>(R.id.button_work_8am).setOnClickListener {
            val workRequest = PeriodicWorkRequestBuilder<TestWorker>(
                24,
                TimeUnit.HOURS)
                //PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS,
                //TimeUnit.MILLISECONDS)
                .setInitialDelay(minutesTo8AM(), TimeUnit.MINUTES)
                .build()
            WorkManager.getInstance(view.context).enqueue(workRequest)
            Toast.makeText(view.context, "Test", Toast.LENGTH_SHORT).show()
        }
    }

    private fun minutesTo8AM(): Long{
        var delay = 0L
        val cal = Calendar.getInstance()
        val currentHour = cal.get(Calendar.HOUR_OF_DAY)
        when{
            currentHour < 8 -> delay += ((8 - currentHour - 1) * 60)
            currentHour > 8 -> delay += (24 - (currentHour - 8 + 1)) * 60
        }
        // adding minutes to delay
        delay += 60 - cal.get(Calendar.MINUTE)

        return delay
    }
}