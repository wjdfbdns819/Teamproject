package com.callor.jack.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.jack.model.DealerVO;
import com.callor.jack.model.UserVO;
import com.callor.jack.service.TotalService;

public class DeckServiceImpl implements TotalService {

	// 인터페이스 구현
	// 각 변수를 선언

	protected ArrayList<String> cardList; // 카드 52장을 저장할 List

	protected List<UserVO> userList; // 유저가 뽑은 카드가 저장될 List
	protected List<DealerVO> dealerList; // 딜러가 뽑은 카드가 저장될 List

	protected Random rnd;
	protected Scanner scan;

	public DeckServiceImpl() {
		// TODO 각 변수를 초기화

		cardList = new ArrayList<String>();

		userList = new ArrayList<UserVO>();
		dealerList = new ArrayList<DealerVO>();

		rnd = new Random();
		scan = new Scanner(System.in);

	}

	public void cardDeck(String flag) { //딜러 플레이어 VO 판단을 하기위해 flag 매개변수
		
		// 카드 52장 생성하고 유저,딜러가 뽑은 카드를 각 VO에 저장하는 method
		String pattern[] = { "heart", "spade", "clover", "dia" };
		String cardnum[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < cardnum.length; j++) {
				cardList.add(pattern[i] + ":" + cardnum[j]);
			}
		}

		String card;
		Integer cardscore;
		int num = rnd.nextInt(cardList.size());
		card = cardList.get(num);
		cardList.remove(num);
		String cardp[] = card.split(":");
		if (cardp[1].equals("A")) {
			cardscore = 1;
		} else if (cardp[1].equals("J")) {
			cardscore = 10;
		} else if (cardp[1].equals("Q")) {
			cardscore = 10;
		} else if (cardp[1].equals("K")) {
			cardscore = 10;
		} else {
			cardscore = Integer.valueOf(cardp[1]);
		}

		if ("D".equals(flag)) { // 딜러
			DealerVO dVO = new DealerVO();
			dVO.setCardDShap(card);
			dVO.setDPoint(cardscore);
			dealerList.add(dVO);

		} else if ("U".equals(flag)) { // 플레이어
			UserVO uVO = new UserVO();
			uVO.setCardUShap(card);
			uVO.setUPoint(cardscore);
			userList.add(uVO);
		}
	}

	@Override
	public void getCard() {
		// TODO 첫 시작시 딜러, 유저에게 각각 카드 2장을 주는 method
		System.out.printf("%28s", "먼저 카드 2장을\n");
		System.out.printf("%29s", "유저, 딜러 순으로 나눠주겠습니다\n");
		System.out.println("=".repeat(50));
		System.out.println();

		for (int i = 1; i < 3; i++) {

			System.out.printf("[유저]에게 '%d번째' 카드를 주었습니다\n", i);
			this.cardDeck("U"); 

			System.out.printf("[딜러]에게 '%d번째' 카드를 주었습니다\n", i);
			this.cardDeck("D");

		}
		/* 확인용 코드 :D
		System.out.println("=".repeat(50));
		System.out.println("[유저 덱 list]");
		System.out.println(userList.toString() + "\t");
		System.out.println("유저 덱 총합 : " + this.sumUserScore());
		System.out.println("-".repeat(50));
		System.out.println("[딜러 덱 list]");
		System.out.println(dealerList.toString() +"\t");
		System.out.println("딜러 덱 총합 : " + this.sumDealerScore());
		System.out.println("-".repeat(50)); */
	}

	@Override
	public Integer sumDealerScore() {
		// TODO 딜러 덱에 들어있는 카드 총점 계산 method
		Integer sumDealer = 0;
		for (DealerVO vo : dealerList) {
			sumDealer += vo.getDPoint();
		}
		return sumDealer;
	}

	@Override
	public Integer sumUserScore() {
		// TODO 유저 덱에 들어있는 카드 총점 계산 method

		Integer sumUser = 0;
		for (UserVO vo : userList) {
			sumUser += vo.getUPoint();
		}
		return sumUser;
	}

	// HitServiceImpl에서 구현할 method
	public void dealerHit() {
		// TODO Auto-generated method stub

	}
	@Override
	public void userHit() {
		// TODO 유저 Hit method

	}
	public void turnBack() {
	}
	
	// RuleSeriveImpl에서 구현할 method
	@Override
	public void bust() {
		// TODO Auto-generated method stub

	}
	
	// MenuServiceImpl에서 구현할 method
	@Override
	public void selectMenu() {
		// TODO Auto-generated method stub

	}
	@Override
	public void help() {
		// TODO Auto-generated method stub

	}

}