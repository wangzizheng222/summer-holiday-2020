package phase_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 从文件中读取数据
 */
public class ReadData {
    public static List<Students> readStudents() throws IOException {
        List<Students> studentsList=new ArrayList<>();

        ObjectInputStream ois=new ObjectInputStream(
                new FileInputStream(new File("src//phase_1//data//students.dat")));
        while (true){
            try {
                studentsList.add((Students)ois.readObject());
            }
            catch (IOException | ClassNotFoundException e){
                System.out.println("成功读取学生信息");
                break;
            }
        }
        return studentsList;
    }

    public static List<Courses> readCourses() throws IOException {
        List<Courses> coursesList = new ArrayList<>();

        ObjectInputStream ois=new ObjectInputStream(
                new FileInputStream(new File("src//phase_1//data//courses.dat")));
        while (true){
            try {
                coursesList.add((Courses) ois.readObject());
            }
            catch (IOException | ClassNotFoundException e){
                System.out.println("成功读取课程信息");
                break;
            }
        }
        return coursesList;
    }

    public static List<StudentCourses> readStudentCourses() throws IOException {
        List<StudentCourses> studentCoursesList = new ArrayList<>();

        ObjectInputStream ois=new ObjectInputStream(
                new FileInputStream(new File("src//phase_1//data//student_courses.dat")));
        while (true){
            try {
                studentCoursesList.add((StudentCourses) ois.readObject());
            }
            catch (IOException | ClassNotFoundException e){
                System.out.println("成功读取学生选课信息");
                break;
            }
        }
        return studentCoursesList;
    }
}
