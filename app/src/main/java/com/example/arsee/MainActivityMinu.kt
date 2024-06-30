package com.example.arsee

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.GravityCompat
import com.example.arsee.databinding.ActivityMainMinuBinding
import com.google.android.material.navigation.NavigationView

class MainActivityMinu : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainMinuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMinuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.navigationView.setNavigationItemSelectedListener(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Arsee"

        supportFragmentManager.beginTransaction().replace(R.id.fragmentHome,
            ChatFragment.newInstance()).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.homa -> {
                Toast.makeText(this@MainActivityMinu, "Главное меню", Toast.LENGTH_SHORT).show()
                supportActionBar?.title = "Arsee"
                home()
            }

            R.id.pay -> {
                Toast.makeText(this@MainActivityMinu, "Делать платёж", Toast.LENGTH_SHORT).show()
                supportActionBar?.title = "Платежи"
                pay()
            }

            R.id.message -> {
                Toast.makeText(this@MainActivityMinu, "Делать платёж", Toast.LENGTH_SHORT).show()
                supportActionBar?.title = "Сообщение"
                message()
            }

            R.id.games -> {
                Toast.makeText(this@MainActivityMinu, "Начнём игру", Toast.LENGTH_SHORT).show()
                supportActionBar?.title = "Игры"
                games()
            }

            R.id.steame -> {
                Toast.makeText(this@MainActivityMinu, "Начнём стрим", Toast.LENGTH_SHORT).show()
                supportActionBar?.title = "Стрим"
                steam()
            }

            R.id.settings -> {
                Toast.makeText(this@MainActivityMinu, "Настройки профиля", Toast.LENGTH_SHORT).show()
                supportActionBar?.title = "Настройки"
                settings()
            }

            R.id.exit -> {
                finish()
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                menuka()
            }
            R.id.Balance -> {
                Toast.makeText(this@MainActivityMinu, "Пока что не настроено!", Toast.LENGTH_SHORT).show()
            }
            R.id.schyt -> {
                Toast.makeText(this@MainActivityMinu, "У вас нормальное количество денег 🌚", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

    private fun menuka() {
        binding.drawel.openDrawer(GravityCompat.START)
    }

    private fun home(){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentHome,
            HomaFragment.newInstance()).commit()
    }

    private fun pay(){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentHome,
            PayFragment.newInstance()).commit()
    }

    private fun settings(){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentHome,
            SettingsFragment.newInstance()).commit()
    }

    private fun games(){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentHome,
            GamesFragment.newInstance()).commit()
    }

    private fun steam(){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentHome,
            SteamFragment.newInstance()).commit()
    }

    private fun message(){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentHome,
            MessageFragment.newInstance()).commit()
    }

}
