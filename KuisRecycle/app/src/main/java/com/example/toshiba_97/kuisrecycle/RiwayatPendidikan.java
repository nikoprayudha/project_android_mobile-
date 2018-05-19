package com.example.toshiba_97.kuisrecycle;

/**
 * Created by TOSHIBA-97 on 10/15/2017.
 */

public class RiwayatPendidikan {
    int tahun;
    String namaSekolah;
    String alamat;

    public RiwayatPendidikan(int tahun, String namaSekolah, String alamat) {
        this.tahun = tahun;
        this.namaSekolah = namaSekolah;
        this.alamat = alamat;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getNamaSekolah() {
        return namaSekolah;
    }

    public void setNamaSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}

