package idnp.lab05.labidnp05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Usuario> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnNuevo = findViewById(R.id.btnNuevo);
        Button btnInfo = findViewById(R.id.btnInfo);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnNuevo.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            intent.putParcelableArrayListExtra("lista",list);
            startActivity(intent);
        });

        btnInfo.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
            intent.putParcelableArrayListExtra("lista",list);
            startActivity(intent);
        });

        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.putParcelableArrayListExtra("lista",list);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        list = getIntent().getParcelableArrayListExtra("lista");
        if (list==null){
            list = new ArrayList<>();
        }
        Log.i("Arraylist",list +"");
    }
}