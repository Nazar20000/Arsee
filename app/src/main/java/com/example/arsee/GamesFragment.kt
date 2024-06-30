package com.example.arsee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.arsee.databinding.FragmentGamesBinding
import com.example.arsee.databinding.FragmentHomaBinding


class GamesFragment : Fragment() {
    lateinit var binding: FragmentGamesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGamesBinding.inflate(inflater)
        return binding.root

    }

    companion object {
        @JvmStatic
        fun newInstance() = GamesFragment()
    }

}