package com.example.mycouers;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyRepository {
    private Student_Dao studentDao;
    private Couers_Dao couersDao;
    private LiveData<List<Coures>> couers;
    MyRepository(Application application) {
        MyDatabase db = MyDatabase.getDatabase(application);
        studentDao = db.studentDao();
        couersDao =db.couersDao();
    }
    void insertCoures (Coures coures){
        MyDatabase.databaseWriteExecutor.execute(()->{
                    couersDao.insertCouers(coures);
                }
        );
    }
    void  deleteCoures (Coures coures){
        MyDatabase.databaseWriteExecutor.execute(()->{
                    couersDao.deleteCoures(coures);
                }
        );
    }
    void updateCoures (Coures coures){
        MyDatabase.databaseWriteExecutor.execute(()->{
                    couersDao.updateCoures(coures);
                }
        );
    }
    LiveData<List<Coures>> getAllCoures(){
        return couersDao.getAllCoures();
    }
    void insertStudent (Student student){
        MyDatabase.databaseWriteExecutor.execute(()->{
                    studentDao.insertStudent(student);
                }
        );
    }
    void deleteStudent (Student student){
        MyDatabase.databaseWriteExecutor.execute(()->{
                    studentDao.deleteStudent(student);
                }
        );
    }
    void updateStudent (Student student){
        MyDatabase.databaseWriteExecutor.execute(()->{
                    studentDao.updateStudent(student);
                }
        );
    }
    LiveData<List<Student>> getAllStudent(){
        return studentDao.getAllStudent();
    }


}
