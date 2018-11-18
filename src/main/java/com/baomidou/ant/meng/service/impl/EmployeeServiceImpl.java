package com.baomidou.ant.meng.service.impl;

import com.baomidou.ant.meng.entity.Employee;
import com.baomidou.ant.meng.mapper.EmployeeMapper;
import com.baomidou.ant.meng.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cat
 * @since 2018-11-18
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
