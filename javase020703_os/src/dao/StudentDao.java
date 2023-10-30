package dao;

import vo.Student;

import java.io.IOException;

public interface StudentDao {
    //
    void addInstance(Student student);
    void deleteByprimaryKey(int sid);

    void update(int sid);
    void show();

    void FindId(String sname);

    void FindName(int idname);

    void SaveToFile() throws IOException;

    void DeleteAll();

    void AVG();

    void schoolAvg();

    void randId();
}
