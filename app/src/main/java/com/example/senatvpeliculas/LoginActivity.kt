import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.senatvpeliculas.R


class LoginActivity : AppCompatActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailInput: EditText = findViewById(R.id.emailInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val togglePasswordVisibility: ImageButton = findViewById(R.id.togglePasswordVisibility)
        val forgotPassword: TextView = findViewById(R.id.forgotPassword)
        val signInButton: Button = findViewById(R.id.signInButton)
        val registerTextView: TextView = findViewById(R.id.register)

        // Toggle password visibility
        togglePasswordVisibility.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                passwordInput.transformationMethod = HideReturnsTransformationMethod.getInstance()
                togglePasswordVisibility.setImageResource(R.drawable.outline_remove_red_eye_24)
            } else {
                passwordInput.transformationMethod = PasswordTransformationMethod.getInstance()
                togglePasswordVisibility.setImageResource(R.drawable.outline_remove_red_eye_24)
            }
            passwordInput.setSelection(passwordInput.text.length) // Keep cursor at the end
        }

        // Forgot Password Action
        forgotPassword.setOnClickListener {
            val intent = Intent(this, RecoveryActivity::class.java)
            startActivity(intent)
        }

        // Sign In Button Action
        signInButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Display error message
                emailInput.error = if (email.isEmpty()) "Email requerido" else null
                passwordInput.error = if (password.isEmpty()) "Contraseña requerida" else null
            }
        }

        val content = SpannableString("Regístrate")
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        registerTextView.text = content

        registerTextView.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
