function print_table(students) {
    //向上取整
    document.getElementById("page").value=Math.ceil(students.length/10);
    let current_page = document.getElementById("current_page").value;
    current_page=parseInt(current_page);

    //单页不足10个对象时
    var stop_index=(current_page-1)*10+10;
    if (stop_index>students.length){
        stop_index=students.length;
    }

    var inner_value="";
    for (let i=(current_page-1)*10;i<stop_index;i++){

        inner_value=inner_value+"<tr>\n" +
            "            <td>\n" +
            "                <input type=\"checkbox\" name='id_checkbox'>\n" +
            "            </td>\n" +
            "            <td width=\"80\">"+(parseInt(i)+1).toString()+"</td>\n" +
            "            <td width=\"200\">"+students[i].id+"</td>\n" +
            "            <td width=\"200\">"+students[i].name+"</td>\n" +
            "            <td width=\"70\">"+students[i].sex+"</td>\n" +
            "            <td width=\"250\">"+students[i].college+"</td>\n" +
            "            <td width=\"120\">"+students[i].major+"</td>\n" +
            "            <td width=\"100\">"+students[i].grade+"</td>\n" +
            "            <td width=\"100\">"+students[i].class+"</td>\n" +
            "            <td width=\"60\">"+students[i].age+"</td>\n" +
            "            <td width=\"80\">"+students[i].hobby+"</td>\n" +
            "            <td width=\"100\">"+"<a onclick='check("+parseInt(i)+")'>查看</a><a onclick='alt("+parseInt(i)+")'>修改</a>"+"</td>\n" +
            "        </tr>"

    }

    inner_value="<tr>\n" +
        "            <td>\n" +
        "                <input type=\"checkbox\" name='checkbox_total' onclick='checkbox_select_all()'>\n" +
        "            </td>\n" +
        "            <td width=\"80\">序号</td>\n" +
        "            <td width=\"200\">学号</td>\n" +
        "            <td width=\"200\">姓名</td>\n" +
        "            <td width=\"70\">性别</td>\n" +
        "            <td width=\"250\">学院</td>\n" +
        "            <td width=\"120\">专业</td>\n" +
        "            <td width=\"100\">年级</td>\n" +
        "            <td width=\"100\">班级</td>\n" +
        "            <td width=\"60\">年龄</td>\n" +
        "            <td width=\"80\">爱好</td>\n" +
        "            <td width=\"100\">操作</td>\n" +
        "        </tr>"+inner_value;
    document.getElementById("table").innerHTML=inner_value;
    return 0;
}

function save_data(students) {
    var value=JSON.stringify(students);
    localStorage.setItem("my_data",value);
}

function show_add() {
    document.getElementById("add").style.display="block";
}

function remove(students) {
    const id_checkbox = document.getElementsByName("id_checkbox");
    const r = confirm("确定删除所选项？");
    if (r===true){
        let j=0;
        for(let i = 0; i < id_checkbox.length; i++){
            if(id_checkbox[i].checked){
                students.splice(j,1);
            }
            else {
                j=j+1;
            }
        }
    }
    save_data(students)
    print_table(students)
}

function checkbox_select_all() {
    const id_checkbox_all=document.getElementsByName("checkbox_total");
    const id_checkbox = document.getElementsByName("id_checkbox");
    for(let i = 0; i < id_checkbox.length; i++){
        if (id_checkbox_all[0].checked){
            if(id_checkbox[i].checked){
            }
            else {
                id_checkbox[i].checked=true;
            }
        }
        else {
            if(id_checkbox[i].checked){
                id_checkbox[i].checked=false;
            }
        }
    }
}

