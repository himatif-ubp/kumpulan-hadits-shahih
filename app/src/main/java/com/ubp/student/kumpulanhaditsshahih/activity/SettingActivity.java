package com.ubp.student.kumpulanhaditsshahih.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.ubp.student.kumpulanhaditsshahih.R;
import com.ubp.student.kumpulanhaditsshahih.util.MyPref;
import com.ubp.student.kumpulanhaditsshahih.util.Static;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.tv_ukuran)
    TextView tvUkuran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int sizeFont = MyPref.getInt(getApplicationContext(), Static.KEY_FONT);
        if(sizeFont == 0){
            tvUkuran.setTextSize(Static.FONT_KECIL);
        }else if(sizeFont == 1){
            tvUkuran.setTextSize(Static.FONT_SEDANG);
        }else if(sizeFont == 2){
            tvUkuran.setTextSize(Static.FONT_BESAR);
        }else if(sizeFont == 3){
            tvUkuran.setTextSize(Static.FONT_SANGAT_BESAR);
        }
        tvUkuran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MaterialDialog materialDialog = new MaterialDialog.Builder(SettingActivity.this)
                        .title("Ukuran Font")
                        .customView(R.layout.dialog_font_size, false).build();
                View view = materialDialog.getView();
                RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rg_fontsize);
                final RadioButton rbKecil = (RadioButton) view.findViewById(R.id.rb_kecil);
                final RadioButton rbSedang = (RadioButton) view.findViewById(R.id.rb_sedang);
                final RadioButton rbBesar = (RadioButton) view.findViewById(R.id.rb_besar);
                final RadioButton rbSangatBesar = (RadioButton) view.findViewById(R.id.rb_sangat_besar);

                int latestFontSize = MyPref.getInt(getApplicationContext(), Static.KEY_FONT);
                if(latestFontSize == 0){
                    rbKecil.setChecked(true);
                }else if(latestFontSize == 1){
                    rbSedang.setChecked(true);
                }else if(latestFontSize == 2){
                    rbBesar.setChecked(true);
                }else if(latestFontSize == 3){
                    rbSangatBesar.setChecked(true);
                }
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                        if(rbKecil.getId() == checkedId){
                            MyPref.putInt(getApplicationContext(), Static.KEY_FONT, 0);
                            tvUkuran.setTextSize(Static.FONT_KECIL);
                        }else if(rbSedang.getId() == checkedId){
                            MyPref.putInt(getApplicationContext(), Static.KEY_FONT, 1);
                            tvUkuran.setTextSize(Static.FONT_SEDANG);
                        }else if(rbBesar.getId() == checkedId){
                            MyPref.putInt(getApplicationContext(), Static.KEY_FONT, 2);
                            tvUkuran.setTextSize(Static.FONT_BESAR);
                        }else if(rbSangatBesar.getId() == checkedId){
                            MyPref.putInt(getApplicationContext(), Static.KEY_FONT, 3);
                            tvUkuran.setTextSize(Static.FONT_SANGAT_BESAR);
                        }
                        materialDialog.dismiss();
                        EventBus.getDefault().post("true");
                    }
                });
                materialDialog.show();
            }
        });
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
