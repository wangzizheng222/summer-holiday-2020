package phase_1;

import java.io.Serializable;

public class StudentCourses implements Serializable {
    private String id;
    private int code;

    public StudentCourses(String id,int code){
        this.id = id;
        this.code=code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "StudentCourses{" +
                "id='" + id + '\'' +
                ", code=" + code +
                '}';
    }
}
