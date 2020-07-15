package phase_1;

import java.io.Serializable;
import java.util.List;

public class StudentCourses implements Serializable {
    private String id;
    private List<Integer> code;

    public StudentCourses(String id,List<Integer> code){
        this.id = id;
        this.code=code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Integer> getCode() {
        return code;
    }

    public void setCode(List<Integer> code) {
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
