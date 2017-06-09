package com.ubp.student.kumpulanhadis.presenter;

import com.ubp.student.kumpulanhadis.contract.BabContract;
import com.ubp.student.kumpulanhadis.contract.DeskripsiContract;
import com.ubp.student.kumpulanhadis.repository.BabRepository;
import com.ubp.student.kumpulanhadis.repository.DeskripsiRepository;

/**
 * Created by Dizzay on 6/8/2017.
 */

public class DeskripsiPresenter implements DeskripsiContract.Presenter {

    private DeskripsiContract.View view;
    private DeskripsiContract.Repository repository;

    public DeskripsiPresenter(DeskripsiContract.View view) {
        this.view = view;
        this.repository = new DeskripsiRepository();
    }

    @Override
    public void doGetData(int hadits, int kitab, int bab) {
        view.doShowData(repository.getAllData(hadits, kitab, bab));
    }
}
