package za.ac.iie.musicplaylistmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val btnaddnew = findViewById<Button>(R.id.btnaddNew)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnexit = findViewById<Button>(R.id.btnExit)

        btnaddnew.setOnClickListener {

        }

        btnexit.setOnClickListener {
            finishAffinity()
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, DetailedReview::class.java)
            startActivity(intent)
        }

    }

}
