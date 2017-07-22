package com.ubp.student.kumpulanhadis.repository;

import com.ubp.student.kumpulanhadis.clients.model.BabModel;
import com.ubp.student.kumpulanhadis.clients.model.KitabModel;
import com.ubp.student.kumpulanhadis.contract.BabContract;
import com.ubp.student.kumpulanhadis.model.BabModel2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dizzay on 6/8/2017.
 */

public class BabRepository implements BabContract.Repository {

    @Override
    public ArrayList<BabModel> getAllData(int id) {
        List<BabModel> list = BabModel.find(BabModel.class, "id_kitab = ?", new String[]{String.valueOf(id)});
        ArrayList<BabModel> models = new ArrayList<>();
        models.addAll(list);
        return models;
    }

    @Override
    public ArrayList<BabModel> searchByText(String text) {
        List<BabModel> data = KitabModel.findWithQuery(BabModel.class, "select * from BAB_MODEL where nama like '%"+text+"%'");
        ArrayList<BabModel> list = new ArrayList<>();
        list.addAll(data);
        return list;
    }

    @Override
    public ArrayList<BabModel> getAllDataFav() {
        List<BabModel> list = BabModel.findWithQuery(BabModel.class, "select * from BAB_MODEL where IS_FAVORITE = 1");
        ArrayList<BabModel> models = new ArrayList<>();
        models.addAll(list);
        return models;
    }

    @Override
    public ArrayList<BabModel> getAllDataFavSearchByText(String text) {
        List<BabModel> data = KitabModel.findWithQuery(BabModel.class, "select * from BAB_MODEL where nama like '%"+text+"%' and IS_FAVORITE = true");
        ArrayList<BabModel> list = new ArrayList<>();
        list.addAll(data);
        return list;
    }
}
