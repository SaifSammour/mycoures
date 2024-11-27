package com.example.mycouers;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;


@Entity
public class Coures {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String couers_Name;
    private int num_ofStudent;


    public Coures(String coures_Name, int num_ofStudent) {
        this.couers_Name = coures_Name;
        this.num_ofStudent = num_ofStudent;
    }

    public Coures() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCouers_Name() {
        return couers_Name;
    }

    public void setCouers_Name(String couers_Name) {
        this.couers_Name = couers_Name;
    }

    public int getNum_ofStudent() {
        return num_ofStudent;
    }

    public void setNum_ofStudent(int num_ofStudent) {
        this.num_ofStudent = num_ofStudent;
    }
}
