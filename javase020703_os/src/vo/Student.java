package vo;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private int sno;
    private String name;
    private String school;
    private String major;
    private String idCard;
    private Date birthday;
    private String gender;
    private String nation;
    private int score;
    private Date createTime;
    private Date updateTime;

    public Student(){

    }

    public Student(int sno, String name, String school, String major, String idCard, Date birthday, String gender, String nation, int score, Date createTime, Date updateTime) {
        this.sno = sno;
        this.name = name;
        this.school = school;
        this.major = major;
        this.idCard = idCard;
        this.birthday = birthday;
        this.gender = gender;
        this.nation = nation;
        this.score = score;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", major='" + major + '\'' +
                ", idCard='" + idCard + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", nation='" + nation + '\'' +
                ", score=" + score +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}