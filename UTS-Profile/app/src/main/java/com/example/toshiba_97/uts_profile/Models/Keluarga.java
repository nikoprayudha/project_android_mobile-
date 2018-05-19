package com.example.toshiba_97.uts_profile.Models;

import com.orm.SugarRecord;

/**
 * Created by TOSHIBA-97 on 11/6/2017.
 */

public class Keluarga extends SugarRecord<Pendidikan> {
    public String namakeluarga;
    public String status;
    public String tingkatpendidikan;
    public int tahunlahir;
    public int umur;
    public Profile profile;

    public Keluarga() {

    }

    public Keluarga(String namakeluarga, String status, String tingkatpendidikan, int tahunlahir, int umur, Profile profile) {
        this.namakeluarga = namakeluarga;
        this.status = status;
        this.tingkatpendidikan = tingkatpendidikan;
        this.tahunlahir = tahunlahir;
        this.umur = umur;
        this.profile = profile;
    }

    public String getNamakeluarga() {
        return namakeluarga;
    }

    public void setNamakeluarga(String namakeluarga) {
        this.namakeluarga = namakeluarga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTingkatpendidikan() {
        return tingkatpendidikan;
    }

    public void setTingkatpendidikan(String tingkatpendidikan) {
        this.tingkatpendidikan = tingkatpendidikan;
    }

    public int getTahunlahir() {
        return tahunlahir;
    }

    public void setTahunlahir(int tahunlahir) {
        this.tahunlahir = tahunlahir;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
