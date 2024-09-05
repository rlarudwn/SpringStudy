package com.sist.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.config.DataBaseConfig;
import com.sist.config.MusicConfig;
import com.sist.dao.MusicDAO;
import com.sist.vo.MusicVO;

public class MainClass {
	public static void main(String[] args) {
		Class[] cls={MusicConfig.class, DataBaseConfig.class};
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(cls);
		MusicDAO dao=app.getBean("dao", MusicDAO.class);
		List<MusicVO> list=dao.musicListData();
		for(MusicVO vo:list) {
			System.out.println(vo.getMno()+". "+vo.getTitle());
		}
		System.out.println("=========================================");
		Scanner sc=new Scanner(System.in);
		System.out.print("1. ��� �˻�, 2. ���� �˻�, 3. �ٹ� �˻�");
		int no=sc.nextInt();
		System.out.print("�˻��� �Է�");
		String fd=sc.next();
		List<MusicVO> fList=new ArrayList<MusicVO>();
		if(no==1) {
			fList=dao.musicTitleFindData(fd);
		}
		else if(no==2) {
			fList=dao.musicSingerFindData(fd);
		}
		else if(no==3) {
			fList=dao.musicAlbumFindData(fd);
		}
		System.out.println("======================�˻� ���======================");
		for(MusicVO vo:list) {
			System.out.println("��� : "+vo.getTitle());
			System.out.println("������ : "+vo.getSinger());
			System.out.println("�ٹ��� : "+vo.getAlbum());
			System.out.println("===================================================");
		}
	}
}
