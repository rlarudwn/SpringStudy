package com.sist.main;
/*

1. core : ��ü ����	=> ��ü �Ҹ�, ��ü ����
										��ü �����ֱ�	=> �����̳�(�淮 �����̳�)	=> Ŭ���� ������
2. aop : ���� ����� ��� �ڵ����� ó��
		oop�� ������ ���α׷�
		====> ��ü���� ���α׷�
3. Data Access : JDBC / ORM / OXM / JMS
																		===> message service
															===> XML �Ľ�
												=== MyBatis / Hibernate / JPA
4. WEB : MVC
	��Ÿ : Spring Data(������ �м�)
				Spring Security
				Spring Cloud
				Spring AI
					=> ������ƽ��ġ : �˻�����
	DI�� ��� �������� �⺻	=> �ʼ� ����
		Spring : Ŭ���� ������ (����~�Ҹ�)
			=> ���α׷��� �°� Ŭ������ ����
			=> �ٸ� �����ӿ�ũ�� ȣȯ���� ����
			=> �ٷ� �Ⱦ �� �ִ�
			=> Spring4 : XML��� / Spring5 : Annotation���(���� �ڹ�, ���� �߽�)
	DI	=> Ŭ���� �����ؼ� �����ϴ� �����̳� Ŭ����
						=> ���������� �����ϴ� �����̳�(Ŭ���� 1�� : ������Ʈ/��)
								BeanFactory
											|
							ApplicationContext
											|
						WebApplicationContext
											|
	=============================================
	|																						|
GenericXmlApplicationContext			AnnotationConfigApplicationContext
 */

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=app.getBean("dao", EmpDAO.class);
		List<EmpVO> list= dao.empListData();
	}
}
