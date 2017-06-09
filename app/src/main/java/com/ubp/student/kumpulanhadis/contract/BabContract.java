package com.ubp.student.kumpulanhadis.contract;

import com.ubp.student.kumpulanhadis.model.BabModel;
import com.ubp.student.kumpulanhadis.model.KitabModel;

import java.util.ArrayList;

/**
 * Created by Dizzay on 6/8/2017.
 */

public interface BabContract {

    interface Presenter {
        void doGetData(int hadits, int kitab);
    }

    interface View {
        void doShowData(ArrayList<BabModel> list);
    }

    interface Repository{
        ArrayList<BabModel> getAllData(int hadits, int kitab);
    }
}
