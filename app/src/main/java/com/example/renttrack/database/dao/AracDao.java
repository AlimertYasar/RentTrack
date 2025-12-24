package com.example.renttrack.database.dao;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;


import com.example.renttrack.database.entity.Arac;

import java.util.List;

@Dao
public interface AracDao {
    @Insert
    void insert(Arac arac);

    @Update
    void update(Arac arac);

    @Delete
    void delete(Arac arac);

    @Query("SELECT * FROM araclar")
    LiveData<List<Arac>> getAllCars(); // Make sure it returns LiveData
}
