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

        val artistNames = ArrayList<String>()
        val songtitle = ArrayList<String>()
        val ratings = ArrayList<Int>()
        val comments = ArrayList<String>()

        val btnaddnew = findViewById<Button>(R.id.btnaddNew)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnexit = findViewById<Button>(R.id.btnExit)

        btnaddnew.setOnClickListener {
        val artist = edtArtist.text.toString()
        val rating = edtratings.text.toString().toIntOrNull() ?: 0
        val comment = edtComment.text.toString()
        val Title = edtsongTitle.text.toString()     
        }

        btnexit.setOnClickListener {
            finishAffinity()// finishes the app when clicked
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, DetailedReview::class.java)
            startActivity(intent)//goes to the next screen
        }

    }

}
