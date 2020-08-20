package solutions.prantae.shirui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;
    NavigationView navigationView;
    RecyclerView myRecyclerView1, myRecyclerView2, categoriesRecycler;
    LinearLayout contentView;

    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;
    ImageView navigationBar;
    ViewFlipper imgBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        myDrawer = findViewById(R.id.myDrawer);
        navigationView = findViewById(R.id.navigationView);
        navigationBar = findViewById(R.id.navigationBar);
        contentView = findViewById(R.id.content);

        imgBanner = findViewById(R.id.imgBanner);

        int slider[] = {
                R.drawable.drug1, R.drawable.drug8, R.drawable.home, R.drawable.home
        };
        for(int slide:slider){
            bannerFliper(slide);
        }

        navigationDrawer();
    }

    public void bannerFliper(int image){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(image);
        imgBanner.addView(imageView);
        imgBanner.setFlipInterval(6000);
        imgBanner.setAutoStart(true);
        imgBanner.setInAnimation(this, android.R.anim.fade_in);
        imgBanner.setInAnimation(this, android.R.anim.fade_out);
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        navigationBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myDrawer.isDrawerVisible(GravityCompat.START)) {
                    myDrawer.closeDrawer(GravityCompat.START);
                } else {
                    myDrawer.openDrawer(GravityCompat.START);
                }
            }
        });
        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        myDrawer.setScrimColor(getResources().getColor(R.color.color5));
        myDrawer.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(myDrawer.isDrawerVisible(GravityCompat.START)){
            myDrawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//        switch (item.getItemId()){
//            case R.id.nav_categories:
//                startActivity(new Intent(getApplicationContext(),CategoriesActivity.class));
//                break;
//        }
        return true;
    }
    // for navigation
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (myToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}