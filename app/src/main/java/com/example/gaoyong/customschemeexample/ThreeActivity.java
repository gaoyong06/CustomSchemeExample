package com.example.gaoyong.customschemeexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * @author gao yong (gaoyong06[at]qq[dot]com)
 */

public class ThreeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.three, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openFourActivity(View v) {

        Intent intent = new Intent(ThreeActivity.this,FourActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {

        super.onResume();

        //receive intent data
        Intent intent = this.getIntent();
        Uri data = intent.getData();
        String  dataFromItent = data.toString();
        Log.d("customschemeexample", "dataFromItent = " + dataFromItent);
    }
}
