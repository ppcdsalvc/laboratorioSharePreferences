package com.ittepic.tdm_laboratorio212_ivanleobardoestradasalinas;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nom,cel,dirc,hor,pla,pos;
    RadioButton bas,luj;
    SeekBar mes;
    Button guar,rec;
    TextView txt;
    int progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom=findViewById(R.id.nombre);
        cel=findViewById(R.id.celular);
        dirc=findViewById(R.id.direccion);
        hor=findViewById(R.id.hora);
        pla=findViewById(R.id.platillos);
        pos=findViewById(R.id.postres);
        bas=findViewById(R.id.basica);
        luj=findViewById(R.id.lujo);
        mes=findViewById(R.id.meseros);
        guar=findViewById(R.id.guardar);
        rec=findViewById(R.id.recuperar);
        txt=findViewById(R.id.progreso);

        mes.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txt.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void guardarPreferencia (View v){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nombre", nom.getText().toString());
        editor.putString("celular", cel.getText().toString());
        editor.putString("direccion", dirc.getText().toString());
        editor.putString("hora", hor.getText().toString());
        editor.putString("platillos", pla.getText().toString());
        editor.putString("postres", pos.getText().toString());
        editor.putBoolean("basica",bas.isChecked());
        editor.putBoolean("lujo",luj.isChecked());
        editor.putInt("meseros",mes.getProgress());
        editor.commit();


        Toast.makeText(this,"Se han Guardado tus Datos", Toast.LENGTH_LONG).show();
    }
    public void obtenerPreferencia (View v){

        String nom1,cel1,dir1,hor1,pla1,pos1;
        Boolean bas1,luj1;
        int seek;

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        nom1=sharedPreferences.getString("nombre",null);
        cel1=sharedPreferences.getString("celular",null);
        dir1=sharedPreferences.getString("direccion",null);
        hor1=sharedPreferences.getString("hora",null);
        pla1=sharedPreferences.getString("platillos",null);
        pos1=sharedPreferences.getString("postres",null);
        bas1=sharedPreferences.getBoolean("basica",false);
        luj1=sharedPreferences.getBoolean("lujo",false);
        seek=sharedPreferences.getInt("meseros",0);

        nom.setText(nom1);
        cel.setText(cel1);
        dirc.setText(dir1);
        hor.setText(hor1);
        pla.setText(pla1);
        pos.setText(pos1);
        bas.setChecked(bas1);
        luj.setChecked(luj1);
        mes.setProgress(seek);

        Toast.makeText(this,"Configuracion Cargada", Toast.LENGTH_LONG).show();
    }
}
