package com.ubp.student.kumpulanhadis.repository;

import com.ubp.student.kumpulanhadis.contract.KitabContract;
import com.ubp.student.kumpulanhadis.model.KitabModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dizzay on 6/8/2017.
 */

public class KitabRepository implements KitabContract.Repository {

    @Override
    public ArrayList<KitabModel> getAllData() {

        return new ArrayList<>();
    }

}
