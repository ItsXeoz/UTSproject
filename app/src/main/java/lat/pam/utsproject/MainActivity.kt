package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var usernameEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var loginButton: Button
    private lateinit var registerTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        usernameEditText = findViewById(R.id.usename_edit)
        passwordEditText = findViewById(R.id.password_edit)
        loginButton = findViewById(R.id.btnLogin)
        registerTextView = findViewById(R.id.tvRegister)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (username.isEmpty()) {
                usernameEditText.error = "Username is required"
            } else if (password.isEmpty()) {
                passwordEditText.error = "Password is required"
            }
            if (usernameEditText.text.toString() == "admin" && passwordEditText.text.toString() == "admin") {
                val intent =Intent(this, ListFoodActivity::class.java)
                startActivity(intent)
            }
        }
    }
}