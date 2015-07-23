package com.example.steffen.test2;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by Steffen on 23.07.2015.
 */
public interface TaskService {

    @GET("/task")
    void getTasks(Callback<List<Task>> callback);

    @GET("/task/{title}")
    void getTask(@Path("title") String taskTitle, Callback<Task> callback);

    @POST("/task")
    void createTask(@Body Task task, Callback<Task> cb);

    @DELETE("/task/{title}")
    void deleteTask(@Path("title") String taskTitle, Callback<Task> callback);

    @PUT("/task/{title}")
    void putTask(@Body Task task, @Path("title") String taskTitle, Callback<Task> callback);
}
