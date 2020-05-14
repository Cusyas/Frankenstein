package com.pingwin.frankenstein.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.pingwin.frankenstein.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_toast_enter).setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_ToastFragment)
        }

        view.findViewById<Button>(R.id.button_snackbar_enter).setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_snackbarFragment)
        }

        view.findViewById<Button>(R.id.button_notification_enter).setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_notificationFragment)
        }

        view.findViewById<Button>(R.id.button_work_enter).setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_workManagerFragment2)
        }
    }
}
