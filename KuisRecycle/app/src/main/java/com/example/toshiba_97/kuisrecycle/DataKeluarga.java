package com.example.toshiba_97.kuisrecycle;

/**
 * Created by TOSHIBA-97 on 10/15/2017.
 */

public class DataKeluarga {
    int tahunlahir;
    String nama;
    String status;
    String pekerjaan;
    int image;

    public DataKeluarga(int tahunlahir, String nama, String status, String pekerjaan, int image) {
        this.tahunlahir = tahunlahir;
        this.nama = nama;
        this.status = status;
        this.pekerjaan = pekerjaan;
        this.image = image;
    }

    public int getTahunlahir() {
        return tahunlahir;
    }

    public void setTahunlahir(int tahunlahir) {
        this.tahunlahir = tahunlahir;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
