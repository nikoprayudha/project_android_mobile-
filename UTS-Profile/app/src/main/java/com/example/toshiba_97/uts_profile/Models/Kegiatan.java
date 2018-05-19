package com.example.toshiba_97.uts_profile.Models;

import com.orm.SugarRecord;

/**
 * Created by TOSHIBA-97 on 11/7/2017.
 */

public class Kegiatan extends SugarRecord<Kegiatan>{
    public String namakegiatan;
    public String tglkegiatan;
    public String jam;
    public String lokasi;
    public Profile profile;

    public Kegiatan(){

    }
    public Kegiatan(String namakegiatan, String tglkegiatan, String jam, String lokasi, Profile profile) {
        this.namakegiatan = namakegiatan;
        this.tglkegiatan = tglkegiatan;
        this.jam = jam;
        this.lokasi = lokasi;
        this.profile = profile;
    }

    public String getNamakegiatan() {
        return namakegiatan;
    }

    public void setNamakegiatan(String namakegiatan) {
        this.namakegiatan = namakegiatan;
    }

    public String getTglkegiatan() {
        return tglkegiatan;
    }

    public void setTglkegiatan(String tglkegiatan) {
        this.tglkegiatan = tglkegiatan;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
