package denis.agence;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button logar;
    private Button novoUsuario;
    private TextInputLayout textInputLayoutUsuario;
    private TextInputLayout textInputLayoutSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logar = findViewById(R.id.btn_logar);
        novoUsuario = findViewById(R.id.btn_novo_usuario);
        textInputLayoutSenha = findViewById(R.id.txt_input_layout_senha);
        textInputLayoutUsuario = findViewById(R.id.text_input_layout_usuario);


        final DataBaseHelper dbHelper = new DataBaseHelper(this);
        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = textInputLayoutUsuario.getEditText().getText().toString().trim();
                String senha = textInputLayoutSenha.getEditText().getText().toString().trim();
                if (!emptyValidation()) {
                    Usuario user = dbHelper.queryUser(usuario, senha);
                    if (user != null) {
                        Bundle mBundle = new Bundle();
                        mBundle.putString("usuario", user.getUsuario());
                        Intent intent = new Intent(Login.this, NavigationDrawer.class);
                        intent.putExtras(mBundle);
                        startActivity(intent);
                        Toast.makeText(Login.this, "Bem Vindo " + user.getUsuario(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this, "Usuário não encontrado", Toast.LENGTH_SHORT).show();
                        senha.isEmpty();
                    }
                } else {
                    Toast.makeText(Login.this, "Favor preencher os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        novoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = textInputLayoutUsuario.getEditText().getText().toString().trim();
                String senha = textInputLayoutSenha.getEditText().getText().toString().trim();
                if (!emptyValidation()) {
                    dbHelper.addUser(new Usuario(usuario, senha));
                    Toast.makeText(Login.this, "Usuário Adicionado", Toast.LENGTH_SHORT).show();
                    usuario.isEmpty();
                    senha.isEmpty();
                } else {
                    Toast.makeText(Login.this, "Favor preencher os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean emptyValidation() {
        String usuario = textInputLayoutUsuario.getEditText().getText().toString().trim();
        String senha = textInputLayoutSenha.getEditText().getText().toString().trim();

        if (usuario.isEmpty()) {
            textInputLayoutUsuario.setError("Por favor, digite o nome do Usuário!");
            return true;
        } else if (senha.isEmpty()) {
            textInputLayoutSenha.setError("Por favor, digite sua senha");
            return true;
        } else {
            textInputLayoutSenha.setError(null);
            textInputLayoutUsuario.setError(null);

            return false;
        }
    }
}
