package solutions.prantae.shirui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Signup3rdScreenActivity extends AppCompatActivity {
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup3rd_screen);

        backBtn = findViewById(R.id.backBtn);

    }
    public void callNextSignupScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), VerifyOTPActivity.class);
        startActivity(intent);

    }
}