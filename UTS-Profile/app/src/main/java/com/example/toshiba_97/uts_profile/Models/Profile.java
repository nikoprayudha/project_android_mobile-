package com.example.toshiba_97.uts_profile.Models;

import com.orm.SugarRecord;

/**
 * Created by TOSHIBA-97 on 11/4/2017.
 */

public class Profile extends SugarRecord<Profile> {
    public String nama;
    public String tgllahir;
    public String jk;
    public String alamat;

    public Profile(){

    }

    public Profile(String nama, String tgllahir, String jk,  String alamat) {
        this.nama = nama;
        this.tgllahir = tgllahir;
        this.jk = jk;
        this.alamat = alamat;

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(String tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}


