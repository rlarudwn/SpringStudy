package com.sist.vo;

import lombok.Data;

@Data
public class PokeVO {
	private int no, pno, gen, likecount;
	private String comm, name, name_eng, type1, type2, height, weight, species, ability1, form, poster, ability2;
}