function check(i) {
    document.getElementById("check").style.display="block";
    var value="";
    value=value+"<h2>查看学生信息</h2>\n" +
        "    <div>\n" +
        "        <span>学号</span>\n" +
        "        <span>"+students[i].id+"</span>\n" +
        "    </div>\n" +
        "    <div>\n" +
        "        <span>姓名</span>\n" +
        "        <span>"+students[i].name+"</span>\n" +
        "    </div>\n" +
        "    <div>\n" +
        "        <span>性别</span>\n" +
        "        <span>"+students[i].sex+"</span>\n" +
        "    </div>\n" +
        "    <div>\n" +
        "        <span>学院</span>\n" +
        "        <span>"+students[i].college+"</span>\n" +
        "    </div>\n" +
        "    <div>\n" +
        "        <span>专业</span>\n" +
        "        <span>"+students[i].major+"</span>\n" +
        "    </div>\n" +
        "    <div>\n" +
        "        <span>年级</span>\n" +
        "        <span>"+students[i].grade+"</span>\n" +
        "    </div>\n" +
        "    <div>\n" +
        "        <span>班级</span>\n" +
        "        <span>"+students[i].class+"</span>\n" +
        "    </div>\n" +
        "        <div>\n" +
        "        <span>年龄</span>\n" +
        "        <span>"+students[i].age+"</span>\n" +
        "    </div>\n" +
        "    <div>\n" +
        "        <span>爱好</span>\n" +
        "        <span>"+students[i].hobby+"</span>\n" +
        "    </div>\n" +
        "\n" +
        "    <button class=\"btn\" onclick=\"check_cancel()\">取消</button>"
    document.getElementById("check").innerHTML=value;
}

function check_cancel() {
    document.getElementById("check").style.display="none";
}

function alt(i) {
    document.getElementById("alt_student_id").value=i;
    document.getElementById("alt").style.display="block";

    document.getElementById("alt_id").value=students[i].id;
    document.getElementById("alt_name").value=students[i].name;
    if (students[i].sex==="男"){
        document.getElementsByName("alt_sex")[0].checked=true;
    }
    else {
        document.getElementsByName("alt_sex")[1].checked=true;
    }
    document.getElementById("alt_college").value=students[i].college;
    document.getElementById("alt_major").value=students[i].major;
    document.getElementById("alt_grade").value=students[i].grade;
    document.getElementById("alt_class").value=students[i].class;
    document.getElementById("alt_age").value=students[i].age;
    document.getElementById("alt_hobby").value=students[i].hobby;
}

function submit_alt() {
    class Students{

    }

    const new_student = new Students();

    let sex;
    if (document.getElementsByName("alt_sex")[0].checked){
        sex="男";
    }
    else sex="女";

    new_student.id=document.getElementById("alt_id").value;
    new_student.name=document.getElementById("alt_name").value;
    new_student.sex=sex;
    new_student.college=document.getElementById("alt_college").value;
    new_student.major=document.getElementById("alt_major").value;
    new_student.grade=document.getElementById("alt_grade").value;
    new_student.class=document.getElementById("alt_class").value;
    new_student.age=document.getElementById("alt_age").value;
    new_student.hobby=document.getElementById("alt_hobby").value;

    if (new_student.id!=="" && new_student.name!=="" && new_student.sex!==""
        && new_student.college!=="" && new_student.major!=="" && new_student.grade!==""
        && new_student.college!=="" && new_student.age!=="" && new_student.hobby!==""){
        //新增数据
        let i=document.getElementById("alt_student_id").value;
        i=parseInt(i);
        students[i]=new_student;
        //存储数据
        save_data(students);
        //刷新界面
        print_table(students);

        alt_cancel();
        alert("已修改数据！")
    }
    else {
        alert("所有字段不能为空")
    }
}

function alt_cancel() {
    document.getElementById("alt").style.display="none";
}

function next_page(students) {
    if (parseInt(document.getElementById("current_page").value)
    <parseInt(document.getElementById("page").value)){
        document.getElementById("current_page").value=parseInt(document.getElementById("current_page").value)+1;
        print_table(students);
    }
    else {
        alert("当前已是最后一页");
    }

}

function last_page(students) {
    if (parseInt(document.getElementById("current_page").value)
        >1){
        document.getElementById("current_page").value=parseInt(document.getElementById("current_page").value)-1;
        print_table(students);
    }
    else {
        alert("当前已是第一页");
    }

}

function refresh_data() {
    let r=confirm("确认初始化数据？")
    if (r===true){
        save_data(init_data())
        students = localStorage.my_data;
        students = JSON.parse(students);
        document.getElementById("page").value=2;
        document.getElementById("current_page").value=1;
        print_table(students);
    }
}
