package com.example.mycouers;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel  extends AndroidViewModel {
   private MyRepository myRepository;
    public MyViewModel(@NonNull Application application) {
        super(application);
        myRepository=new MyRepository(application);
    }
    void insertCoures (Coures coures){
        myRepository.insertCoures(coures);
    }
    void deleteCoures (Coures coures){
        myRepository.deleteCoures(coures);
    }
    void updateCoures (Coures coures){
        myRepository.updateCoures(coures);
    }
    void insertStudent (Student student){
        myRepository.insertStudent(student);
    }
    void updateStudent (Student student){
        myRepository.updateStudent(student);
    }
    void deleteStudent (Student student){
        myRepository.deleteStudent(student);
    }
    LiveData<List<Student>> getAllStudent(){
        return myRepository.getAllStudent();
    }
    LiveData<List<Coures>> getAllCoures(){
        return myRepository.getAllCoures();
    }
}
