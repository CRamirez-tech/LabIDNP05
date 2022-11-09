package idnp.lab05.labidnp05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private ArrayList<Usuario> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        list = getIntent().getParcelableArrayListExtra("lista");

        Button btnLogin = findViewById(R.id.login);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        btnLogin.setOnClickListener(view -> {
            String usuario = username.getText().toString();
            String pass = password.getText().toString();
            if (usuario!="" && pass!="")
            {
                Log.i("User:",usuario);
                Log.i("Password:",pass);
                for (Usuario user: list) {
                    if (usuario.equals(String.valueOf(user.getDni())) && pass.equals(user.getNames()))
                    {
                        Log.d("Dni",user.getDni()+"");
                        Intent intent = new Intent(getApplicationContext(), SucessActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }
}