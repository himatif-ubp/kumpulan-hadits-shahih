package com.ubp.student.kumpulanhadis.repository;

import com.ubp.student.kumpulanhadis.contract.BabContract;
import com.ubp.student.kumpulanhadis.model.BabModel;
import com.ubp.student.kumpulanhadis.model.KitabModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dizzay on 6/8/2017.
 */

public class BabRepository implements BabContract.Repository {

    @Override
    public ArrayList<BabModel> getAllData(int hadits, int kitab) {
        List<BabModel> list = BabModel.findWithQuery(BabModel.class, "select * from BAB_MODEL where HADITS_KODE = ? and KITAB_KODE = ?", String.valueOf(hadits), String.valueOf(kitab));
        ArrayList<BabModel> models = new ArrayList<>();
        models.addAll(list);
        return models;
    }
}
