package phase_4.dao;

import phase_4.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    //定义数据库操作方法
    public void add(Student student) throws SQLException;
    public void delete(int id) throws SQLException;
    public void delete(String name) throws SQLException;
    public void update(Student student) throws SQLException;
    public List<Student> findBy(int id) throws SQLException;
    public List<Student> findBy (String name) throws SQLException;
    public List<Student> findAll() throws SQLException;
}
