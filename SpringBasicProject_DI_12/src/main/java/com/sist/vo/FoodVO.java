package com.sist.vo;

import lombok.Data;

@Data
public class FoodVO {
	private int fno;
	private String name, address, phone, theme, time, parking, type;
	private double score;
}
