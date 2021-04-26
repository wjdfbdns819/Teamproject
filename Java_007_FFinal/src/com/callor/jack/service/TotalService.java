package com.callor.jack.service;

public interface TotalService {

	// 인터페이스 선언

	// DeckServiceImpl에서 구현할 method
	public void cardDeck(String flag); 
	// => 카드 52장 생성하고 유저,딜러가 뽑은 카드를 각 VO에 저장하는 method

	public void getCard(); // 첫 시작시 딜러, 유저에게 각각 카드 2장을 주는 method

	public Integer sumDealerScore(); // 딜러 덱에 들어있는 카드 총점 계산 method

	public Integer sumUserScore(); // 유저 덱에 들어있는 카드 총점 계산 method

	// HitServiceImpl에서 구현할 method
	public void dealerHit(); // 딜러 Hit(카드를 한장 받는) method

	public void userHit(); // 유저 Hit method

	public void turnBack(); // 카드, 유저, 딜러 List 초기화 method

	// RuleServiceImpl에서 구현할 method
	public void bust(); // 승패, 결과 도출하는 method

	// MenuServiceImpl에서 구현할 method
	public void selectMenu(); // 메뉴 method

	public void help(); // 도움말 method

}