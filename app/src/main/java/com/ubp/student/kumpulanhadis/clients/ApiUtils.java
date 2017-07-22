package com.ubp.student.kumpulanhadis.clients;

import android.content.Context;

import com.ubp.student.kumpulanhadis.clients.data.DataService;
import com.ubp.student.kumpulanhadis.util.Static;

public class ApiUtils {

    public static String API = Static.BASE_URL;

    public static DataService DataService(Context context){
        return RetrofitClient.getClient(context, API).create(DataService.class);
    }

}
