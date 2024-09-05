package com.sist.vo;

import lombok.Data;

@Data
public class FoodVO {
	private int fno, jjimcount, likecount, hit;
	private String name, poster, type, phone, address, theme, images, time, parking, content, rdays;
	private double score;
}