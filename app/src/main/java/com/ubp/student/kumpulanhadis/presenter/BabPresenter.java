package com.ubp.student.kumpulanhadis.presenter;

import com.ubp.student.kumpulanhadis.contract.BabContract;
import com.ubp.student.kumpulanhadis.repository.BabRepository;

/**
 * Created by Dizzay on 6/8/2017.
 */

public class BabPresenter implements BabContract.Presenter {

    private BabContract.View view;
    private BabContract.Repository repository;

    public BabPresenter(BabContract.View view) {
        this.view = view;
        this.repository = new BabRepository();
    }

    @Override
    public void doGetData() {
        view.doShowData(repository.getAllData());
    }
}
