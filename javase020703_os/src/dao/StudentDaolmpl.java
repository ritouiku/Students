package dao;

import org.apache.commons.io.IOUtils;
import vo.Student;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class StudentDaolmpl implements StudentDao {
    Scanner input = new Scanner(in);
    //存储真实数据
    private List<Student> studentList;

    public StudentDaolmpl() {
        this.studentList = new ArrayList<>();
    }

    @Override
    public void addInstance(Student student) {
        //添加学生信息
        studentList.add(student);
        out.println(student);
    }

    @Override
    public void deleteByprimaryKey(int sid) {
        //
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getSno() == sid) {
                //列表的删除操作
                studentList.remove(i);
                out.println("删除成功");
                break;
            }
            out.println("删除失败");
        }
    }

    @Override
    public void update(int sid) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getSno() == sid) {
                out.println("输入更正后的成绩");
                int score1 = input.nextInt();
                studentList.get(i).setScore(score1);
                out.println("修改成功");
            }
            out.println("修改失败");
        }
    }

    public void show() {
        studentList.stream().forEach(System.out::println);
    }

    @Override
    public void FindId(String sname) {
        List<Student> list = studentList.stream().filter(x -> x.getName().contains(sname)).collect(Collectors.toList());
        list.stream().forEach(s-> out.println(s.getSno()));
    }

    @Override
    public void FindName(int idname) {
        List<Student> list=studentList.stream().filter(x->x.getSno()==idname).collect(Collectors.toList());
        list.stream().forEach(x-> out.println(x.getName()));
    }

    @Override
    public void SaveToFile() throws IOException {
        Properties properties=new Properties();
        for(int i=0;i<studentList.size();i++){
            Student student=studentList.get(i);
            properties.setProperty("sno"+i,String.valueOf(student.getSno()));
            properties.setProperty("name"+i,String.valueOf(student.getName()));
            properties.setProperty("school"+i,String.valueOf(student.getSchool()));
            properties.setProperty("major"+i,String.valueOf(student.getMajor()));
            properties.setProperty("idCard"+i,String.valueOf(student.getIdCard()));
            properties.setProperty("birthday"+i,String.valueOf(student.getBirthday()));
            properties.setProperty("gender"+i,String.valueOf(student.getGender()));
            properties.setProperty("nation"+i,String.valueOf(student.getNation()));
            properties.setProperty("score"+i,String.valueOf(student.getScore()));
            properties.setProperty("createTime"+i,String.valueOf(student.getCreateTime()));
            properties.setProperty("updateTime"+i,String.valueOf(student.getUpdateTime()));
        }
        try {
            OutputStream outputStream=new BufferedOutputStream(new FileOutputStream(new File("").getCanonicalPath()+File.separator+"student.properties"));
            properties.store(outputStream,"学生信息");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteAll() {
        studentList.clear();
    }

    @Override
    public void AVG() {
        int sum=0;
        List<Integer> list=studentList.stream().map(x->x.getScore()).collect(Collectors.toList());
        for (int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        Double avg=Double.valueOf (sum/list.size());
        out.println(avg);
    }

    @Override
    public void schoolAvg() {
       Map<String,List<Student>> map=studentList.stream().collect(Collectors.groupingBy(Student::getSchool));
       map.entrySet().stream().forEach(entry->{
           DoubleSummaryStatistics doubleSummaryStatistics=entry.getValue().stream().collect(Collectors.summarizingDouble(Student::getScore));
           out.println(entry.getKey()+"的平均分为"+doubleSummaryStatistics.getAverage());
       });
    }

    public void genderAvg(){
        Map<String,List<Student>> listMap=studentList.stream().collect(Collectors.groupingBy(Student::getGender));
        listMap.entrySet().stream().forEach(x-> {
            DoubleSummaryStatistics summaryStatistics=x.getValue().stream().collect(Collectors.summarizingDouble(Student::getScore));
            out.println(x.getKey()+"的平均分为"+summaryStatistics.getAverage());
        });
    };

    public void randId(){
        List<Student> list= studentList.stream().sorted(Comparator.comparing(Student::getScore).thenComparing(Comparator.comparing(Student::getSno))).collect(Collectors.toList());
        out.println(list);
    }
}