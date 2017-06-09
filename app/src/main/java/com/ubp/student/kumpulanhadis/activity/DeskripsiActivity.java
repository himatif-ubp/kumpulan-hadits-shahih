package com.ubp.student.kumpulanhadis.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.ubp.student.kumpulanhadis.R;
import com.ubp.student.kumpulanhadis.contract.DeskripsiContract;
import com.ubp.student.kumpulanhadis.model.BabModel;
import com.ubp.student.kumpulanhadis.model.HaditsModel;
import com.ubp.student.kumpulanhadis.presenter.DeskripsiPresenter;
import com.ubp.student.kumpulanhadis.util.Static;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeskripsiActivity extends AppCompatActivity implements DeskripsiContract.View {

    @BindView(R.id.iv_thumbnail)
    ImageView ivThumbnail;
    @BindView(R.id.tv_judul)
    TextView tvJudul;
    @BindView(R.id.tv_isi)
    TextView tvIsi;
    private DeskripsiPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);
        ButterKnife.bind(this);
        setActionBar();
        initPresenter();
        setTitle();

    }

    private void initPresenter() {
        presenter = new DeskripsiPresenter(this);
    }

    private void setTitle() {
        BabModel babModel = (BabModel) getIntent().getSerializableExtra(Static.BAB_MODEL);
        if (babModel != null) {
            setTitle("Bab : " + babModel.getBab());
            tvJudul.setText(babModel.getBab());
            presenter.doGetData(babModel.getHaditsKode(), babModel.getKitabKode(), babModel.getBabKode());
        }
    }

    private void setActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void doShowData(ArrayList<HaditsModel> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for(HaditsModel haditsModel:list){
            stringBuilder.append(haditsModel.getHadits()+"\n");
        }
        tvIsi.setText(stringBuilder.toString());
    }
}
