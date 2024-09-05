package com.sist.main;
/*

1. core : 객체 생성	=> 객체 소멸, 객체 관리
										객체 생명주기	=> 컨테이너(경량 컨테이너)	=> 클래스 관리자
2. aop : 공통 기능을 모아 자동으로 처리
		oop를 보완한 프로그램
		====> 객체지향 프로그램
3. Data Access : JDBC / ORM / OXM / JMS
																		===> message service
															===> XML 파싱
												=== MyBatis / Hibernate / JPA
4. WEB : MVC
	기타 : Spring Data(빅데이터 분석)
				Spring Security
				Spring Cloud
				Spring AI
					=> 엘레스틱서치 : 검색엔진
	DI는 모든 스프링의 기본	=> 필수 조건
		Spring : 클래스 관리자 (생성~소멸)
			=> 프로그램에 맞게 클래스를 관리
			=> 다른 프레임워크와 호환성이 좋다
			=> 바로 걷어낼 수 있다
			=> Spring4 : XML기반 / Spring5 : Annotation기반(순수 자바, 보안 중시)
	DI	=> 클래스 저장해서 관리하는 컨테이너 클래스
						=> 스프링에서 지원하는 컨테이너(클래스 1개 : 컴포넌트/빈)
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
