package com.example.devinternationalcollege.BCACourse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DeleteApiInterface {
    @FormUrlEncoded
    @POST("students_delete_data.php")
    Call<String> deleteUser(@Field("FIRST-NAME") String name);
}
