package phase_1;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 选课系统主程序
 */
public class CourseSelection {
    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        System.out.println("Welcome to Courses Selection !");
        while (true){
            System.out.println("Enter the number of service: ");
            System.out.println("1、students manager\t2、courses\n3、select courses\t4、exit");
            switch (input.nextInt()){
                case 1:studentManager();break;
                case 2:courseManager();break;
                case 3:selectManager();break;
                case 4:System.exit(0);break;
                default:
                    System.out.println("please enter the right number");
            }
        }
    }

    //学生信息管理
    public static void studentManager() throws IOException {
        //读取数据
        List<Students> studentsList=ReadData.readStudents();

        //打印列表
        for (int i=0;i<studentsList.size();i++){
            Students student=studentsList.get(i);
            System.out.print(i+1+",");
            System.out.println(student.toString());
        }

        //各功能的实现
        while (true){
            //打印功能选项
            System.out.println("Enter the number of service: ");
            System.out.println("1、add\t2、remove\n3、alter\t4、exit");

            //用户输入
            Scanner input=new Scanner(System.in);
            int selectNumber=input.nextInt();
            if (selectNumber==1){
                String name;
                String id;
                String sex;
                String birthday;

                //用户输入
                input.nextLine();
                System.out.println("Enter the name of the student that you want to add");
                name=input.nextLine();
                System.out.println("Enter the id of the student that you want to add");
                id=input.nextLine();
                System.out.println("Enter the sex of the student that you want to add(MALE or FEMALE)");
                sex=input.nextLine();
                System.out.println("Enter the birthday of the student that you want to add");
                birthday=input.nextLine();
                try
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
                    Date date = sdf.parse(birthday);
                    System.out.println(date);
                }
                catch (ParseException e)
                {
                    System.out.println(e.getMessage());
                }

                //加入列表
                studentsList.add(new Students(id,name,sex,birthday));
                System.out.println("successfully added");
                ObjectOutputStream oos=new ObjectOutputStream(
                        new FileOutputStream(new File("src//phase_1//data//students.dat")));

                for (Students students : studentsList) {
                    oos.writeObject(students);
                }
                oos.flush();

                //同时更新选课列表
                List<StudentCourses> studentCoursesList = ReadData.readStudentCourses();
                studentCoursesList.add(new StudentCourses(id,new ArrayList<>()));
                ObjectOutputStream oos_2=new ObjectOutputStream(new FileOutputStream(
                        new File("src//phase_1//data//student_courses.dat")
                ));
                for (StudentCourses studentCourses:studentCoursesList){
                    oos_2.writeObject(studentCourses);
                }
                oos_2.flush();

                studentsList=ReadData.readStudents();

                //打印列表
                for (int i=0;i<studentsList.size();i++){
                    Students student=studentsList.get(i);
                    System.out.print(i+1+",");
                    System.out.println(student.toString());
                }
            }
            else if (selectNumber==2){
                System.out.println("enter the id you want to remove");
                int remove_pos=input.nextInt()-1;
                studentsList.remove(remove_pos);
                System.out.println("已成功删除，学生信息列表为：");

                //向文件中写入
                ObjectOutputStream oos=new ObjectOutputStream(
                        new FileOutputStream(new File("src//phase_1//data//students.dat")));

                for (Students students : studentsList) {
                    oos.writeObject(students);
                }
                oos.flush();

                //同时更新选课列表
                List<StudentCourses> studentCoursesList = ReadData.readStudentCourses();
                studentCoursesList.remove(remove_pos);
                ObjectOutputStream oos_2=new ObjectOutputStream(new FileOutputStream(
                        new File("src//phase_1//data//student_courses.dat")
                ));
                for (StudentCourses studentCourses:studentCoursesList){
                    oos_2.writeObject(studentCourses);
                }
                oos_2.flush();

                //重新读取数据
                studentsList=ReadData.readStudents();

                //打印列表
                for (int i=0;i<studentsList.size();i++){
                    Students student=studentsList.get(i);
                    System.out.print(i+1+",");
                    System.out.println(student.toString());
                }
            }
            else if (selectNumber==3){
                //打印列表
                for (int i=0;i<studentsList.size();i++){
                    Students student=studentsList.get(i);
                    System.out.print(i+1+",");
                    System.out.println(student.toString());
                }

                //获取要更改的对象
                int pos;
                System.out.println("enter the id you want to alter");
                pos=input.nextInt()-1;

                //重新获取要更改数据的信息
                String name;
                String id;
                String sex;
                String birthday;

                //用户输入
                input.nextLine();
                System.out.println("Enter the name of the student that you want to alter");
                name=input.nextLine();
                System.out.println("Enter the id of the student that you want to alter");
                id=input.nextLine();
                System.out.println("Enter the sex of the student that you want to alter(MALE or FEMALE)");
                sex=input.nextLine();
                System.out.println("Enter the birthday of the student that you want to alter");
                birthday=input.nextLine();

                //加入列表
                studentsList.set(pos,new Students(id,name,sex,birthday));
                System.out.println("successfully altered");
                ObjectOutputStream oos=new ObjectOutputStream(
                        new FileOutputStream(new File("src//phase_1//data//students.dat")));

                for (Students students : studentsList) {
                    oos.writeObject(students);
                }
                oos.flush();

                //同时更新选课列表
                List<StudentCourses> studentCoursesList = ReadData.readStudentCourses();
                studentCoursesList.add(new StudentCourses(id,new ArrayList<>()));
                for (StudentCourses studentCourses:studentCoursesList){
                    new ObjectOutputStream(new FileOutputStream(
                            new File("src//phase_1//data//student_courses.dat")
                    )).writeObject(studentCourses);
                }

                studentsList=ReadData.readStudents();

                //打印列表
                for (int i=0;i<studentsList.size();i++){
                    Students student=studentsList.get(i);
                    System.out.print(i+1+",");
                    System.out.println(student.toString());
                }
            }
            else if (selectNumber==4){
                break;
            }
        }

    }

    //课程信息管理
    public static void courseManager() throws IOException {
        //读取数据
        List<Courses> coursesList=ReadData.readCourses();

        //打印列表
        for (int i=0;i<coursesList.size();i++){
            Courses course=coursesList.get(i);
            System.out.print(i+1+",");
            System.out.println(course.toString());
        }

        //各功能的实现
        while (true){
            //打印功能选项
            System.out.println("Enter the number of service: ");
            System.out.println("1、add\t2、remove\n3、alter\t4、exit");

            //用户输入
            Scanner input=new Scanner(System.in);
            int selectNumber=input.nextInt();
            if (selectNumber==1){
                int code;
                String name;
                int year;
                String term;
                String teacher;

                //用户输入
                input.nextLine();
                System.out.println("Enter the code of the course that you want to add");
                code=input.nextInt();
                input.nextLine();
                System.out.println("Enter the name of the course that you want to add");
                name=input.nextLine();
                System.out.println("Enter the year of the course that you want to add(MALE or FEMALE)");
                year=input.nextInt();
                input.nextLine();
                System.out.println("Enter the term of the course that you want to add");
                term=input.nextLine();
                System.out.println("Enter the teacher of the course that you want to add");
                teacher=input.nextLine();

                //加入列表
                coursesList.add(new Courses(code,name,year,term,teacher));
                System.out.println("successfully added");
                ObjectOutputStream oos=new ObjectOutputStream(
                        new FileOutputStream(new File("src//phase_1//data//courses.dat")));

                for (Courses courses : coursesList) {
                    oos.writeObject(courses);
                }
                oos.flush();
                coursesList=ReadData.readCourses();

                //打印列表
                for (int i=0;i<coursesList.size();i++){
                    Courses course=coursesList.get(i);
                    System.out.print(i+1+",");
                    System.out.println(course.toString());
                }
            }
            else if (selectNumber==2){
                System.out.println("enter the id you want to remove");
                coursesList.remove(input.nextInt()-1);
                System.out.println("已成功删除，课程信息列表为：");

                //向文件中写入
                ObjectOutputStream oos=new ObjectOutputStream(
                        new FileOutputStream(new File("src//phase_1//data//courses.dat")));

                for (Courses courses : coursesList) {
                    oos.writeObject(courses);
                }
                oos.flush();

                //重新读取数据
                coursesList=ReadData.readCourses();

                //打印列表
                for (int i=0;i<coursesList.size();i++){
                    Courses course=coursesList.get(i);
                    System.out.print(i+",");
                    System.out.println(course.toString());
                }
            }
            else if (selectNumber==3){
                //打印列表
                for (int i=0;i<coursesList.size();i++){
                    Courses course=coursesList.get(i);
                    System.out.print(i+1+",");
                    System.out.println(course.toString());
                }

                //获取要更改的对象
                int pos;
                System.out.println("enter the id you want to alter");
                pos=input.nextInt()-1;

                //重新获取要更改数据的信息
                int code;
                String  name;
                int year;
                String term;
                String teacher;

                input.nextLine();
                System.out.println("Enter the code of the course that you want to add");
                code=input.nextInt();
                input.nextLine();
                System.out.println("Enter the name of the course that you want to add");
                name=input.nextLine();
                System.out.println("Enter the year of the course that you want to add(MALE or FEMALE)");
                year=input.nextInt();
                input.nextLine();
                System.out.println("Enter the term of the course that you want to add");
                term=input.nextLine();
                System.out.println("Enter the teacher of the course that you want to add");
                teacher=input.nextLine();

                //加入列表
                coursesList.set(pos,new Courses(code,name,year,term,teacher));
                System.out.println("successfully altered");
                ObjectOutputStream oos=new ObjectOutputStream(
                        new FileOutputStream(new File("src//phase_1//data//courses.dat")));

                for (Courses courses : coursesList) {
                    oos.writeObject(courses);
                }
                oos.flush();
                coursesList=ReadData.readCourses();

                //打印列表
                for (int i=0;i<coursesList.size();i++){
                    Courses course=coursesList.get(i);
                    System.out.print(i+1+",");
                    System.out.println(course.toString());
                }
            }
            else if (selectNumber==4){
                break;
            }
        }

    }

    //学生选课
    public static void selectManager() throws IOException {
        List<StudentCourses> studentCoursesList=ReadData.readStudentCourses();
        List<Courses> coursesList=ReadData.readCourses();

        Scanner input=new Scanner(System.in);
        int pos;

        //查找该学生的位置
        pos = -1;
        System.out.println("enter your id:");
        String id=input.nextLine();
        //匹配位置
        for (int i=0;i<studentCoursesList.size();i++){
            if (studentCoursesList.get(i).getId().equals(id)){
                pos=i;
                break;
            }
        }

        //输入错误后，重新输入学号
        while (pos==-1){
            System.out.println("未找到该学生");
            //查找该学生的位置
            pos = -1;
            System.out.println("enter your id:");
            id=input.nextLine();
            for (int i=0;i<studentCoursesList.size();i++){
                if (studentCoursesList.get(i).getId().equals(id)){
                    pos=i;
                    break;
                }
            }
        }

        while (true){
            System.out.println("Enter the number of service: ");
            System.out.println("1、select course\t2、drop courses\n3、check out courses\t4、exit");
            int select_number=input.nextInt();
            if (select_number==1){

                //打印列表
                for (Courses course:coursesList) {
                    System.out.println(course.toString());
                }

                System.out.println("select the code of the course that you want to add");
                int code=input.nextInt();

                List<Integer> temp_code=studentCoursesList.get(pos).getCode();
                temp_code.add(code);

                studentCoursesList.set(pos,new StudentCourses(id,temp_code));

                //将数据写入文件
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(
                        new File("src//phase_1//data//student_courses.dat")
                ));
                for (StudentCourses studentCourses:studentCoursesList) {
                    oos.writeObject(studentCourses);
                }
                oos.flush();
            }
            else if (select_number==2){
                List<Integer> temp_code=studentCoursesList.get(pos).getCode();

                //打印列表
                for (int i=0;i<temp_code.size();i++){
                    System.out.print(i+1+",");
                    System.out.println("课程代码："+temp_code.get(i));
                }

                System.out.println("select the number of the course that you want to drop");
                int code_num=input.nextInt();


                temp_code.remove(code_num-1);

                studentCoursesList.set(pos,new StudentCourses(id,temp_code));

                //将数据写入文件
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(
                        new File("src//phase_1//data//student_courses.dat")
                ));
                for (StudentCourses studentCourses:studentCoursesList) {
                    oos.writeObject(studentCourses);
                }
                oos.flush();
            }
            else if (select_number==3){
                //打印列表
                for (StudentCourses studentCourses : studentCoursesList) {
                    System.out.println(studentCourses.toString());
                }
            }
            else {
                break;
            }
        }
    }
}
