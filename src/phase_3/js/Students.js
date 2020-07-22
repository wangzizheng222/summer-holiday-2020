
function init_data() {
    class Students {
    }

    var student = [];
    student.length=0;

//给数组赋值
    let i=0;
    for (let j=0;j<5;j++){
        student[i]=new Students();
        student[i].id=11923040301;
        student[i].name="张三";
        student[i].sex="男";
        student[i].college="人工智能学院";
        student[i].major="智科";
        student[i].grade=19;
        student[i].class=3;
        student[i].age=19;
        student[i].hobby="打篮球";

        student[i+1]=new Students();
        student[i+1].id=11923040302;
        student[i+1].name="李四";
        student[i+1].sex="男";
        student[i+1].college="人工智能学院";
        student[i+1].major="智科";
        student[i+1].grade=19;
        student[i+1].class=3;
        student[i+1].age=19;
        student[i+1].hobby="绘画";

        student[i+2]=new Students();
        student[i+2].id=11923040303;
        student[i+2].name="王五";
        student[i+2].sex="女";
        student[i+2].college="人工智能学院";
        student[i+2].major="智科";
        student[i+2].grade=18;
        student[i+2].class=3;
        student[i+2].age=20;
        student[i+2].hobby="唱歌";

        student[i+3]=new Students();
        student[i+3].id=11923040304;
        student[i+3].name="赵六";
        student[i+3].sex="女";
        student[i+3].college="人工智能学院";
        student[i+3].major="智科";
        student[i+3].grade=17;
        student[i+3].class=3;
        student[i+3].age=17;
        student[i+3].hobby="踢足球";

        i=i+4;
    }
    student.length=20;

    return student;
}

