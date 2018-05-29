package com.example.user.crudmahasiswa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MahasiswaResult {
    @SerializedName("pesan")
    @Expose
    private String pesan;
    @SerializedName("mahasiswas")
    @Expose
    private List<Mahasiswa> mahasiswas = null;

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }

    public void setMahasiswas(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }
}
