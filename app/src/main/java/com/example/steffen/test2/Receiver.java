package com.example.steffen.test2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import de.greenrobot.event.EventBus;

/**
 * Created by Steffen on 23.07.2015.
 */
public class Receiver extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

    }

    @Override
    public void onResume(){
        super.onResume();

    }

    @Override
    public void onPause(){
        EventBus.getDefault().unregister(this);
        super.onPause();
    }


    public void onEvent(MyEvent myEvent){
        Log.i("EventBus", "Der Bus ist los");
    }

}
