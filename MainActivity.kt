
package com.example.interviewface

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewPractice: RecyclerView
    private lateinit var practiceAdapter: PracticeInterviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewPractice = findViewById(R.id.recyclerViewPractice)
        practiceAdapter = PracticeInterviewAdapter(getPracticeInterviews())
        recyclerViewPractice.adapter = practiceAdapter
        recyclerViewPractice.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.navigation_inicio

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_inicio -> {
                    // Current screen, do nothing or refresh
                    true
                }
                R.id.navigation_entrevistas -> {
                    // Navigate to Entrevistas screen
                    startActivity(Intent(this, EntrevistasActivity::class.java))
                    true
                }
                R.id.navigation_comentarios -> {
                    // Navigate to Comentarios screen
                    startActivity(Intent(this, ComentariosActivity::class.java))
                    true
                }
                R.id.navigation_perfil -> {
                    // Navigate to Perfil screen
                    startActivity(Intent(this, PerfilActivity::class.java))
                    true
                }
                R.id.navigation_mas -> {
                    // Navigate to Más screen
                    startActivity(Intent(this, MasActivity::class.java))
                    true
                }
                else -> false
            }
        }

        val startButton = findViewById<Button>(R.id.buttonStart)
        startButton.setOnClickListener {
            // Handle start button click, e.g., open interview detail or start practice
            // For example, open EntrevistasActivity
            startActivity(Intent(this, EntrevistasActivity::class.java))
        }
    }

    private fun getPracticeInterviews(): List<PracticeInterview> {
        return listOf(
            PracticeInterview(
                "Entrevista de trabajo de marketing",
                "Prepárate para tu puesto de marketing entrevista",
                "https://cdn.pixabay.com/photo/2017/01/10/19/05/marketing-1960506_1280.jpg"
            ),
            PracticeInterview(
                "Entrevista de ingeniero de software",
                "Perfecciona tus habilidades para tu entrevista de ingeniería de software",
                "https://cdn.pixabay.com/photo/2017/06/10/07/18/keyboard-2389211_1280.jpg"
            ),
            PracticeInterview(
                "Entrevista de análisis de datos",
                "Prepárate para tu entrevista de análisis de datos",
                "https://cdn.pixabay.com/photo/2017/06/10/07/18/data-2389212_1280.jpg"
            )
        )
    }
}
