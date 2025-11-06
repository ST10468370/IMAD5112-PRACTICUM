package com.example.cineview

import android.content.Intent
import android.content.pm.PackageItemInfo
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    companion object {
        val packingList = mutableListOf<MovieDetails>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }
        val editName = findViewById<EditText>(R.id.editName)
        val editDirector = findViewById<EditText>(R.id.editDirector)
        val editRating = findViewById<EditText>(R.id.editRating)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnAvg = findViewById<Button>(R.id.btnAvg)
        val btnExit = findViewById<Button>(R.id.btnExit)


        btnAdd.setOnClickListener {
            val nameofmovie = editName.text.toString()
            val nameofdirector = editDirector.text.toString()
            val rating = editRating.text.toString().toIntOrNull() ?:0

            if (nameofmovie.isNotBlank() && nameofdirector.isNotBlank() && rating >0){
                packingList.add(MovieDetails(nameofmovie,nameofdirector, rating))
                Toast.makeText(this,"Item added", Toast.LENGTH_SHORT).show()
                editName.text.clear()
                editDirector.text.clear()
                editRating.text.clear()
            } else{
                Toast.makeText(this,"Please enter a valid name for a movie or director or rating", Toast.LENGTH_SHORT).show()
            }
        }
        btnNext.setOnClickListener {
            startActivity(Intent(this, SecondActivity2::class.java))
        }
        btnExit.setOnClickListener {
            finishAffinity()
        }

    }




    }




