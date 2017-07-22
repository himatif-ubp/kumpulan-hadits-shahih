package com.ubp.student.kumpulanhadis.contract;

import com.ubp.student.kumpulanhadis.clients.model.HaditsModel;
import com.ubp.student.kumpulanhadis.clients.model.ImamModel;
import com.ubp.student.kumpulanhadis.clients.model.KitabModel;

import java.util.ArrayList;

/**
 * Created by Dizzay on 6/8/2017.
 */

public interface ImamContract {

    interface Presenter {
        void doGetData();
    }

    interface View {
        void doShowData(ArrayList<ImamModel> list);
    }

    interface Repository{
        ArrayList<ImamModel> getAllData();
    }
}
