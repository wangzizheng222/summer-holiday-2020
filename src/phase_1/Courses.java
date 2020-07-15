package phase_1;

public class Courses {
    private int code;
    private String  name;
    private int year;
    private String term;
    private String teacher;

    public Courses(int code,String name,int year,String term,String teacher){
        this.code=code;
        this.name=name;
        this.year=year;
        this.term=term;
        this.teacher=teacher;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", term='" + term + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
