package com.sist.vo;

import lombok.Data;

/*
FNO	NUMBER
NAME	VARCHAR2(500 BYTE)
TYPE	VARCHAR2(100 BYTE)
PHONE	VARCHAR2(50 BYTE)
ADDRESS	VARCHAR2(300 BYTE)
SCORE	NUMBER(2,1)
THEME	CLOB
POSTER	VARCHAR2(500 BYTE)
IMAGES	CLOB
TIME	VARCHAR2(50 BYTE)
PARKING	VARCHAR2(500 BYTE)
CONTENT	CLOB
RDAYS	VARCHAR2(300 BYTE)
JJIMCOUNT	NUMBER
LIKECOUNT	NUMBER
HIT	NUMBER
 */
@Data
public class FoodVO {
	private int fno, jjimcount, likecount, hit;
	private String name, poster, type, phone, address, theme, images, time, parking, content, rdays;
	private double score;
}
