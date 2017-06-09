package com.ubp.student.kumpulanhadis.repository;

import com.ubp.student.kumpulanhadis.contract.BabContract;
import com.ubp.student.kumpulanhadis.contract.DeskripsiContract;
import com.ubp.student.kumpulanhadis.model.BabModel;
import com.ubp.student.kumpulanhadis.model.HaditsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dizzay on 6/8/2017.
 */

public class DeskripsiRepository implements DeskripsiContract.Repository {
    @Override
    public ArrayList<HaditsModel> getAllData(int hadits, int kitab, int bab) {
        List<HaditsModel> list = HaditsModel.findWithQuery(HaditsModel.class, "select * from HADITS_MODEL where HADITS_KODE = ? and KITAB_KODE = ? and BAB_KODE = ?", String.valueOf(hadits), String.valueOf(kitab), String.valueOf(bab));
        ArrayList<HaditsModel> models = new ArrayList<>();
        models.addAll(list);
        return models;
    }
}
