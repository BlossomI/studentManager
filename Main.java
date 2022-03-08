package studentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Student> stuList = new ArrayList<>();

    static {
        stuList.add(new Student("it001", "zhang3", 18, "2020-11-11"));
        stuList.add(new Student("it002", "zhang4", 17, "2020-11-11"));
        stuList.add(new Student("it003", "zhang5", 16, "2020-11-11"));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("========Welcome to Student Management System========");
        System.out.println("1: Add student info");
        System.out.println("2: Modify student info");
        System.out.println("3: Remove student info");
        System.out.println("4: Show all information");
        System.out.println("5: Exit System");

        loop:
        while (true) {
            System.out.println();
            System.out.println("please input number to continue:");
            String flag = in.nextLine();
            switch (flag) {
                case "1" -> addStu();
                case "2" -> updateStu();
                case "3" -> deleteStu();
                case "4" -> showStu();
                case "5" -> {
                    System.out.println("Bye bye~");
                    break loop;
                }
                default -> System.out.println("please input number 1-5");
            }
        }
    }

    /**
     * Add
     * 执行增加学生信息功能：
     * 1. 获得输入（学号，姓名，年龄，生日），需判断学号是否已存在
     * 2. 将获得的信息创建为对象并放入stuList中
     */
    public static void addStu() {
        Scanner in = new Scanner(System.in);
        System.out.println("add please input student ID:");

        String Id;
        loop:
        while (true) {
            Id = in.nextLine();
            for (Student s : stuList) {
                // if matches, continue the loop.
                if (Id.equals(s.getStuId())) {
                    System.out.println("Student ID Exists, please try again~~");
                    continue loop;
                }
            }
            break;
        }

//        InputInfo();

        System.out.println("please input student name:");
        String name = in.next();
        System.out.println("please input student age:");
        int age = in.nextInt();
        System.out.println("please input student birthday");
        String birthday = in.next();

        stuList.add(new Student(Id, name, age, birthday));

    }

    /**
     * 修改学生信息，输入学号，如果存在，进行修改，否则打印未找到学生信息,请重新输入。
     */
    public static void updateStu() {
        Scanner in = new Scanner(System.in);

        // get name of id user inputted
//        System.out.println(stuList.get(getIndex()).getName());
        int index = getIndex();
        Student s = stuList.get(index);


        System.out.println("input name");
        s.setName(in.nextLine());
        System.out.println("input age");
        s.setAge(in.nextInt());
        System.out.println("input birthday");
        in.nextLine();
        s.setBirthday(in.nextLine());
    }

    /**
     * 查找学号，如果存在，则remove。
     */
    public static void deleteStu() {
        int index = getIndex();
        stuList.remove(index);
    }

    /**
     * 遍历打印所有学生信息。
     */
    public static void showStu() {
        if (stuList.size() == 0) {
            System.out.println("No information, please add one~~~");
            return;
        }
        System.out.println("ID\t\tName\tAge\t\tBirthday");
        for (Student s : stuList) {
            System.out.println(s.getStuId() + "\t" + s.getName() + "\t" + s.getAge() + "\t\t" + s.getBirthday());
        }
    }


    /**
     * 方法内部输入一个id，返回id对应的索引
     *
     * @return index of input id
     */
    public static int getIndex() {
        Scanner in = new Scanner(System.in);
        int index;
        System.out.println("please input student ID:");

        loop:
        while (true) {
            String id = in.next();
            for (int i = 0; i < stuList.size(); i++) {
                index = i;
                if (id.equals(stuList.get(i).getStuId())) {
                    break loop;
                }
            }
            System.out.println("No exist ID, please input another: ");
        }
        return index;
    }

//    public static void InputInfo() {
//
////        Scanner in = new Scanner(System.in);
////        System.out.println("add please input student ID:");
////        String Id;
////        loop:
////        while (true) {
////            Id = in.nextLine();
////            for (Student s : stuList) {
////                // if matches, continue the loop.
////                if (Id.equals(s.getStuId())) {
////                    System.out.println("Student ID Exists, please try again~~");
////                    continue loop;
////                }
////            }
////            break;
////        }
////
////        System.out.println("please input name:");
////        String name = in.next();
////        System.out.println("please input age:");
////        int age = in.nextInt();
////        System.out.println("please input birthday");
////        String birthday = in.next();
////
////        stuList.add(new Student(Id, name, age, birthday));
//
//    }
}