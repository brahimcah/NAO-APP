package cat.dam.andy.UnClick;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class ActivitySplash extends AppCompatActivity {

    ProgressBar splashProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Demanem visualitzar el layout main
        setContentView(R.layout.activity_splash);
        //Vinculem el objecte splashProgress amb el id de dintre del layout
        splashProgress=findViewById(R.id.splashProgress);
        //
        ObjectAnimator.ofInt(splashProgress,"progress",100).setDuration(5000).start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(ActivitySplash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}
