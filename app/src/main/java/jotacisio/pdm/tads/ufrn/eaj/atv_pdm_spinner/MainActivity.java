package jotacisio.pdm.tads.ufrn.eaj.atv_pdm_spinner;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private String [] personagens =  new String [] {"Harry Potter","Ronald Weasley","Hermione Granger","Draco Malfoy","Albus Dumbledore","Severus Snape"};
    private int [] imagens =  new int [] {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6};

    ImageView image;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.imagem);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,personagens);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(meulistener);

    }

    private AdapterView.OnItemSelectedListener meulistener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            image.setImageResource(imagens[position]);
            Snackbar
                    .make(view, R.string.texto_snack, Snackbar.LENGTH_LONG )
                    .setAction(R.string.snack_cancelar, listenersnack)
                    .show();
        }
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private View.OnClickListener listenersnack = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            image.setImageResource(imagens[0]);
            spinner.setSelection(0);
        }
    };
}
