/*
 * Copyright (c) 2015. Vijai Chandra Prasad R.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses
 */

package com.orpheusdroid.myportfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * Meh! Couldn't initialize each button manually
        * Hey! We have reduced 7 lines of code! Haven't we?
        * */
        Button[] buttons = new Button[6];
        /*
        Button Id's in the order(Important!) it has to be initialized
         */
        int[] ids = {R.id.movies,R.id.stock,R.id.builditbigger,R.id.materialapp,R.id.ubiquitious,R.id.capstone};

        for (int i=0;i<buttons.length;i++) {
            buttons[i] = (Button) findViewById(ids[i]);
            buttons[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        /*
        Find each button id and pass the package name along with the app to try to open
         */
        switch (v.getId()){
            case R.id.movies:
                startApp("com.orpheusdroid.popularmovies","Popular Movies");
                break;
            case R.id.stock:
                startApp("com.orpheusdroid.stockhawk", "Stock Hawk");
                break;
            case R.id.builditbigger:
                startApp("com.orpheusdroid.builditbigger", "Build It Bigger");
                break;
            case R.id.materialapp:
                startApp("com.orpheusdroid.materialapp", "Make Your App Material");
                break;
            case R.id.ubiquitious:
                startApp("com.orpheusdroid.goubiquitious", "Go Ubiquitious");
                break;
            case R.id.capstone:
                startApp("com.orpheusdroid.castone", "Capstone");
                break;
        }
    }

    /*
    Method to try opening the app. If app is not found, show a toast
     */
    private void startApp(String packageName, String appName){
        Intent intent = this.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent!=null){
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Awww! \""+appName+"\" is not installed!\nDon't worry it works" +
                    " automatically once installed", Toast.LENGTH_SHORT).show();
        }
    }
}
