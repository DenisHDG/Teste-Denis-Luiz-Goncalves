package denis.agence;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class NavigationDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView navigationView;
    private WebView webViewGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        mDrawerLayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        webViewGoogle = findViewById(R.id.web_view_google);
        webViewGoogle.getSettings().setJavaScriptEnabled(true);
        webViewGoogle.setWebViewClient(new WebViewClient());
        webViewGoogle.loadUrl("https://www.google.com");
        webViewGoogle.setVisibility(View.GONE);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.google:
                exibeWebView();
                break;
            case R.id.notification:
                exibeNotificacao();
                break;
        }
        return true;
    }

    private void exibeWebView() {
        webViewGoogle.setVisibility(View.VISIBLE);
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void exibeNotificacao() {

        int id = 1;
        Intent intent = new Intent(this, MensagemActivity.class);
        intent.putExtra("msg", "Agence test");
        String contentTitle = "Notification";
        String contentText = "Agence test";
        NotificationUtil.create(this, intent, contentTitle, contentText, id);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        webViewGoogle.setVisibility(View.GONE);
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);


    }
}
