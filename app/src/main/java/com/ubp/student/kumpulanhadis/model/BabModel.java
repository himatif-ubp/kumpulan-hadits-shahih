package com.ubp.student.kumpulanhadis.model;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Dizzay on 6/8/2017.
 */

public class BabModel extends SugarRecord<BabModel> implements Serializable{

    String nama;
    String deskripsi;
    String isi;
    String type;

    public BabModel() {
    }

    public BabModel(String nama, String deskripsi, String isi, String type) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.isi = isi;
        this.type = type;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
