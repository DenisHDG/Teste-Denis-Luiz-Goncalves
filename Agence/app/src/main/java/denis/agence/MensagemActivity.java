package denis.agence;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MensagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);
        String msg = getIntent().getStringExtra("msg");
        TextView text = findViewById(R.id.text);
        text.setText(msg);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MensagemActivity.this, NavigationDrawer.class);
        startActivity(intent);
        finish();
    }
}
