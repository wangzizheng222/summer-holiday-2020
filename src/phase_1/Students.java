package phase_1;

import java.io.Serializable;

public class Students implements Serializable {
    private String id;
    private String name;
    private String sex;
    private String birthday;

    public Students(String id,String name,String sex,String birthday){
        this.id=id;
        this.name=name;
        this.sex=sex;
        this.birthday=birthday;
    }

    public String getId() {
        return id;
    }

    public void setAge(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
