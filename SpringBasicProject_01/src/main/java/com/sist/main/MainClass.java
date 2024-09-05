/*
���̺귯�� vs �����ӿ�ũ
	���̺귯��(�ڹ�, Jsoup...)
		���� ���Ǵ� ����� ��Ƽ� �̸� ������ �� Ŭ������ ����
		�����Ӱ� ��� ����
	�����ӿ�ũ
		���߿� �ʿ��� ����� �̸� ������ �� Ŭ������ ����
			�⺻���� ������� �ִ�(Ʋ�ȿ����� ��� ����)
	��ǥ���� �����ӿ�ũ
		1. MyBatis
		2. Ajax, React	=> �̹� ������ ������� �ִ�
		3. Spring/Spring-Boot
		
	�����ӿ�ũ ����
	����
		=> ����� ����(��ü ����� �ٷ�� ��ƴ�)
			Spring-Boot
			Spring Framework
			Spring Security
			Spring Betch
			Spring Data
			Spring Cloud
		=> ���̴�(���� �ӵ��� ������)
		=> �н��ؾߵǴ� ���̺귯���� ����
	Spring���� ���Ǵ� ��� �غ�
		Database
			JDBC / ORM
			ORM : ������ �����ͺ��̽�	=> MyBatis / JPA / Hibernate
		Web : MVC	=> Controller�� �̹� ����
		Core
			Container : Ŭ������ ��Ƽ� ����
				������ ���(Ŭ����) : VOŬ����	=> ��������� ��������	=> ������󿡼� ����
				������ ���Ŀ� �°� ���
					Ŭ���� ���
						XML �̿�	=> Spring 4 / Spring 5	=> �ڹ� �̿�
							<bean id="aa" class="com.sist.main.AA"/>
						������̼� �̿�
							@Component("a")	=> id
							class A{
							}
						BeanFactory
								|
						ApplicationContext
								|	=> WebApplicationContext
						---------------------------------------------------
						|																									|
						AnnotationConfigApplicationContext						GenericXmlApplicationContext
							Core / AOP / Annotation													Core / AOP / CLOSE
						
					�Ϲ� ������	=> ApplicationContext
					��	=> WebApplicationContext
					������̼�	=> AnnotationConfigApplicationContext
			DI : Setter / Constructor
				�������� ���� ������� �ʱ�ȭ
			AOP	: ���� ���(���������� ���Ǵ� ����� ��� �ڵ� ȣ��)
			
			class A{
			}
			class B{
			}
			class C{
			}
			<bean id="a" class"A"/>
			<bean id="b" class"B"/>
			<bean id="c" class"C"/>
			
			A aa=�����̳�.getBean("a")
													====> id��
			=> System.gc()	=> �޸� ����
			
			�����ֱ�
				class�б�
				Ŭ���� �޸� �Ҵ�
				setter�� �̿��� �ʱ�ȭ
				==================================> Spring ���
				������ ���
				==================================> ������ ���
				Ŭ���� �޸� ����
				==================================> Spring ���
				
			DI : ��� Ŭ������ ����
					�ʱ�ȭ
						setter DI
						������ DI
						method DI	=> ��ü ������ / ��ü �Ҹ��
													init-method		destroy-method
			AOP : Transaction / Security
 */
package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// �����̳ʿ� XML �Ľ� ��û
		ApplicationContext app=new ClassPathXmlApplicationContext("app1.xml");
		// �ʿ��� ��ü ��û
		Board board=(Board)app.getBean("board");
		System.out.println("b="+board);
		Board board2=app.getBean("board", Board.class); // generic	=> �ڵ� ����ȯ
		System.out.println("b1="+board2);
		// �ʿ信 ���� �޼ҵ� ȣ�� �� ��û
		board.insert();
		board.list();
	}
}
