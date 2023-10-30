package service;

import vo.Student;

import java.io.IOException;

public interface StudentService {

    void addInstance() ;

    void add(Student student);


    void deleteByprimaryKey(int sno);


    boolean login(String uname, String password) throws IOException;

    void update(int sid);
    void show();

    void FindId(String sname);

    void FindName(int idname);

    void SaveToFile() throws IOException;

    void deleteAll();

    void AVG();

    void schoolAvg();
    void randId();
}
