package com.example.toshiba_97.uts_profile.Models;

import com.orm.SugarRecord;

/**
 * Created by TOSHIBA-97 on 11/6/2017.
 */

public class Pendidikan extends SugarRecord<Pendidikan>{
    public String namapendidikan;
    public String tingkatpendidikan;
    public int tahunlulus;
    public Profile profile;

    public Pendidikan(){

    }
    public Pendidikan(String namapendidikan, String tingkatpendidikan, int tahunlulus, Profile profile) {
        this.namapendidikan = namapendidikan;
        this.tingkatpendidikan = tingkatpendidikan;
        this.tahunlulus = tahunlulus;
        this.profile = profile;
    }

    public String getNamapendidikan() {
        return namapendidikan;
    }

    public void setNamapendidikan(String namapendidikan) {
        this.namapendidikan = namapendidikan;
    }

    public String getTingkatpendidikan() {
        return tingkatpendidikan;
    }

    public void setTingkatpendidikan(String tingkatpendidikan) {
        this.tingkatpendidikan = tingkatpendidikan;
    }

    public int getTahunlulus() {
        return tahunlulus;
    }

    public void setTahunlulus(int tahunlulus) {
        this.tahunlulus = tahunlulus;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
