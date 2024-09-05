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
		System.out.print("1. 곡명 검색, 2. 가수 검색, 3. 앨범 검색");
		int no=sc.nextInt();
		System.out.print("검색어 입력");
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
		System.out.println("======================검색 결과======================");
		for(MusicVO vo:list) {
			System.out.println("곡명 : "+vo.getTitle());
			System.out.println("가수명 : "+vo.getSinger());
			System.out.println("앨범명 : "+vo.getAlbum());
			System.out.println("===================================================");
		}
	}
}
