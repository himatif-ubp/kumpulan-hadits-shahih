package com.ubp.student.kumpulanhadis.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ubp.student.kumpulanhadis.R;
import com.ubp.student.kumpulanhadis.adapter.BabAdapter;
import com.ubp.student.kumpulanhadis.contract.BabContract;
import com.ubp.student.kumpulanhadis.model.BabModel;
import com.ubp.student.kumpulanhadis.model.KitabModel;
import com.ubp.student.kumpulanhadis.presenter.BabPresenter;
import com.ubp.student.kumpulanhadis.util.Static;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BabActivity extends AppCompatActivity implements BabContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private BabPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initPresenter();
        settitle();
    }

    private void settitle() {
        KitabModel kitabModel = (KitabModel) getIntent().getSerializableExtra(Static.KITAB_MODEL);
        if(kitabModel != null){
            setTitle("Kitab : " +kitabModel.getKitab());
            presenter.doGetData(kitabModel.getHaditsKode(), kitabModel.getKitabKode());
        }
    }

    private void initPresenter() {
        presenter = new BabPresenter(this);
    }

    @Override
    public void doShowData(ArrayList<BabModel> list) {
        BabAdapter babAdapter = new BabAdapter(getApplicationContext(), list, new BabAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BabModel model) {
                Intent intent = new Intent(getApplicationContext(), DeskripsiActivity.class);
                intent.putExtra(Static.BAB_MODEL, model);
                startActivity(intent);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(babAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) BabActivity.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(BabActivity.this.getComponentName()));
        }
        return super.onCreateOptionsMenu(menu);
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
}
