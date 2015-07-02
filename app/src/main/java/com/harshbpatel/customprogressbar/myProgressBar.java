package com.harshbpatel.customprogressbar;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class myProgressBar extends Activity{

    TextView tv;
    ProgressBar pBar;
    int pStatus = 0;
    Button button;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);


        Button button = (Button) findViewById(R.id.btnShow);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        SSEnergyFragment ssEnergyFragment = new SSEnergyFragment();
                        ssEnergyFragment.setStepCount(55000);
                        fragmentTransaction.replace(R.id.fragment_SSEnergy, ssEnergyFragment);
                        fragmentTransaction.commit();

                        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                        GoalFragment goalFragment = new GoalFragment();
                        fragmentTransaction1.replace(R.id.fragment_goal,goalFragment);
                        fragmentTransaction1.commit();

                        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                        LevelFragment levelFragment = new LevelFragment();
                        fragmentTransaction2.replace(R.id.fragment_level,levelFragment);
                        fragmentTransaction2.commit();

                        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
                        RankFragment rankFragment = new RankFragment();
                        fragmentTransaction3.replace(R.id.fragment_rank,rankFragment);
                        fragmentTransaction3.commit();
                    }
                }

        );

        Button button1 = (Button) findViewById(R.id.btnStep);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(myProgressBar.this,myCircleBar.class);
                startActivity(myIntent);

            }
        });


//        tv = (TextView) findViewById(R.id.textView1);
////        pBar = (myProgressBar) findViewById(R.id.progressBar1);
//
//        pBar = (ProgressBar) findViewById(R.id.progressBar1);
//
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                while (pStatus <= 55) {
//
//                    handler.post(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            // TODO Auto-generated method stub
//                            pBar.setProgress(pStatus);
//                            tv.setText(pStatus + "/" + pBar.getMax());
//                        }
//                    });
//                    try {
//                        // Sleep for 200 milliseconds.
//                        // Just to display the progress slowly
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    pStatus ++;
//                }
//            }
//        }).start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_progress_bar, menu);
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
}


