package com.baomidou.ant.meng.entity;

import java.time.LocalDate;
import com.baomidou.ant.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author cat
 * @since 2018-11-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Employee extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer eid;

    private String ename;

    private String mobile;

    private String sex;

    private LocalDate birthday;



}
