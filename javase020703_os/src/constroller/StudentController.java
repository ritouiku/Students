package constroller;

import service.StudentService;
import service.StudentServicelmpl;
import vo.Student;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class StudentController {
    private static StudentController studentController=new StudentController();
    //声明Scanner
    private static Scanner input=new Scanner(System.in);
    //操作业务层
    private StudentService studentService= new StudentServicelmpl();

    //定义一个变量是否退出系统
    private  static boolean EXIT_FLAG=false;

    public static void main(String[] args) throws IOException {
        studentController.welcomePage();
    }

    private static void welcomePage() throws IOException {
        System.out.println("1.登陆系统");
        System.out.println("11.添加学生信息");
        System.out.println("12.删除学生信息");
        System.out.println("13.修改学生成绩信息");
        System.out.println("14.显示所有学生信息");
        System.out.println("21.查询学生信息-学号");
        System.out.println("22.查询学生信息-姓名");
        System.out.println("23.查询学生信息-每次只显示十条");
        System.out.println("31.将所有学生信息存放到文件");
        System.out.println("32.将所有学生信息从文件中读回");
        System.out.println("33.将所有学生信息清空");
        System.out.println("41.计算所有学生的最高分和最低分平均分");
        System.out.println("42.分别计算每个学校的最高分最低分平均分");
        System.out.println("43.排序-按照学生分数学号排序");
        System.out.println("51.按照学生学校专业学号排序");
        System.out.println("52.按照性别分数学号排序");
        System.out.println("52.按照性别分数学号排序");
        System.out.println("99.随机生成一千条模拟数据");
        System.out.println("0.退出系统");
        System.out.println("----------输入要执行菜单的编号----------");

        int menu=input.nextInt();
        switch (menu){
            case 1:
                studentController.login();
                break;
            case 11:
                studentController.addInstance();
                break;
            case 12:
                studentController.deleteByprimaryKey();
                break;
            case 13:
                studentController.update();
                break;
            case 14:
                studentController.show();
                break;
            case 21:
                studentController.FindId();
                break;
            case 22:
                studentController.FindName();
                break;
            case 31:
                studentController.SaveToFile();
                break;
            case 33:
                studentController.DeleteAll();
                break;
            case 41:
                studentController.AVG();
                break;
            case 42:
                studentController.SchoolAVG();
                break;
            case 43:
                studentController.randId();
                break;
            case 99:
                studentController.gen();
                break;
            case 0:
                studentController.exitOs();
                break;
        }
        //重复调用自己直到退出
        if(studentController.EXIT_FLAG!=true){
            welcomePage();
        }else {
            System.out.println("退出成功");
        }
    }

    private void gen() {
        for(int i=0;i<1000;i++){
            addInstance();
            i++;
        }
    }

    private void randId() {
        this.studentService.randId();
    }

    private void SchoolAVG() {
        this.studentService.schoolAvg();
    }

    private void AVG() {
        this.studentService.AVG();
    }

    private void DeleteAll() {
        this.studentService.deleteAll();
    }

    private void SaveToFile() throws IOException {
        this.studentService.SaveToFile();
    }

    private void FindName() {
        System.out.println("请输入同学的学号");
        int idname=input.nextInt();
        this.studentService.FindName(idname);
    }

    private void FindId() {
        System.out.println("请输入学生的名字");
        String sname=input.next();
        this.studentService.FindId(sname);
    }

    private void show() {
        this.studentService.show();
    }

    private void deleteByprimaryKey() {
        System.out.println("删除学生信息");
        System.out.println("请输入要删除的学生学号");
        int sid=input.nextInt();
        this.studentService.deleteByprimaryKey(sid);
    }

    private void login() throws IOException {
        System.out.println("1.登陆系统");
        System.out.println("请输入你的用户名和密码，用-分隔");
        String unamePassword=input.next();
        String Uname=unamePassword.split("-")[0];
        String Password=unamePassword.split("-")[1];
        //进入到业务层
        boolean flag=this.studentService.login(Uname,Password);
        if (flag==true){
            System.out.println(Uname+"登陆成功");
        } else {
            System.out.println("您输入的密码错误");
        }
    }
    //添加学生信息
    private void addInstance(){
        System.out.println("11.添加学生信息");
        studentService.addInstance();
    }
    private static void exitOs(){
        studentController.EXIT_FLAG=true;
    }

    private void update(){
        System.out.println("请输入要修改学生的学号");
        int sid=input.nextInt();
        studentService.update(sid);
    }
}
