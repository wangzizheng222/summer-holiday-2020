package phase_1;

public class StudentCourses {
    private String id;
    private int code;

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
