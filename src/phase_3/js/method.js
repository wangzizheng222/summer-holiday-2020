function print_table(students) {
    var inner_value="";
    console.log(students.length);
    for (let i=0;i<students.length;i++){

        inner_value=inner_value+"<tr>\n" +
            "            <td>\n" +
            "                <input type=\"checkbox\">\n" +
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
            "            <td width=\"100\">"+"<a>查看</a><a>修改</a>"+"</td>\n" +
            "        </tr>"
        console.log(i)
    }

    inner_value="<tr>\n" +
        "            <td>\n" +
        "                <input type=\"checkbox\">\n" +
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