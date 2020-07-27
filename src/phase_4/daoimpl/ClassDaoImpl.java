package phase_4.daoimpl;

import phase_4.dao.ClassDao;
import phase_4.entity.Class;
import phase_4.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDaoImpl implements ClassDao {


    @Override
    public void add(Class my_class) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        conn= DBUtils.getConnection();

        try {
            String sql = "insert into class(name,grade)values(?,?)";

            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,my_class.getName());
            pstmt.setString(2,my_class.getGrade());

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
    public void delete(String name) throws SQLException {
        //创建Connection对象，PreparedStatement对象
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn=DBUtils.getConnection();

        try {
            String sql="delete from class where name =?";
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
    public void update(Class my_class) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt=null;

        conn=DBUtils.getConnection();
        try {
            String sql="update class set name = ?, grade = ?";
            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,my_class.getName());
            pstmt.setString(2,my_class.getGrade());

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
    public List<Class> findBy(String name) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Class my_class=null;

        List<Class> classes=new ArrayList<Class>();
        conn=DBUtils.getConnection();

        try {
            String sql="select * from class where name = ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);

            rs=ps.executeQuery();
            while (rs.next()){
                my_class=new Class();
                my_class.setName(rs.getString(1));
                my_class.setGrade(rs.getString(2));

                classes.add(my_class);
                System.out.println("查询中  ");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(null,ps,conn);
        }
        return classes;
    }


    @Override
    public List<Class> findAll() throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Class my_class=null;

        List<Class> classes=new ArrayList<Class>();
        conn=DBUtils.getConnection();

        try {
            String sql="select * from class";
            ps=conn.prepareStatement(sql);

            rs=ps.executeQuery();
            while (rs.next()){
                my_class=new Class();
                my_class.setName(rs.getString(1));
                my_class.setGrade(rs.getString(2));

                classes.add(my_class);
                System.out.println("查询中  ");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(null,ps,conn);
        }
        return classes;
    }
}
