package za.ac.iie.musicplaylistmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedReview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_review)

        val btnReturn = findViewById<Button>(R.id.btnReturn)
        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val txtList = findViewById<TextView>(R.id.txtList)
        val txtAverage = findViewById<TextView>(R.id.txtAverage)

        val names = intent.getStringArrayListExtra("names") ?: arrayListOf()
        val titles = intent.getStringArrayListExtra("titles") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()

        btnDisplay.setOnClickListener {
            val songList = StringBuilder()
            for (i in names.indices) {
                songList.append("Artist: ${names[i]}, Title: ${titles[i]}, Rating: ${ratings[i]}\n")
            }
            txtList.text = songList.toString()
        }

        btnAverage.setOnClickListener {
            if (ratings.isNotEmpty()) {
                val average = ratings.average()
                txtAverage.text = "Average Rating: %.2f".format(average)
            } else {
                txtAverage.text = "No ratings available"
            }
        }

        btnReturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)// goes back to the original screen
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}