package shafi.sbf.com.abdroidsplashscreen;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    public static int S_TIME_OUT =6000;
    TextView animateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(Welcome.this,MainActivity.class));
                finish();
            }
        },S_TIME_OUT);

        animateTextView = findViewById(R.id.welcome_text);

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(2000f,0f);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator()); // increase the speed first and then decrease
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float progress = (float) animation.getAnimatedValue();
                animateTextView.setTranslationY(progress);
                // no need to use invalidate() as it is already present in             //the text view.
            }
        });
        valueAnimator.start();
    }
}
