/*
라이브러리 vs 프레임워크
	라이브러리(자바, Jsoup...)
		자주 사용되는 기능을 모아서 미리 구현해 둔 클래스의 집합
		자유롭게 사용 가능
	프레임워크
		개발에 필요한 기능을 미리 구현해 둔 클래스의 집합
			기본툴이 만들어져 있다(틀안에서만 사용 가능)
	대표적인 프레임워크
		1. MyBatis
		2. Ajax, React	=> 이미 사용법이 만들어져 있다
		3. Spring/Spring-Boot
		
	프레임워크 장점
	단점
		=> 기능이 많다(전체 기능을 다루기 어렵다)
			Spring-Boot
			Spring Framework
			Spring Security
			Spring Betch
			Spring Data
			Spring Cloud
		=> 무겁다(실행 속도가 느리다)
		=> 학습해야되는 라이브러리가 많다
	Spring에서 사용되는 기능 준비
		Database
			JDBC / ORM
			ORM : 관계형 데이터베이스	=> MyBatis / JPA / Hibernate
		Web : MVC	=> Controller가 이미 제작
		Core
			Container : 클래스를 모아서 관리
				개발자 등록(클래스) : VO클래스	=> 사용자정의 데이터형	=> 관리대상에서 제외
				지정된 형식에 맞게 사용
					클래스 등록
						XML 이용	=> Spring 4 / Spring 5	=> 자바 이용
							<bean id="aa" class="com.sist.main.AA"/>
						어노테이션 이용
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
						
					일반 스프링	=> ApplicationContext
					웹	=> WebApplicationContext
					어노테이션	=> AnnotationConfigApplicationContext
			DI : Setter / Constructor
				스프링을 통해 멤버변수 초기화
			AOP	: 공통 모듈(공통적으로 사용되는 기능을 모아 자동 호출)
			
			class A{
			}
			class B{
			}
			class C{
			}
			<bean id="a" class"A"/>
			<bean id="b" class"B"/>
			<bean id="c" class"C"/>
			
			A aa=컨테이너.getBean("a")
													====> id명
			=> System.gc()	=> 메모리 해제
			
			생명주기
				class읽기
				클래스 메모리 할당
				setter를 이용해 초기화
				==================================> Spring 담당
				개발자 사용
				==================================> 개발자 담당
				클래스 메모리 해제
				==================================> Spring 담당
				
			DI : 모든 클래스에 적용
					초기화
						setter DI
						생성자 DI
						method DI	=> 객체 생성시 / 객체 소멸시
													init-method		destroy-method
			AOP : Transaction / Security
 */
package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// 컨테이너에 XML 파싱 요청
		ApplicationContext app=new ClassPathXmlApplicationContext("app1.xml");
		// 필요한 객체 요청
		Board board=(Board)app.getBean("board");
		System.out.println("b="+board);
		Board board2=app.getBean("board", Board.class); // generic	=> 자동 형변환
		System.out.println("b1="+board2);
		// 필요에 따라 메소드 호출 후 요청
		board.insert();
		board.list();
	}
}
