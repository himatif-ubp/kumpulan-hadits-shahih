package com.ubp.student.kumpulanhadis.contract;

import com.ubp.student.kumpulanhadis.model.HaditsModel;

import java.util.ArrayList;

/**
 * Created by Dizzay on 6/8/2017.
 */

public interface DeskripsiContract {

    interface Presenter {
        void doGetData(int hadits, int kitab, int bab);
    }

    interface View {
        void doShowData(ArrayList<HaditsModel> list);
    }

    interface Repository{
        ArrayList<HaditsModel> getAllData(int hadits, int kitab, int bab);
    }
}
