package org.py.mymodule.submodule.service.impl;

import org.py.mymodule.submodule.entity.Student;
import org.py.mymodule.submodule.mapper.StudentMapper;
import org.py.mymodule.submodule.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2022-08-05
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
