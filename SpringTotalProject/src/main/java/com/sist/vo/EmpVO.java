package com.sist.vo;

import lombok.Data;
import java.util.*;
@Data
public class EmpVO {
	private int empno, sal, deptno;
	private String ename, job, dbday;
	private Date hiredate;
}
