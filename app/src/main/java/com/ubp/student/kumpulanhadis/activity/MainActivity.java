package com.ubp.student.kumpulanhadis.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ubp.student.kumpulanhadis.R;
import com.ubp.student.kumpulanhadis.adapter.KitabAdapter;
import com.ubp.student.kumpulanhadis.contract.KitabContract;
import com.ubp.student.kumpulanhadis.model.KitabModel;
import com.ubp.student.kumpulanhadis.presenter.KitabPresenter;
import com.ubp.student.kumpulanhadis.util.Static;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, KitabContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private KitabContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = initToolbar();
        initNavigationDrawer(toolbar);
        initPresenter();
    }

    private void initNavigationDrawer(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private Toolbar initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;
    }

    private void initPresenter() {
        presenter = new KitabPresenter(this);
        presenter.doGetData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) MainActivity.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(MainActivity.this.getComponentName()));
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_search) {
//
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void doShowData(ArrayList<KitabModel> list) {

        KitabModel kitabModel = new KitabModel("Kitab Permulaan Wahyu", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Iman", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Ilmu", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Permulaan Wahyu", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Iman", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Ilmu", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Permulaan Wahyu", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Iman", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Ilmu", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Permulaan Wahyu", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Iman", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Ilmu", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Permulaan Wahyu", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Iman", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Ilmu", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Permulaan Wahyu", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Iman", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);
        kitabModel = new KitabModel("Kitab Ilmu", "Telah menceritakan kepada kami Muhammad bin Sinan berkata, telah menceritakan kepada kami Fulaih. Dan telah diriwayatkan pula hadits serupa dari jalan lain, yaitu Telah menceritakan kepadaku Ibrahim bin Al Mundzir berkata...");
        list.add(kitabModel);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        KitabAdapter kitabAdapter = new KitabAdapter(getApplicationContext(), list, new KitabAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(KitabModel model) {
                Intent intent = new Intent(getApplicationContext(), BabActivity.class);
                intent.putExtra(Static.KITAB_MODEL, model);
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(kitabAdapter);

    }
}
