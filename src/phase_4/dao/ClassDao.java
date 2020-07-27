package phase_4.dao;

import phase_4.entity.Class;

import java.sql.SQLException;
import java.util.List;

public interface ClassDao {
    //定义数据库操作方法
    public void add(Class my_class) throws SQLException;
    public void delete(String name) throws SQLException;
    public void update(Class my_class) throws SQLException;
    public List<Class> findBy(String name) throws SQLException;
    public List<Class> findAll() throws SQLException;
}
