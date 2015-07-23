package com.example.steffen.test2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://fh-bingen.herokuapp.com/api/")
                .build();

        TaskService service = restAdapter.create(TaskService.class);

        service.createTask((new Task("Titel_Steffen", "Desc_Steffen")), (new Callback<Task>() {
            @Override
            public void success(Task task, Response response) {
                Log.i("Gesendet", "True");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Gesendet", "False");
            }
        }));

 /*       service.deleteTask("Titel_Steffen", new Callback<Task>() {

            @Override
            public void success(Task task, Response response) {
                Log.i("Geloescht", "True");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Geloescht", "False");
            }
        });*/

        service.putTask(new Task("Better Task", "Better Description"), "Titel_Steffen", new Callback<Task>() {

            @Override
            public void success(Task task, Response response) {
                Log.i("Change", "True");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Change", "False");

            }
        });

        service.getTask("gude", new Callback<Task>() {

            @Override
            public void success(Task task, Response response) {
                Log.i("Gefunden", "True");
                Log.i("Ergebnis", task.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Gefunden", "False");
            }
        });

        service.getTasks(new Callback<List<Task>>() {

            @Override
            public void success(List<Task> tasks, Response response) {
                Log.i("Tasker", "Ausgabe beginnt");
                for (Task aktTask : tasks) {
                    Log.i("Task gefunden", aktTask.toString());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("RestTest", "Callback Failure, " + error);
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
}
