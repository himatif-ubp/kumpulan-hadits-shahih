package com.ubp.student.kumpulanhadis.model;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Dizzay on 6/8/2017.
 */

public class BabModel extends SugarRecord<BabModel> implements Serializable {

    int haditsKode;
    int kitabKode;
    int babKode;
    String bab;

    public BabModel() {
    }

    public BabModel(int haditsKode, int kitabKode, int babKode, String bab) {
        this.haditsKode = haditsKode;
        this.kitabKode = kitabKode;
        this.babKode = babKode;
        this.bab = bab;
    }

    public int getHaditsKode() {
        return haditsKode;
    }

    public void setHaditsKode(int haditsKode) {
        this.haditsKode = haditsKode;
    }

    public int getKitabKode() {
        return kitabKode;
    }

    public void setKitabKode(int kitabKode) {
        this.kitabKode = kitabKode;
    }

    public int getBabKode() {
        return babKode;
    }

    public void setBabKode(int babKode) {
        this.babKode = babKode;
    }

    public String getBab() {
        return bab;
    }

    public void setBab(String bab) {
        this.bab = bab;
    }
}