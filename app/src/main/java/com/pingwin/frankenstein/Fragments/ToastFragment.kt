package com.pingwin.frankenstein.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.pingwin.frankenstein.R

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ToastFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_toast_to_home).setOnClickListener {
            findNavController().navigate(R.id.action_ToastFragment_to_MainFragment)
        }
        view.findViewById<Button>(R.id.button_toast_short).setOnClickListener {
            Toast.makeText(context,"This is a short Toast!", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.button_toast_long).setOnClickListener {
            Toast.makeText(context,"This is a long Toast!", Toast.LENGTH_LONG).show()
        }
    }
}
