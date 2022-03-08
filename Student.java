package studentManager;

public class Student {
    private String stuId;
    private String name;
    private int age;
    private String birthday;

    public Student() {
    }

    public Student(String stuId, String name, int age, String birthday) {
        this.stuId = stuId;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }


    public String getStuId() {
        return stuId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBirthday() {
        return birthday;
    }


    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}
