package phase_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 加载数据，并序列化到文件
 */
public class InitData {
    List<Students> studentsList = new ArrayList<>();
    List<Courses> coursesList = new ArrayList<>();
    List<StudentCourses> studentCoursesList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        initStudents();
        initCourses();
        initStudentCourse();
    }

    /**
     * 创建学生数据
     */
    public static void initStudents() throws IOException {
        List<Students> studentsList=new ArrayList<>();


        studentsList.add(new Students("18","wang","MALE","2001-7-7"));
        studentsList.add(new Students("19","zhang","MALE","2001-8-8"));
        studentsList.add(new Students("20","Li","FEMALE","2000-6-6"));

        ObjectOutputStream oos=new ObjectOutputStream(
                new FileOutputStream(new File("src//phase_1//data//students.dat"),true));

        for (Students students : studentsList) {
            oos.writeObject(students);
        }
        oos.flush();
    }

    /**
     * 创建课程数据
     */
    public static void initCourses() throws IOException {
        List<Courses> coursesList = new ArrayList<>();

        coursesList.add(new Courses(10,"Math",2020,"第一学期","Teacher_1"));
        coursesList.add(new Courses(11,"English",2020,"第二学期","Teacher_2"));
        coursesList.add(new Courses(12,"PE",2020,"第二学期","Teacher_3"));

        ObjectOutputStream oos=new ObjectOutputStream(
                new FileOutputStream(new File("src//phase_1//data//courses.dat"),true));

        for (Courses courses : coursesList) {
            oos.writeObject(courses);
        }
        oos.flush();
    }

    /**
     * 创建学生课程数据
     */
    public static void initStudentCourse() throws IOException {
        List<StudentCourses> studentCoursesList = new ArrayList<>();

        studentCoursesList.add(new StudentCourses("18", new ArrayList<>()));
        studentCoursesList.add(new StudentCourses("19",new ArrayList<>()));
        studentCoursesList.add(new StudentCourses("20",new ArrayList<>()));

        ObjectOutputStream oos=new ObjectOutputStream(
                new FileOutputStream(new File("src//phase_1//data//student_courses.dat"),true));

        for (StudentCourses studentCourses : studentCoursesList) {
            oos.writeObject(studentCourses);
        }
        oos.flush();
    }


}