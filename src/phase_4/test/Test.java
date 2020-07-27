package phase_4.test;

import phase_4.dao.ClassDao;
import phase_4.daoimpl.ClassDaoImpl;
import phase_4.daoimpl.Daoimpl;
import phase_4.daoimpl.StudentDaoImpl;
import phase_4.entity.Class;
import phase_4.entity.Student;
import phase_4.entity.Student_Class;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        StudentDaoImpl studentDao=new StudentDaoImpl();
        Daoimpl daoimpl=new Daoimpl();
        ClassDao classDao=new ClassDaoImpl();

        Class my_class =new Class();
        my_class.setName("wzz");
        my_class.setGrade("19");
        classDao.add(my_class);
        // Student student=new Student();
        // student.setId(2);
        // student.setName("wzz");
        // studentDao.add(student);
        // studentDao.delete("wzz");

        List<Class> classes=classDao.findAll();
        List<Student> students=studentDao.findAll();
        List<Student_Class> list=daoimpl.findAll();

        for (Student student1:students){
            System.out.println(student1);
        }

        for (Class class1:classes){
            System.out.println(class1);
        }

        for (Student_Class student_class:list){
            System.out.println(student_class);
        }
    }
}
