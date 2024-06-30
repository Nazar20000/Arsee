package com.example.arsee

import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arsee.databinding.FragmentMessageBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.time.LocalTime
import kotlin.math.log


class MessageFragment : Fragment() {
    lateinit var binding: FragmentMessageBinding
    val list = ArrayList<ListItem>()

    val currentTime = Calendar.getInstance()
    val hour = currentTime.get(Calendar.HOUR_OF_DAY)
    val minute = currentTime.get(Calendar.MINUTE)
    val timeString = "%02d:%02d".format(hour, minute)



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MessageFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = Firebase.database
        val myRef = database.getReference("message")
        val myPass = database.getReference("password")

        myPass.setValue("Nazar")
        myRef.setValue("Hello, Kazakhstan!")
        message()
    }

    fun message() {

        for (i in 1..9) {
            list.add(ListItem(R.drawable.user, "Nazar", "Был в сети: $timeString"))
        }

        binding.rcView.setHasFixedSize(true)
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.adapter = MyAdapter(list, requireContext())
    }
}