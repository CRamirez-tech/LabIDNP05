package idnp.lab05.labidnp05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    private ArrayList<Usuario> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulanteregistro);

        list = getIntent().getParcelableArrayListExtra("lista");

        Button btnRegistro = findViewById(R.id.btnRegistro);
        EditText editDni = findViewById(R.id.editDni);
        EditText editNombres = findViewById(R.id.editNombres);
        EditText editApellidos = findViewById(R.id.editApellidos);
        EditText editBirthDate = findViewById(R.id.editBirthDate);
        Spinner spinnerColegio = findViewById(R.id.spinnerColegio);
        Spinner spinnerCarrera = findViewById(R.id.spinnerCarrera);

        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(8);
        editDni.setFilters(FilterArray);

        btnRegistro.setOnClickListener(view -> {
            if (!editDni.getText().toString().equals("")) {
                int dni = Integer.parseInt(editDni.getText().toString());
                String names = editNombres.getText().toString();
                String lastnames = editApellidos.getText().toString();
                String birthday = editBirthDate.getText().toString();
                String college = spinnerColegio.getSelectedItem().toString();
                String carreer = spinnerCarrera.getSelectedItem().toString();
                boolean tempRegister = true;
                Log.i("Dni:", "" + dni);
                Log.i("Names :", "" + names);
                Log.i("Lastnames :", "" + lastnames);
                Log.i("Birthday :", "" + birthday);
                for (Usuario user : list) {
                    if (dni == user.getDni()) {
                        tempRegister = false;
                        break;
                    }
                }
                if (tempRegister) {
                    Log.i("Errors", "User Add");
                    list.add(new Usuario(dni, names, lastnames, birthday, college, carreer));
                }
                Log.i("Arraylist", list + "");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putParcelableArrayListExtra("lista",list);
                startActivity(intent);
                finish();
            }
        });
    }
}