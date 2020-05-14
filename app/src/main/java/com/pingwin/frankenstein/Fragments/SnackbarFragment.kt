package com.pingwin.frankenstein.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.pingwin.frankenstein.R

/**
 * A simple [Fragment] subclass.
 */
class SnackbarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_snackbar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_snackbar_to_home).setOnClickListener {
            findNavController().navigate(R.id.action_snackbarFragment_to_MainFragment)
        }

        view.findViewById<Button>(R.id.button_snackbar_basic).setOnClickListener {
            val snackbar = Snackbar.make(view.findViewById<CoordinatorLayout>(R.id.coordinatorLayout), "Basic Snackbar", Snackbar.LENGTH_LONG)
            snackbar.show()
        }

        view.findViewById<Button>(R.id.button_snackbar_with_action).setOnClickListener {
            val snackbar = Snackbar.make(view.findViewById(R.id.coordinatorLayout), "Snackbar with action", Snackbar.LENGTH_LONG )
            snackbar.setAction("Cool Action", SnackbarListener())
            snackbar.show()
        }
    }

    inner class SnackbarListener: View.OnClickListener{
        override fun onClick(view: View){
            Toast.makeText(context, "Snackbar Action Toast", Toast.LENGTH_SHORT).show()
        }
    }
}
