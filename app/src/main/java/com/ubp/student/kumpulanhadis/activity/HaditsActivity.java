package com.ubp.student.kumpulanhadis.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ubp.student.kumpulanhadis.R;
import com.ubp.student.kumpulanhadis.clients.model.BabModel;
import com.ubp.student.kumpulanhadis.clients.model.HaditsModel;
import com.ubp.student.kumpulanhadis.clients.model.ImamModel;
import com.ubp.student.kumpulanhadis.clients.model.KitabModel;
import com.ubp.student.kumpulanhadis.contract.HaditsContract;
import com.ubp.student.kumpulanhadis.presenter.HaditsPresenter;
import com.ubp.student.kumpulanhadis.util.Static;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HaditsActivity extends AppCompatActivity implements HaditsContract.View {

    @BindView(R.id.iv_fav)
    ImageView ivFav;
    @BindView(R.id.tv_bagikan)
    TextView tvBagikan;
    @BindView(R.id.tv_salin)
    TextView tvSalin;
    BabModel babModel;
    long id;
    @BindView(R.id.tv_bab)
    TextView tvBab;
    @BindView(R.id.tv_imam)
    TextView tvImam;
    @BindView(R.id.tv_kitab)
    TextView tvKitab;
    @BindView(R.id.tv_isi)
    TextView tvIsi;
    private HaditsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadits);
        ButterKnife.bind(this);
        setTitle();
        backpresButton();
        getIDData();
        initFavorite();
        initPresenter();
        initOnClick();
        initTextData();
    }

    private void initTextData() {
        KitabModel kitabModel = KitabModel.findById(KitabModel.class, babModel.getIdKitab());
        ImamModel imamModel = ImamModel.findById(ImamModel.class, kitabModel.getIdImam());
        tvBab.setText(babModel.getNama());
        tvKitab.setText(kitabModel.getNama());
        tvImam.setText(imamModel.getNamaImam());
    }

    private void getIDData() {
        id = getIntent().getLongExtra(Static.BAB_ID, 0);
        babModel = BabModel.findById(BabModel.class, id);
    }

    private void initFavorite() {
        if (babModel.isFavorite()) {
            Glide.with(getApplicationContext()).load(R.drawable.ic_action_fav_true).into(ivFav);
        } else {
            Glide.with(getApplicationContext()).load(R.drawable.ic_action_fav_false).into(ivFav);
        }
    }

    private void initPresenter() {
        presenter = new HaditsPresenter(this);
        presenter.doGetData((int) id);
    }

    private void initOnClick() {
        ivFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (babModel.isFavorite()) {
                    Toast.makeText(getApplicationContext(), Static.REMOVE_FAVOURITE, Toast.LENGTH_SHORT).show();
                    babModel.setFavorite(false);
                    Glide.with(getApplicationContext()).load(R.drawable.ic_action_fav_false).into(ivFav);
                } else {
                    Toast.makeText(getApplicationContext(), Static.ADD_FAVOURITE, Toast.LENGTH_SHORT).show();
                    babModel.setFavorite(true);
                    Glide.with(getApplicationContext()).load(R.drawable.ic_action_fav_true).into(ivFav);
                }
                babModel.save();
            }
        });

        tvSalin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KitabModel kitabModel = KitabModel.findById(KitabModel.class, babModel.getIdKitab());
                ImamModel imamModel = ImamModel.findById(ImamModel.class, kitabModel.getIdImam());
                String textShared = "HR. "+imamModel.getNamaImam()+"\nKitab "+kitabModel.getNama()+"\nBAB : "+babModel.getNama()+"\n\n"+tvIsi.getText().toString()+"Aplikasi Kumpulan Hadits-Hadits Shahih oleh Universitas Buana Perjuangan Karawang";
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText(babModel.getNama(), textShared);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "Berhasil di salin", Toast.LENGTH_SHORT).show();
            }
        });

        tvBagikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KitabModel kitabModel = KitabModel.findById(KitabModel.class, babModel.getIdKitab());
                ImamModel imamModel = ImamModel.findById(ImamModel.class, kitabModel.getIdImam());
                String textShared = "HR. "+imamModel.getNamaImam()+"\nKitab "+kitabModel.getNama()+"\nBAB : "+babModel.getNama()+"\n"+tvIsi.getText().toString()+"Aplikasi Kumpulan Hadits-Hadits Shahih oleh Universitas Buana Perjuangan Karawang";
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, textShared);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }

    private void backpresButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setTitle() {
        setTitle("Isi Hadits");
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
        for (HaditsModel haditsModel :
                list) {
            stringBuilder.append(haditsModel.getIsi() + "<br><br>");
        }
        tvIsi.setText(Html.fromHtml(stringBuilder.toString()));
    }
}
