package service;

import com.xxxx.utils.MethosUtils;
import dao.StudentDao;
import dao.StudentDaolmpl;
import vo.Student;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Properties;

public class StudentServicelmpl implements StudentService {
    //属性
    String[] schools={"清华","北大","厦大","复旦","南开","天津","浙大"};
    String[][] majors={{"数学","物理","电竞"},{"语文","历史"},{"文学","生物"},{"政治","计算机"},{"高数","低数"},{"化学","电子"}};

    //身份证属性
    String[] nan={"2","4","6","8","X"};
    String[] nv={"1","3","5","7","9","0"};

    //业务层调用数据处理层
    private StudentDao studentDao=new StudentDaolmpl();

    @Override
    public void add(Student student) {
    }
    //定义变量存放
    private static int count=1;
    @Override
    public void deleteByprimaryKey(int sid) {
        this.studentDao.deleteByprimaryKey(sid);
    }
    public boolean login(String Uname, String Password) throws IOException {
        //读取配置文件
        Properties properties=new Properties();
        //读取配置文件中的用户名和密码
        properties.load(this.getClass().getClassLoader().getResourceAsStream("user.properties"));
        String ppuname=properties.getProperty("uname");
        String pppassword=properties.getProperty("passwd");
        //校验用户名和密码
        if(Uname.equals(ppuname)&&Password.equals(pppassword)){
            return true;
        }
        return false;
    }
    public void update(int sid){
        this.studentDao.update(sid);
    }
    public void show(){
        studentDao.show();
    }

    @Override
    public void FindId(String sname) {
        this.studentDao.FindId(sname);
    }

    @Override
    public void FindName(int idname) {
        this.studentDao.FindName(idname);
    }

    @Override
    public void SaveToFile() throws IOException {
        this.studentDao.SaveToFile();
    }

    @Override
    public void deleteAll() {
        this.studentDao.DeleteAll();
    }

    @Override
    public void AVG() {
        this.studentDao.AVG();
    }

    @Override
    public void schoolAvg() {
        this.studentDao.schoolAvg();
    }

    @Override
    public void randId() {
        this.studentDao.randId();
    }

    @Override
    public void addInstance() {
        //随机生成属性对应的值
        //private
        Student student=new Student();
        //设置学号
        student.setSno(StudentServicelmpl.count++);
        //设置姓名
        student.setName(MethosUtils.generateChineseName());
        //设置学校
        student.setSchool(schools[(int)(Math.random()*7)]);
        //设置专业
        student.setMajor(majors[(int)(Math.random()*majors.length)][(int)(Math.random())*majors[(int)(Math.random())*majors.length].length]);
        //随机设置生日
        long dateTime = LocalDateTime.of(1995, 1, 1, 0, 0, 0).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        long dateTime1 = LocalDateTime.of(2005, 1, 1, 0, 0, 0).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        long random=(long) (Math.random()*(dateTime1-dateTime)+dateTime);
        student.setBirthday(new Date(random));
        //随机性别
        Double d=Math.random();
        if(d>0.4){
            student.setGender("女");
        }else {
            student.setGender("男");
        }
        //随机身份证
        int id1=(int)(Math.random()*(99999999-10000000+1)+10000000);
        int id3=(int)(Math.random()*(999-100+1)+100);
        if(student.getGender()=="男"){
            student.setIdCard(String.valueOf(id1) +MethosUtils.formatDateToEightDigits(student.getBirthday())+String.valueOf(id3)+nan[(int)Math.random()*4]);
        }else {
            student.setIdCard(String.valueOf(id1) +MethosUtils.formatDateToEightDigits(student.getBirthday())+String.valueOf(id3)+nv[(int)Math.random()*4]);
        }
        //随机生成民族
        student.setNation(MethosUtils.generateRandomEthnicity());
        //当前系统时间
        student.setCreateTime(new Date());
        student.setUpdateTime(new Date());
        //生成分数
        student.setScore((int)(Math.random()*100));
        //存储到List
        this.studentDao.addInstance(student);
    }

}
