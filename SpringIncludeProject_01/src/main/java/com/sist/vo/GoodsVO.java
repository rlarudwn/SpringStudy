package com.sist.vo;

import lombok.Data;

/*
NO
GOODS_NAME
GOODS_SUB
GOODS_PRICE
GOODS_DISCOUNT
GOODS_FIRST_PRICE
GOODS_DELIVERY
GOODS_POSTER
HIT
 */
@Data
public class GoodsVO {
	private int no, hit, goods_discount;
	private String goods_name, goods_sub, goods_price, goods_first_price, goods_delivery, goods_poster;
}
