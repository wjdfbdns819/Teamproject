package com.callor.jack.model;

public class UserVO {

	// 유저가 뽑은 카드가 담길 VO (= 유저 카드 덱 List)

	private String cardUShap; // 카드 모양

	private Integer UPoint; // 값

	public String getCardUShap() {
		return cardUShap;
	}

	public void setCardUShap(String cardUShap) {
		this.cardUShap = cardUShap;
	}

	public Integer getUPoint() {
		return UPoint;
	}

	public void setUPoint(Integer uPoint) {
		UPoint = uPoint;
	}

	@Override
	public String toString() {
		return "[ 모양 = " + cardUShap + ", 값 = " + UPoint + "]";
	}

}
