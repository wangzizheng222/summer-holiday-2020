package phase_4.test;

import phase_4.daoimpl.StudentDaoImpl;
import phase_4.entity.Student;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        StudentDaoImpl studentDao=new StudentDaoImpl();
        Student student=new Student();
        student.setId(2);
        student.setName("wzz");
        // studentDao.add(student);
        // studentDao.delete("wzz");

        List<Student> students=studentDao.findBy("test");

        for (Student student1:students){
            System.out.println(student1);
        }
    }
}
