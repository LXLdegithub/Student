package org.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import org.example.mapper.StudentMapper;
import org.example.mapper.UserMapper;
import org.example.pojo.Student;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("all")//去掉所有的警告
@RestController
@CrossOrigin(origins = {"*","null"})//跨域
public class Controller {
    @Autowired//关联
    private StudentMapper studentMapper;

    @Autowired
    private UserMapper userMapper;

    //将数据转成字符串
    private Gson gson = new Gson();

    @GetMapping("/student")
    public String getStudent(){
        List<Student> students = studentMapper.selectList(null);
        //将查出来的数据转成gson字符串反馈给前端
        return gson.toJson(students);
    }
    //插入数据
    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        studentMapper.insert(student);
    }
        //String student = "{\"id\":142,\"number\":11234,\"name\":\"小李子\",\"age\":14,\"chi\":78,\"math\":99,\"eng\":93}";
        //把gson类型转换成student类型
        //Student student1 = gson.fromJson(student, Student.class);
    //删除数据
    @PostMapping("/delete")
    public void deleteStudent(@RequestBody Student student) {
        studentMapper.deleteById(student);
    }
    //修改数据
    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        studentMapper.updateById(student);
    }

    @PostMapping("/login")
    public String loginStudent(@RequestBody User user) {
        //去数据库里查，若存在则返回值不是null
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.setEntity(user);
        User user_selected = userMapper.selectOne(userQueryWrapper);
        if (user_selected == null) {
            return "0";
        }
        return "1";
    }

    @PostMapping("/register")
    public void register(@RequestBody User user){
        userMapper.insert(user);
    }

    @PostMapping("/search")
    public String searchStudent(@RequestBody HashMap<String, String> data){
        String name = data.get("name");
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<Student>();
        studentQueryWrapper.like("name",name);
        //select * from student where name like '%字%’
        List<Student> students = studentMapper.selectList(studentQueryWrapper);
        return gson.toJson(students);
    }
}
