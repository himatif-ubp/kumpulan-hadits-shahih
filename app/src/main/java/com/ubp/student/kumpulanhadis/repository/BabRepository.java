package com.ubp.student.kumpulanhadis.repository;

import com.ubp.student.kumpulanhadis.contract.BabContract;
import com.ubp.student.kumpulanhadis.model.BabModel;

import java.util.ArrayList;

/**
 * Created by Dizzay on 6/8/2017.
 */

public class BabRepository implements BabContract.Repository {
    @Override
    public ArrayList<BabModel> getAllData() {
        return new ArrayList<>();
    }
}
