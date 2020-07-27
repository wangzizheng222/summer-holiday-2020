package phase_4.daoimpl;

import phase_4.entity.Student_Class;
import phase_4.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Daoimpl {
    public List<Student_Class> findAll(){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Student_Class student_class=null;

        List<Student_Class> student_classList=new ArrayList<Student_Class>();

        conn= DBUtils.getConnection();

        try {
            String sql="select student.id , student.name , class.grade from student,class where student.name = class.name";
            ps=conn.prepareStatement(sql);

            rs=ps.executeQuery();

            while (rs.next()){
                student_class=new Student_Class();
                student_class.setId(rs.getInt(1));
                student_class.setName(rs.getString(2));
                student_class.setGrade(rs.getString(3));

                student_classList.add(student_class);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtils.close(null,ps,conn);
        }
        return student_classList;
    }
}
