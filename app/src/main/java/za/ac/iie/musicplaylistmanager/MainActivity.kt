package za.ac.iie.musicplaylistmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val names = ArrayList<String>()
    private val titles = ArrayList<String>()
    private val ratings = ArrayList<Int>()
    private val comments = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtArtist = findViewById<EditText>(R.id.edtArtist)
        val edtsongTitle = findViewById<EditText>(R.id.edtsongTitle)
        val edtratings = findViewById<EditText>(R.id.edtRating)
        val edtComment = findViewById<EditText>(R.id.edtComment)

        val btnaddnew = findViewById<Button>(R.id.btnaddNew)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnexit = findViewById<Button>(R.id.btnExit)

        btnaddnew.setOnClickListener {
            val artist = edtArtist.text.toString()
            val title = edtsongTitle.text.toString()
            val rating = edtratings.text.toString().toIntOrNull()
            val comment = edtComment.text.toString()

            if (artist.isNotEmpty() && title.isNotEmpty() && rating != null) {
                names.add(artist)
                titles.add(title)
                ratings.add(rating)
                comments.add(comment)

                // Clear the fields
                edtArtist.text.clear()
                edtsongTitle.text.clear()
                edtratings.text.clear()
                edtComment.text.clear()
                Toast.makeText(this, "Song added!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill in all fields correctly.", Toast.LENGTH_SHORT).show()
            }
        }

        btnexit.setOnClickListener {
            finishAffinity()// finishes the app when clicked
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, DetailedReview::class.java)
            intent.putStringArrayListExtra("names", names)
            intent.putStringArrayListExtra("titles", titles)
            intent.putIntegerArrayListExtra("ratings", ratings)
            intent.putStringArrayListExtra("comments", comments)
            startActivity(intent)//goes to the next screen
        }
    }
}
