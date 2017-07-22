package com.ubp.student.kumpulanhadis.presenter;

import com.ubp.student.kumpulanhadis.contract.ImamContract;
import com.ubp.student.kumpulanhadis.repository.ImamRepository;

/**
 * Created by Dizzay on 6/8/2017.
 */

public class ImamPresenter implements ImamContract.Presenter {

    private ImamContract.View view;
    private ImamContract.Repository repository;

    public ImamPresenter(ImamContract.View view) {
        this.view = view;
        this.repository = new ImamRepository();

    }

    @Override
    public void doGetData() {
        view.doShowData(repository.getAllData());
    }
}
