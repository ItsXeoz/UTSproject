package lat.pam.utsproject

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    private lateinit var foodNameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Find TextView for food name
        foodNameTextView = findViewById(R.id.etFoodName)

        // Get the food name from the intent and set it in the TextView
        val foodName = intent.getStringExtra("foodName")
        foodNameTextView.text = foodName ?: "Unknown"
    }
}
