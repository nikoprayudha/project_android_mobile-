package com.putraprima.ppmsqliteexamplefirst.models;

import com.orm.SugarRecord;

/**
 * Created by TOSHIBA-97 on 10/24/2017.
 */

public class Penulis extends SugarRecord<Penulis> {
    public String nama;
    public String jk;
    public String umur;

    public Penulis(){

    }

    public Penulis(String nama, String jk, String umur) {
        this.nama=nama;
        this.jk=jk;
        this.umur=umur;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama=nama;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk=jk;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur=umur;
    }
}
