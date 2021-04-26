package com.callor.jack.service.impl;

public class HitServiceImpl extends DeckServiceImpl{
	
	public void dealerHit() {
			
		System.out.println("-".repeat(50));

		while(true) {
			if (this.sumDealerScore() <= 16) { // => 16이하이면 딜러는 카드 한장을 받아야함
				System.out.println();
				System.out.println("[딜러] 카드 덱의 '총합이 16'이하 ");
				System.out.println("[딜러]는 카드를 1장 더 받습니다");
				this.cardDeck("D");
				System.out.println();
				System.out.println("=".repeat(50));
					
					/* :D 확인용 코드
					System.out.println("=".repeat(50));
					System.out.println("[딜러 덱 리스트");
					System.out.println(dealerList.toString());
					System.out.println("-".repeat(50));
					System.out.println("딜러 합 : " + this.sumDealerScore());
					System.out.println("=".repeat(50)); */
					
			} else if(this.sumDealerScore() >= 17) { // => 17이상이면 딜러는 더이상 카드를 받지 않음
				System.out.println();
				System.out.println("[딜러] 카드 덱의 '총합이 17'이상 ");
				System.out.println("[딜러] 덱에 카드를 더이상 추가할 수 없습니다");
				System.out.println();
				System.out.println("-".repeat(50)); 
					
					/* :D 확인용 코드
					System.out.println("=".repeat(50));
					System.out.println("[딜러 덱 리스트");
					System.out.println(dealerList.toString());
					System.out.println("-".repeat(50));
					System.out.println("딜러 합 : " + this.sumDealerScore());
					System.out.println("=".repeat(50)); */ 
					
					break; // => 17이상이면 딜러는 더이상 카드를 받지 않기때문에 
							// => break;를 사용하며 while() 문 빠져나감
				 } 
				
			} // while end  
			
	} // dealerHit end 
	
	@Override
	public void userHit() {
		// TODO 유저 Hit method

		while (true) { // => 유저는 카드를 받을지 말지 선택할수 있음
			System.out.printf("[유저]는 카드를 한장 더 받으시겠습니까?\n");
			System.out.println();
			System.out.println(" Yes : 1 , No : 2");
			System.out.print(">> ");
			String strInput = scan.nextLine(); // 1, 2번만 입력하게 해야함
			
			if(strInput.equals("")) { // 빈칸을 입력할 경우 오류 메세지 보여줌
				System.out.println("-".repeat(50));
				System.out.printf("%28s", "[ 입력 오류 ]\n");
				System.out.printf("%28s", "'빈칸'은 입력할수 없습니다\n");
				System.out.printf("%31s", " '1 or 2' 중에서 선택해주세요\n");
				System.out.println("-".repeat(50));
				continue; // 다시 선택화면으로 돌아가게함
			}
			
			Integer nInput = null;  
			try { 
				nInput = Integer.valueOf(strInput); // 문자열로 받은 값을 정수형으로 변환
				if(nInput > 2 || nInput < 1 ) { // 입력 받은 값이  2보다 크거나 1보다 작을 경우  
												//	오류 메세지를 보여줌
					System.out.println("-".repeat(50));
					System.out.printf("%28s", "[ 입력 오류 ]\n");
					System.out.printf("%31s", " '1 or 2번' 중에서 선택해주세요\n");
					System.out.println("-".repeat(50));
					continue; // 다시 선택화면으로 돌아가게 함
				}
			} catch (Exception e) { // 문자열 또는 문자로 입력할시 오류 메세지를 보여줌
				System.out.println("-".repeat(50));
				System.out.printf("%28s", "[ 입력 오류 ]\n");
				System.out.printf("%28s", "'문자'는 입력할수 없습니다\n");
				System.out.printf("%31s", " '1 or 2' 중에서 선택해주세요\n");
				System.out.println("-".repeat(50));
				continue; // 다시 선택화면으로 돌아가게 함
			}
			if (nInput == 1) { // 입력받은 값이 1일 경우 
				System.out.println("=".repeat(50));
				System.out.println();
				System.out.printf("%30s", "[[ 1번을 입력하셨습니다 ]]\n");
				System.out.printf("%30s","[유저]가 '카드 1장을 추가'했습니다\n");
				System.out.println();
				System.out.println("=".repeat(50));
				this.cardDeck("U"); // cardDeck U이면 52장이 저장된 공용카드 덱에서 한장뽑고 유저 VO에 저장
				
				/* :D 확인용 코드
				System.out.println("유저의 합 : " + this.sumUserScore());
				System.out.println("=".repeat(50)); */
				
			} else if (nInput == 2) { // 입력받은 값이 2일 경우
				System.out.println("=".repeat(50));
				System.out.println();
				System.out.printf("%32s", "[[ 2번을 입력하셨습니다 ]]\n");
				System.out.printf("%30s","[유저]가 카드를 받는것을 거부했습니다.");
				System.out.println();
				System.out.println();
				System.out.println("=".repeat(50));

				/*:D 확인용 코드
				System.out.println("결과를 출력");
				System.out.println(userList.toString());
				System.out.println("유저의 합 : " + this.sumUserScore());
				System.out.println("-".repeat(50)); */
				
				break; // => 유저가 카드를 받는것을 거부했기 때문에
						// => break;를 사용하며 while() 문 빠져나감
			}
			
		} // while end

	} // userHit method end

	public void turnBack() {
		// TODO 카드, 유저, 딜러 List 초기화 method
		// 게임을 다시 시작하면 카드가 누적되지 않게
		// 덱에 담긴 카드를 초기화 시키기 위해서 remoweAll을 사용
		userList.removeAll(userList);
		dealerList.removeAll(dealerList);
		cardList.removeAll(cardList);
	}
	
}