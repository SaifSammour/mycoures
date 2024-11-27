package com.example.mycouers;

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;
@TypeConverters(Convert.class)
@Entity(foreignKeys = @ForeignKey(entity = Coures.class, parentColumns = {"id"}, childColumns = {"id"}))
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int id_Student;
    private String name_Student;

    public Student() {
    }

    private String department;
    int id;
    public Date dateOfBirth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Ignore
    public Student(int id_Student, String name_Student, String department, int id, Date dateOfBirth, Bitmap photo) {
        this.id_Student = id_Student;
        this.name_Student = name_Student;
        this.department = department;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.photo = photo;
    }

    private Bitmap photo;

    public int getId_Student() {
        return id_Student;
    }

    public void setId_Student(int id_Student) {
        this.id_Student = id_Student;
    }

    public String getName_Student() {
        return name_Student;
    }

    public void setName_Student(String name_Student) {
        this.name_Student = name_Student;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public CharSequence getDateOfBirth() {
        return (CharSequence) dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Bitmap getPhoto() {
        return photo;
    }


    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public Student( String name_Student, String department, Date dateOfBirth, Bitmap photo) {
        this.name_Student = name_Student;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.photo = photo;
    }



}
