package com.majemase.mideporte;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgTipo;
    Spinner spDeportes;
    TextView lblSol;
    String[] deportes = {"Salto de altura", "Atletismo", "Gimnasia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgTipo = findViewById(R.id.rgTipo);
        spDeportes = findViewById(R.id.sp_deporte);
        lblSol = findViewById(R.id.lblSol);

        spDeportes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, deportes));
        spDeportes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lblSol.setText(spDeportes.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                lblSol.setText("");
            }
        });

        rgTipo.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId != -1){
                switch (((RadioButton) group.findViewById(checkedId)).getText().toString()){
                    case "Individual":
                        deportes = new String[] {"Salto de altura", "Atletismo", "Gimnasia"};
                        break;

                    case "En pareja":
                        deportes = new String[] {"Padel", "Tenis", "Squash"};
                        break;

                    case "Grupal":
                        deportes = new String[] {"Futbol", "Rugby", "Balonmano"};
                        break;
                }
                spDeportes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, deportes));
            }
        });
    }
}