package com.ubp.student.kumpulanhadis;

import android.content.Context;

import com.orm.SugarRecord;
import com.ubp.student.kumpulanhadis.clients.ApiUtils;
import com.ubp.student.kumpulanhadis.clients.data.DataService;
import com.ubp.student.kumpulanhadis.clients.model.BabModel;
import com.ubp.student.kumpulanhadis.clients.model.HaditsModel;
import com.ubp.student.kumpulanhadis.clients.model.ImamModel;
import com.ubp.student.kumpulanhadis.clients.model.KitabModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dizzay on 6/9/2017.
 */

public class BulkData {
    
    public void imamData(Context context){
        DataService dataService = ApiUtils.DataService(context);
        dataService.imamData().enqueue(new Callback<ArrayList<ImamModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ImamModel>> call, Response<ArrayList<ImamModel>> response) {
                if(response != null){
                    for (ImamModel imamModel :
                            response.body()) {
                        SugarRecord.save(imamModel);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ImamModel>> call, Throwable t) {

            }
        });
    }

    public void kitabData(Context context) {
        DataService dataService = ApiUtils.DataService(context);
        dataService.kitabData().enqueue(new Callback<ArrayList<KitabModel>>() {
            @Override
            public void onResponse(Call<ArrayList<com.ubp.student.kumpulanhadis.clients.model.KitabModel>> call, Response<ArrayList<com.ubp.student.kumpulanhadis.clients.model.KitabModel>> response) {
                if (response.body() != null) {
                    for (KitabModel kitabModel :
                            response.body()) {
                        SugarRecord.save(kitabModel);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<com.ubp.student.kumpulanhadis.clients.model.KitabModel>> call, Throwable t) {

            }
        });
    }

    public void babData(Context context){
        DataService dataService = ApiUtils.DataService(context);
        dataService.babData().enqueue(new Callback<ArrayList<BabModel>>() {
            @Override
            public void onResponse(Call<ArrayList<BabModel>> call, Response<ArrayList<BabModel>> response) {
                if (response.body() != null){
                    for (BabModel babModel :
                            response.body()) {
                        SugarRecord.save(babModel);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<BabModel>> call, Throwable t) {

            }
        });
    }

    public void haditsData(Context context){
        DataService dataService = ApiUtils.DataService(context);
        dataService.haditsData().enqueue(new Callback<ArrayList<HaditsModel>>() {
            @Override
            public void onResponse(Call<ArrayList<HaditsModel>> call, Response<ArrayList<HaditsModel>> response) {
                if(response.body() != null){
                    for (HaditsModel haditsModel :
                            response.body()) {
                        SugarRecord.save(haditsModel);
                    }

                }
            }

            @Override
            public void onFailure(Call<ArrayList<HaditsModel>> call, Throwable t) {

            }
        });
    }
}
