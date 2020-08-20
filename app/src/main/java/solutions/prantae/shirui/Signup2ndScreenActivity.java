package solutions.prantae.shirui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Signup2ndScreenActivity extends AppCompatActivity {
    ImageView backBtn;
    Button signup_next_btn, signup_login_btn;
    TextView signup_title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2nd_screen);

        backBtn = findViewById(R.id.backBtn);
        signup_next_btn = findViewById(R.id.signup_next_btn);
        signup_login_btn = findViewById(R.id.signup_login_btn);
        signup_title_text = findViewById(R.id.signup_title_text);

    }
    public void callNextSignupScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), Signup3rdScreenActivity.class);
        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(signup_next_btn, "transition_next_btn");
        pairs[2] = new Pair<View, String>(signup_login_btn, "transition_login_btn");
        pairs[3] = new Pair<View, String>(signup_title_text, "transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signup2ndScreenActivity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }

    }
}