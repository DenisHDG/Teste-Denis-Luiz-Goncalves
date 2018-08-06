package denisluizgoncalves.anobissexto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private TextInputLayout textInputAno;
    private Button btnVerificaAnoBissexto;
    private int ano;
    private TextView textViewResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputAno = findViewById(R.id.text_input_ano);
        textViewResultado = findViewById(R.id.text_view_resultado);
        btnVerificaAnoBissexto = findViewById(R.id.btn_verifica_ano_bissexto);
        
        btnVerificaAnoBissexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validaAno();

            }
        });
    }

        private  boolean validaAno(){
            String anoInput = textInputAno.getEditText().getText().toString().trim();
            if(anoInput.isEmpty() || ano <0) {
                if(ano <0){
                    textInputAno.setError("Não existe ano negativo! ");
                }else {
                    textInputAno.setError("O campo está Vazio! ");
                }
                return true;
            }else {
                textInputAno.setError(null);
                ano = Integer.parseInt(anoInput);
                verificaAnoBissexto(ano);
                return false;
            }
        }

        public boolean verificaAnoBissexto(int ano) {
            if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                if( textViewResultado != null){
                    textViewResultado.setText("O ano de  "+ ano +"  é um ano Bissexto!");
                    textViewResultado.setVisibility(View.VISIBLE);
                }
                return true;
            } else {
                if( textViewResultado != null) {
                    textViewResultado.setText("O ano de  " + ano + "  não é um ano Bissexto!");
                    textViewResultado.setVisibility(View.VISIBLE);
                }
                return false;
            }
        }
}

