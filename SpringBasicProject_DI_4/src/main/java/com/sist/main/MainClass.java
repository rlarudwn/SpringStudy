package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.model.BoardModel;
import com.sist.model.FoodModel;
import com.sist.model.MainModel;
import com.sist.model.MemberModel;
import com.sist.model.RecipeModel;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		BoardModel bModel=app.getBean("board", BoardModel.class);
		bModel.list();
		MemberModel mModel1=app.getBean("member", MemberModel.class);
		mModel1.list();
		MainModel mModel2=app.getBean("main", MainModel.class);
		mModel2.list();
		FoodModel fModel=app.getBean("food", FoodModel.class);
		fModel.list();
		RecipeModel rModel=app.getBean("recipe", RecipeModel.class);
		rModel.list();
	}
}
