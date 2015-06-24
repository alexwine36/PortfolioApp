package com.example.alexanderwine.portfolio3;

import android.app.Activity;
import android.os.Build;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.Button;

import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ListResourceBundle;
import java.util.ResourceBundle;

import javax.xml.datatype.Duration;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.rotation);
        animRotate.setFillAfter(true);

        final Animation animTranslate = AnimationUtils.loadAnimation(this, R.anim.translate);
        animTranslate.setFillAfter(true);

        final Animation animUntranslate = AnimationUtils.loadAnimation(this, R.anim.untranslate);
        animUntranslate.setFillAfter(true);

        final Animation animUnrotate = AnimationUtils.loadAnimation(this, R.anim.unrotate);
        animUnrotate.setFillAfter(true);

        Button btnRotate = (Button) findViewById(R.id.btn_rotate);

        final ScrollView buttons = (ScrollView) findViewById(R.id.scrollView);

        btnRotate.setOnClickListener(new View.OnClickListener() {

            boolean clicked = false;

            @Override
            public void onClick(View v) {

                if (clicked == false) {
                    v.startAnimation(animRotate);
                    buttons.startAnimation(animTranslate);
                    buttons.smoothScrollTo(0, 0);
                    clicked = true;
                } else {
                    v.startAnimation(animUnrotate);
                    buttons.startAnimation(animUntranslate);
                    clicked = false;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showToast(View view) {
        Button b = (Button) view;
        Resources res = getResources();
        Context context = getApplicationContext();
        String buttonText = b.getText().toString();
        String toast_content = String.format(res.getString(R.string.toast), buttonText);

        Toast button_toast = Toast.makeText(context, toast_content, Toast.LENGTH_SHORT);
        button_toast.show();
    }

}
