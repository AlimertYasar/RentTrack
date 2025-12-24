package com.example.renttrack.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "araclar")
public class Arac {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "marka")
    private String marka;

    @ColumnInfo(name = "model")
    private String model;

    @ColumnInfo(name = "plaka")
    private String plaka;

    @ColumnInfo(name = "durum")
    private boolean durum;  // durum boolean olarak değiştirildi

    @ColumnInfo(name = "kiraci")
    private String kiraci;

    @ColumnInfo(name = "sure")
    private String sure;

    @ColumnInfo(name = "gecenSure")
    private String gecenSure;

    // Varsayılan constructor, Room'un çalışması için gerekli
    public Arac() {}


    @Ignore
    public Arac(int id, String marka, String model, String plaka, boolean durum, String kiraci, String sure, String gecenSure) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.plaka = plaka;
        this.durum = durum;
        this.kiraci = kiraci;
        this.sure = sure;
        this.gecenSure = gecenSure;
    }
    @Ignore
    public Arac(String marka, String model, String plaka) {
        this.marka = marka;
        this.model = model;
        this.plaka = plaka;
        this.durum = false; // varsayılan boşta
        this.kiraci = "";
        this.sure = "";
        this.gecenSure = "";
    }


    // Getter ve setter metodları

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public boolean isDurum() {
        return durum;
    }

    public void setDurum(boolean durum) {
        this.durum = durum;
    }

    public String getKiraci() {
        return kiraci;
    }

    public void setKiraci(String kiraci) {
        this.kiraci = kiraci;
    }

    public String getSure() {
        return sure;
    }

    public void setSure(String sure) {
        this.sure = sure;
    }

    public String getGecenSure() {
        return gecenSure;
    }

    public void setGecenSure(String gecenSure) {
        this.gecenSure = gecenSure;
    }
}
