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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.senatvpeliculas.R

class RegisterActivity : AppCompatActivity() {

    private var isPasswordVisible = false
    private var isConfirmPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val emailInput: EditText = findViewById(R.id.emailInput)
        val nameInput: EditText = findViewById(R.id.nameInput)
        val lastNameInput: EditText = findViewById(R.id.lastNameInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val confirmPasswordInput: EditText = findViewById(R.id.confirmPasswordInput)
        val togglePasswordVisibility: ImageButton = findViewById(R.id.togglePasswordVisibility)
        val toggleConfirmPasswordVisibility: ImageButton = findViewById(R.id.toggleConfirmPasswordVisibility)
        val registerButton: Button = findViewById(R.id.registerButton)
        val terms: TextView = findViewById(R.id.registerTerms)
        val content = SpannableString("Términos y condiciones")
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        terms.text = content

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

        // Toggle confirm password visibility
        toggleConfirmPasswordVisibility.setOnClickListener {
            isConfirmPasswordVisible = !isConfirmPasswordVisible
            if (isConfirmPasswordVisible) {
                confirmPasswordInput.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                toggleConfirmPasswordVisibility.setImageResource(R.drawable.outline_remove_red_eye_24)
            } else {
                confirmPasswordInput.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                toggleConfirmPasswordVisibility.setImageResource(R.drawable.outline_remove_red_eye_24)
            }
            confirmPasswordInput.setSelection(confirmPasswordInput.text.length) // Keep cursor at the end
        }

        // Register Button Action
        registerButton.setOnClickListener {
            val email = emailInput.text.toString()
            val name = nameInput.text.toString()
            val lastName = lastNameInput.text.toString()
            val password = passwordInput.text.toString()
            val confirmPassword = confirmPasswordInput.text.toString()

            if (email.isNotEmpty() && name.isNotEmpty() && lastName.isNotEmpty() &&
                password.isNotEmpty() && confirmPassword.isNotEmpty()
            ) {
                if (password == confirmPassword) {
                    // Registration logic here
                    Toast.makeText(this, "Registro exitoso!", Toast.LENGTH_SHORT).show()
                } else {
                    confirmPasswordInput.error = "Las contraseñas no coinciden"
                }
            } else {
                // Display error messages
                if (email.isEmpty()) emailInput.error = "Email requerido"
                if (name.isEmpty()) nameInput.error = "Nombre requerido"
                if (lastName.isEmpty()) lastNameInput.error = "Apellido requerido"
                if (password.isEmpty()) passwordInput.error = "Contraseña requerida"
                if (confirmPassword.isEmpty()) confirmPasswordInput.error = "Confirmar contraseña requerido"
            }
        }
    }
}
