package cat.dam.andy.UnClick;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    WebView web_view;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        //Cada cop que cambien de pagina en sortira un misatge de cargant dades
        progressDialog.setMessage("Loading Data...");
        progressDialog.setCancelable(false);
        //WebView i les seves configuracions
        web_view = findViewById(R.id.visorWeb);
        web_view.setVerticalScrollBarEnabled(true);
        web_view.requestFocus();
        web_view.canGoForward();
        web_view.getSettings().setDefaultTextEncodingName("utf-8");
        web_view.getSettings().setJavaScriptEnabled(true);
        //Indiquem el url de la web
        web_view.loadUrl("http://cpanel.unclick.cat/");

        web_view.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        web_view.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {
                    progressDialog.show();
                }
                if (progress == 100) {
                    progressDialog.dismiss();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(web_view!= null && web_view.canGoBack())
            web_view.goBack();
        else
            super.onBackPressed();
    }
}