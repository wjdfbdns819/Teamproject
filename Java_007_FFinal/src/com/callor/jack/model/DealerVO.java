package com.callor.jack.model;

public class DealerVO {

	// 딜러가 뽑은 카드가 담길 VO ( = 딜러 카드 덱 List)

	private String cardDShap; // 카드 모양

	private Integer dPoint; // 값

	public String getCardDShap() {
		return cardDShap;
	}

	public void setCardDShap(String cardDShap) {
		this.cardDShap = cardDShap;
	}

	public Integer getDPoint() {
		return dPoint;
	}

	public void setDPoint(Integer dPoint) {
		this.dPoint = dPoint;
	}

	@Override
	public String toString() {
		return "[ 모양 = " + cardDShap + ", 값 = " + dPoint + "]";
	}
}
