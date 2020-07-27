package phase_4.daoimpl;

import phase_4.dao.StudentDao;
import phase_4.entity.Student;
import phase_4.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {


    @Override
    public void add(Student student) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        conn= DBUtils.getConnection();

        try {
            String sql = "insert into student(id,name)values(?,?)";

            pstmt=conn.prepareStatement(sql);

            pstmt.setInt(1,student.getId());
            pstmt.setString(2,student.getName());

            int rs=pstmt.executeUpdate();

            if (rs>0){
                System.out.println("添加数据成功！");
            }else {
                System.out.println("添加数据失败！");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(null,pstmt,conn);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        //创建Connection对象，PreparedStatement对象
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn=DBUtils.getConnection();

        try {
            String sql="delete from student where id =?";
            pstmt=conn.prepareStatement(sql);

            pstmt.setInt(1,id);
            int rs=pstmt.executeUpdate();

            if (rs>0){
                System.out.println("删除数据成功！");
            }
            else {
                System.out.println("删除数据失败！");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(null,pstmt,conn);
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        //创建Connection对象，PreparedStatement对象
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn=DBUtils.getConnection();

        try {
            String sql="delete from student where name =?";
            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,name);
            int rs=pstmt.executeUpdate();

            if (rs>0){
                System.out.println("删除数据成功！");
            }
            else {
                System.out.println("删除数据失败！");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(null,pstmt,conn);
        }
    }

    @Override
    public void update(Student student) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt=null;

        conn=DBUtils.getConnection();
        try {
            String sql="update student set id = ?,name = ?";
            pstmt=conn.prepareStatement(sql);

            pstmt.setInt(1,student.getId());
            pstmt.setString(2,student.getName());

            int rs=pstmt.executeUpdate();
            if (rs>0){
                System.out.println("更新数据成功！");
            }
            else {
                System.out.println("更新数据失败！");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(null,pstmt,conn);
        }
    }

    @Override
    public List<Student> findBy(int id) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Student student=null;

        List<Student> students=new ArrayList<Student>();
        conn=DBUtils.getConnection();

        try {
            String sql="select * from student where id = ?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);

            rs=ps.executeQuery();
            while (rs.next()){
                student=new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));

                students.add(student);
                System.out.println("查询中  ");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(null,ps,conn);
        }
        return students;
    }

    @Override
    public List<Student> findBy(String name) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Student student=null;

        List<Student> students=new ArrayList<Student>();
        conn=DBUtils.getConnection();

        try {
            String sql="select * from student where name = ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);

            rs=ps.executeQuery();
            while (rs.next()){
                student=new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));

                students.add(student);
                System.out.println("查询中  ");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(null,ps,conn);
        }
        return students;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Student student=null;

        List<Student> students=new ArrayList<Student>();
        conn=DBUtils.getConnection();

        try {
            String sql="select * from student";
            ps=conn.prepareStatement(sql);

            rs=ps.executeQuery();
            while (rs.next()){
                student=new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));

                students.add(student);
                System.out.println("查询中  ");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(null,ps,conn);
        }
        return students;
    }
}
