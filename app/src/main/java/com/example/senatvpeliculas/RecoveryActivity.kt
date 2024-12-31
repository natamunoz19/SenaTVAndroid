import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.senatvpeliculas.R

class RecoveryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recovery)

        val emailInput: EditText = findViewById(R.id.emailInput)
        val recoveryButton: Button = findViewById(R.id.recoveryButton)


        // Recovery Button Action
        recoveryButton.setOnClickListener {
            val email = emailInput.text.toString()

            if(email.isNotBlank()){
                // Registration logic here
                Toast.makeText(this, "Correo electrónico de restablecimiento de contraseña enviado", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else{
                // Display error message
                emailInput.error = "Email requerido"
            }
        }
    }
}
