package com.example.mycouers;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface Couers_Dao {
    @Insert
    void insertCouers (Coures coures);
    @Update
    void updateCoures(Coures coures);
    @Delete
    void  deleteCoures(Coures coures);
    @Query("Select * From Coures")
    LiveData<List<Coures>> getAllCoures();
    @Query("SELECT * From Coures WHERE id = :Courseid ")
    LiveData<List<Coures>> getAllCouresById(int Courseid );
}
