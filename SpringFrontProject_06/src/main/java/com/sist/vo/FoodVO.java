package com.sist.vo;

import lombok.Data;

@Data
public class FoodVO {
	private int fno, hit;
	private String name, type, phone, address, theme, poster, images, time, parking, content;
	private double socre;
}
