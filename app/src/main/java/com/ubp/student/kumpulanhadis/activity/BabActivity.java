package com.ubp.student.kumpulanhadis.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
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

        KitabModel kitabModel = (KitabModel) getIntent().getSerializableExtra(Static.KITAB_MODEL);

        if(kitabModel != null){
            setTitle(kitabModel.getNama());
        }

        initPresenter();

    }

    private void initPresenter() {
        presenter = new BabPresenter(this);
        presenter.doGetData();
    }

    @Override
    public void doShowData(ArrayList<BabModel> list) {
        bulkData(list);

        BabAdapter babAdapter = new BabAdapter(getApplicationContext(), list, new BabAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BabModel model) {
                startActivity(new Intent(getApplicationContext(), DeskripsiActivity.class));
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(babAdapter);

    }

    private void bulkData(ArrayList<BabModel> list) {
        BabModel babModel = new BabModel("Permulaan wahyu", " Telah menceritakan kepada kami Al Humaidi Abdullah bin Az Zubair dia berkata, Telah menceritakan kepada kami Sufyan yang berkata, bahwa Telah menceritakan kepada kami Yahya bin Sa'id Al Anshari berkata, telah mengabarkan kepada kami Muhammad bin Ibrahim At Taimi, bahwa dia pernah mendengar Alqamah bin Waqash Al Laitsi berkata; saya pernah mendengar Umar bin Al Khaththab diatas mimbar berkata; saya mendengar Rasulullah shallallahu 'alaihi wasallam bersabda: \"Semua perbuatan tergantung niatnya, dan (balasan) bagi tiap-tiap orang (tergantung) apa yang diniatkan; Barangsiapa niat hijrahnya karena dunia yang ingin digapainya atau karena seorang perempuan yang ingin dinikahinya, maka hijrahnya adalah kepada apa dia diniatkan", " Telah menceritakan kepada kami Al Humaidi Abdullah bin Az Zubair dia berkata, Telah menceritakan kepada kami Sufyan yang berkata, bahwa Telah menceritakan kepada kami Yahya bin Sa'id Al Anshari berkata, telah mengabarkan kepada kami Muhammad bin Ibrahim At Taimi, bahwa dia pernah mendengar Alqamah bin Waqash Al Laitsi berkata; saya pernah mendengar Umar bin Al Khaththab diatas mimbar berkata; saya mendengar Rasulullah shallallahu 'alaihi wasallam bersabda: \"Semua perbuatan tergantung niatnya, dan (balasan) bagi tiap-tiap orang (tergantung) apa yang diniatkan; Barangsiapa niat hijrahnya karena dunia yang ingin digapainya atau karena seorang perempuan yang ingin dinikahinya, maka hijrahnya adalah kepada apa dia diniatkan", "1");
        list.add(babModel);

        babModel = new BabModel("Islam dibangun diatas lima (landasan), dan Islam adalah perkataan dan perbuatan serta bertambah dan berkurang.", "Telah menceritakan kepada kami Abdullah bin Musa dia berkata, telah mengabarkan kepada kami Hanzhalah bin Abu Sufyan dari 'Ikrimah bin Khalid dari Ibnu Umar berkata: Rasulullah shallallahu 'alaihi wasallam bersabda: \"Islam dibangun diatas lima (landasan); persaksian tidak ada ilah selain Allah dan sesungguhnya Muhammad utusan Allah, mendirikan shalat, menunaikan zakat, haji dan puasa Ramadlan\"", "Telah menceritakan kepada kami Abdullah bin Musa dia berkata, telah mengabarkan kepada kami Hanzhalah bin Abu Sufyan dari 'Ikrimah bin Khalid dari Ibnu Umar berkata: Rasulullah shallallahu 'alaihi wasallam bersabda: \"Islam dibangun diatas lima (landasan); persaksian tidak ada ilah selain Allah dan sesungguhnya Muhammad utusan Allah, mendirikan shalat, menunaikan zakat, haji dan puasa Ramadlan\"", "1");
        list.add(babModel);

        babModel = new BabModel("Tentang Perkara-perkara Iman", "Telah menceritakan kepada kami Abdullah bin Muhammad Al Ju'fi dia berkata, Telah menceritakan kepada kami Abu 'Amir Al 'Aqadi yang berkata, bahwa Telah menceritakan kepada kami Sulaiman bin Bilal dari Abdullah bin Dinar dari Abu Shalih dari Abu Hurairah dari Nabi shallallahu 'alaihi wasallam, beliau bersabda: \"Iman memiliki lebih dari enam puluh cabang, dan malu adalah bagian dari iman\". ", "Telah menceritakan kepada kami Abdullah bin Muhammad Al Ju'fi dia berkata, Telah menceritakan kepada kami Abu 'Amir Al 'Aqadi yang berkata, bahwa Telah menceritakan kepada kami Sulaiman bin Bilal dari Abdullah bin Dinar dari Abu Shalih dari Abu Hurairah dari Nabi shallallahu 'alaihi wasallam, beliau bersabda: \"Iman memiliki lebih dari enam puluh cabang, dan malu adalah bagian dari iman\". ", "1");
        list.add(babModel);

        babModel = new BabModel("Seorang muslim adalah orang yang Kaum Muslimin selamat dari lisan dan tangannya", " Telah menceritakan kepada kami Adam bin Abu Iyas berkata, Telah menceritakan kepada kami Syu'bah dari Abdullah bin Abu As Safar dan Isma'il bin Abu Khalid dari Asy Sya'bi dari \n" +
                "Abdullah bin 'Amru dari Nabi shallallahu 'alaihi wasallam, bersabda: \"Seorang muslim adalah orang yang Kaum Muslimin selamat dari lisan dan tangannya, dan seorang Muhajir adalah orang yang meninggalkan apa yang dilarang oleh Allah \" Abu Abdullah berkata; dan Abu Mu'awiyyah berkata; Telah menceritakan kepada kami Daud, dia adalah anak Ibnu Hind, dari 'Amir berkata; aku mendengar Abdullah, maksudnya ibnu 'Amru, dari Nabi shallallahu 'alaihi wasallam Dan berkata Abdul A'laa dari Daud dari 'Amir dari Abdullah dari Nabi shallallahu 'alaihi wasallam", " Telah menceritakan kepada kami Adam bin Abu Iyas berkata, Telah menceritakan kepada kami Syu'bah dari Abdullah bin Abu As Safar dan Isma'il bin Abu Khalid dari Asy Sya'bi dari \n" +
                "Abdullah bin 'Amru dari Nabi shallallahu 'alaihi wasallam, bersabda: \"Seorang muslim adalah orang yang Kaum Muslimin selamat dari lisan dan tangannya, dan seorang Muhajir adalah orang yang meninggalkan apa yang dilarang oleh Allah \" Abu Abdullah berkata; dan Abu Mu'awiyyah berkata; Telah menceritakan kepada kami Daud, dia adalah anak Ibnu Hind, dari 'Amir berkata; aku mendengar Abdullah, maksudnya ibnu 'Amru, dari Nabi shallallahu 'alaihi wasallam Dan berkata Abdul A'laa dari Daud dari 'Amir dari Abdullah dari Nabi shallallahu 'alaihi wasallam ", "1");
        list.add(babModel);

        babModel = new BabModel("Amalan Islam apakah yang paling utama?", " Telah menceritakan kepada kami Sa'id bin Yahya bin Sa'id Al Qurasyi dia berkata, Telah menceritakan kepada kami bapakku berkata, bahwa Telah menceritakan kepada kami Abu Burdah bin Abdullah bin Abu Burdah dari Abu Burdah dari Abu Musa berkata: 'Wahai Rasulullah, Islam manakah yang paling utama?\" Rasulullah shallallahu 'alaihi wasallam menjawab: \"Siapa yang Kaum Muslimin selamat dari lisan dan tangannya\". ", " Telah menceritakan kepada kami Sa'id bin Yahya bin Sa'id Al Qurasyi dia berkata, Telah menceritakan kepada kami bapakku berkata, bahwa Telah menceritakan kepada kami Abu Burdah bin Abdullah bin Abu Burdah dari Abu Burdah dari Abu Musa berkata: 'Wahai Rasulullah, Islam manakah yang paling utama?\" Rasulullah shallallahu 'alaihi wasallam menjawab: \"Siapa yang Kaum Muslimin selamat dari lisan dan tangannya\". ", "1");
        list.add(babModel);
        babModel = new BabModel("Memberi makan bagian dari Islam ", "Telah menceritakan kepada kami 'Amru bin Khalid berkata, Telah menceritakan kepada kami Al Laits dari Yazid dari Abu Al Khair dari Abdullah bin 'Amru; Ada seseorang yang bertanya kepada Nabi shallallahu 'alaihi wasallam; \"Islam manakah yang paling baik?\" Nabi shallallahu 'alaihi wasallam menjawab: \"Kamu memberi makan, mengucapkan salam kepada orang yang kamu kenal dan yang tidak kamu kenal\".", "Telah menceritakan kepada kami 'Amru bin Khalid berkata, Telah menceritakan kepada kami Al Laits dari Yazid dari Abu Al Khair dari Abdullah bin 'Amru; Ada seseorang yang bertanya kepada Nabi shallallahu 'alaihi wasallam; \"Islam manakah yang paling baik?\" Nabi shallallahu 'alaihi wasallam menjawab: \"Kamu memberi makan, mengucapkan salam kepada orang yang kamu kenal dan yang tidak kamu kenal\".", "1");
        list.add(babModel);

        babModel = new BabModel("Bagian dari iman hendaknya mencintai untuk saudaranya sebagaimana dia mencintai untuk dirinya sendiri", " Telah menceritakan kepada kami Musaddad berkata, telah menceritakan kepada kami Yahya dari Syu'bah dari Qotadah dari Anas dari Nabi shallallahu 'alaihi wasallam Dan dari \n" +
                "Husain Al Mu'alim berkata, telah menceritakan kepada kami Qotadah dari Anas dari Nabi shallallahu 'alaihi wasallam, beliau bersabda: \"Tidaklah beriman seseorang dari kalian sehingga dia mencintai untuk saudaranya sebagaimana dia mencintai untuk dirinya sendiri\". ", " Telah menceritakan kepada kami Musaddad berkata, telah menceritakan kepada kami Yahya dari Syu'bah dari Qotadah dari Anas dari Nabi shallallahu 'alaihi wasallam Dan dari \n" +
                "Husain Al Mu'alim berkata, telah menceritakan kepada kami Qotadah dari Anas dari Nabi shallallahu 'alaihi wasallam, beliau bersabda: \"Tidaklah beriman seseorang dari kalian sehingga dia mencintai untuk saudaranya sebagaimana dia mencintai untuk dirinya sendiri\". ", "1");
        list.add(babModel);

        babModel = new BabModel("Mencintai Rasulullah bagian dari iman", " Telah menceritakan kepada kami Abu Al Yaman berkata, telah mengabarkan kepada kami Syu'aib berkata, telah menceritakan kepada kami Abu Az Zanad dari Al A'raj dari Abu Hurairah, bahwa Rasulullah shallallahu 'alaihi wasallam bersabda: \"Maka demi Zat yang jiwaku di tangan-Nya, tidaklah beriman seorang dari kalian hingga aku lebih dicintainya daripada orang tuanya dan anaknya\". ", " Telah menceritakan kepada kami Abu Al Yaman berkata, telah mengabarkan kepada kami Syu'aib berkata, telah menceritakan kepada kami Abu Az Zanad dari Al A'raj dari Abu Hurairah, bahwa Rasulullah shallallahu 'alaihi wasallam bersabda: \"Maka demi Zat yang jiwaku di tangan-Nya, tidaklah beriman seorang dari kalian hingga aku lebih dicintainya daripada orang tuanya dan anaknya\". ", "1");
        list.add(babModel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
