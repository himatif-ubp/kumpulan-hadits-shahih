package com.ubp.student.kumpulanhadis.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.ubp.student.kumpulanhadis.R;
import com.ubp.student.kumpulanhadis.adapter.BabAdapter;
import com.ubp.student.kumpulanhadis.adapter.PemberitahuanAdapter;
import com.ubp.student.kumpulanhadis.clients.model.BabModel;
import com.ubp.student.kumpulanhadis.clients.model.NotifModel;
import com.ubp.student.kumpulanhadis.contract.BabContract;
import com.ubp.student.kumpulanhadis.presenter.BabPresenter;
import com.ubp.student.kumpulanhadis.util.Static;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PemberitahuanActivity extends AppCompatActivity implements BabContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private BabPresenter presenter;
    long id;
    PemberitahuanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemberitahuan);
        ButterKnife.bind(this);
        setTitle("Pemberitahuan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initPresenter();
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

    private void initPresenter() {
        presenter = new BabPresenter(this);
//        setToAdapter(presenter.getAllDataFav(), null);
        ArrayList<NotifModel> notifModels = new ArrayList<>();
        NotifModel notifModel = new NotifModel();
        notifModel.setId(Long.valueOf(1));
        notifModel.setNama("Notif 1");
        notifModel.setFavorite(false);
        notifModel.setIdKitab(2);
        notifModels.add(notifModel);

        notifModel = new NotifModel();
        notifModel.setId(Long.valueOf(2));
        notifModel.setNama("Notif 2");
        notifModel.setFavorite(false);
        notifModel.setIdKitab(2);
        notifModels.add(notifModel);

        notifModel = new NotifModel();
        notifModel.setId(Long.valueOf(3));
        notifModel.setNama("Notif 3");
        notifModel.setFavorite(false);
        notifModel.setIdKitab(2);
        notifModels.add(notifModel);

        notifModel = new NotifModel();
        notifModel.setId(Long.valueOf(4));
        notifModel.setNama("Notif 4");
        notifModel.setFavorite(false);
        notifModel.setIdKitab(2);
        notifModels.add(notifModel);

        notifModel = new NotifModel();
        notifModel.setId(Long.valueOf(5));
        notifModel.setNama("Notif 5");
        notifModel.setFavorite(false);
        notifModel.setIdKitab(2);
        notifModels.add(notifModel);

        setToAdapter(notifModels, null);

    }

    private void setToAdapter(ArrayList<NotifModel> list, String spanndable) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        adapter = new PemberitahuanAdapter(getApplicationContext(), list, new BabAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(NotifModel model) {
//                Intent intent = new Intent(getApplicationContext(), HaditsActivity.class);
//                intent.putExtra(Static.BAB_ID, model.getId());
//                startActivity(intent);
//            }
//        }, new BabAdapter.OnItemFavClickListener() {
//            @Override
//            public void onItemClick(NotifModel model) {
//                if (model.isFavorite()) {
//                    Toast.makeText(getApplicationContext(), Static.REMOVE_FAVOURITE, Toast.LENGTH_SHORT).show();
//                    NotifModel NotifModel = NotifModel.findById(NotifModel.class, model.getId());
//                    NotifModel.setFavorite(false);
//                    NotifModel.save();
//                    model.setFavorite(false);
//                } else {
//                    Toast.makeText(getApplicationContext(), Static.ADD_FAVOURITE, Toast.LENGTH_SHORT).show();
//                    NotifModel NotifModel = NotifModel.findById(NotifModel.class, model.getId());
//                    NotifModel.setFavorite(true);
//                    NotifModel.save();
//                    model.setFavorite(true);
//                }
//                adapter.notifyDataSetChanged();
//            }
//        }, spanndable);
        adapter = new PemberitahuanAdapter(getApplicationContext(), list, new PemberitahuanAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(NotifModel model) {

            }
        }, new PemberitahuanAdapter.OnItemFavClickListener() {
            @Override
            public void onItemClick(NotifModel model) {

            }
        }, spanndable);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void doShowData(ArrayList<BabModel> list) {

    }
}
