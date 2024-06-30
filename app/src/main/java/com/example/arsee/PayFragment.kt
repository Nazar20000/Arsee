package com.example.arsee

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.arsee.databinding.FragmentHomaBinding
import com.example.arsee.databinding.FragmentPayBinding


class PayFragment : Fragment() {
    lateinit var binding: FragmentPayBinding
    private var timer: CountDownTimer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPayBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = PayFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textError.visibility = View.INVISIBLE

        Vivesty()

        Popolnit()
    }

    private fun Vivesty(){
        binding.btnVivesty.setOnClickListener {
            binding.textError.text = "Не правильно указань номер карты"
            binding.textError.visibility = View.VISIBLE

        }
    }


    private fun Popolnit(){
        binding.btnPopolnit.setOnClickListener {
            timer(10000)
        }
    }


    private fun timer(timeMillis: Long){
        timer?.cancel()
        timer = object: CountDownTimer(timeMillis, 1000) {

            override fun onTick(timeP: Long) {
                binding.timer.text = timeP.toString()
            }

            override fun onFinish() {
                binding.timer.visibility = View.VISIBLE
                binding.timer.text = "Оплата прошло успешно ✅"
            }
        }.start()
    }
}