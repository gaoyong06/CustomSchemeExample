package com.example.gaoyong.customschemeexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


/**
 * @author gao yong (gaoyong06[at]qq[dot]com)
 */

public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first, menu);
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

    public void openSecondActivity(View v) {

        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    /**
     * 处理自定义的scheme
     * @param v
     */
    public void openWithSchemeCustom(View v) {

        //处理自定义的scheme
        //在path中体现“action”,当打开native中众多界面时，通过action区分
        Intent intent = new Intent();
        Uri uri = Uri.parse("gaoyong://FourActivity/file/name/a=1&b=2");
        intent.setAction("FourActivity");

        //TUDO:
        //处理其他的action
//        intent.setAction("SecondActivity");

        intent.addCategory("com.example.gaoyong.customschemeexample.category.OPEN");
        intent.setData(uri);
        startActivity(intent);
    }

    /**
     * 处理http scheme
     * @param v
     */
    public void openWithSchemeHttp(View v) {

        //receive intent data
        Uri uri = Uri.parse("http://www.baidu.com");
        Intent intent = new Intent();
        intent.addCategory("com.example.gaoyong.customschemeexample.category.OPEN");
        intent.setData(uri);
        startActivity(intent);
    }
}
