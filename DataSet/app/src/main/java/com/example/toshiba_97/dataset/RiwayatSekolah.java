package com.example.toshiba_97.dataset;


/**
 * Created by TOSHIBA-97 on 9/26/2017.
 */
public class RiwayatSekolah {
    int tahunLulus;
    String namaSekolah;
    String tingkatPendidikan;

    public RiwayatSekolah(int tahunLulus, String namaSekolah, String tingkatPendidikan) {
        this.tahunLulus = tahunLulus;
        this.namaSekolah = namaSekolah;
        this.tingkatPendidikan = tingkatPendidikan;
    }

    public int getTahunLulus() {
        return tahunLulus;
    }

    public void setTahunLulus(int tahunLulus) {
        this.tahunLulus = tahunLulus;
    }

    public String getNamaSekolah() {
        return namaSekolah;
    }

    public void setNamaSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }

    public String getTingkatPendidikan() {
        return tingkatPendidikan;
    }

    public void setTingkatPendidikan(String tingkatPendidikan) {
        this.tingkatPendidikan = tingkatPendidikan;
    }

}

