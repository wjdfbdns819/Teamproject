package com.callor.jack.service.impl;

public class MenuServiceImpl extends RuleServiceImpl {

	public void selectMenu() {
		// TODO 메뉴 method
		while (true) {
			System.out.println("=".repeat(50));
			System.out.printf("%38s", "[[ This is Black Jack ]]\n");
			System.out.println("-".repeat(50));

			System.out.printf("%33s", "[[ Main Menu ]]\n");

			System.out.printf("%32s", "1. Game Start\n");
			System.out.printf("%26s", "2. Help\n");
			System.out.printf("%26s", "3. Exit\n");
			System.out.println("-".repeat(50));
			System.out.print(">> ");
			String strInput = scan.nextLine();

			if (strInput.equals("")) {
				System.out.printf("%29s", "[ 입력 오류 ]\n");
				System.out.printf("%29s", "'빈칸'은 입력할수 없습니다\n");
				System.out.printf("%32s", "메뉴는 1 ~ 3번 중에서 선택해주세요\n");
				System.out.println();
				continue;
			}

			Integer nInput = null;
			try {
				nInput = Integer.valueOf(strInput); 
				if (nInput > 3 || nInput < 1) {
					System.out.printf("%29s", "[ 메뉴 선택 오류 ]\n");
					System.out.printf("%31s", "메뉴는 1 ~ 3번 중에서 선택해주세요\n");
					System.out.println();
					continue;
				}

			} catch (NumberFormatException e) {
				System.out.printf("%27s", "[ 입력 오류 ]\n");
				System.out.printf("%28s", "'문자'는 입력할수 없습니다\n");
				System.out.printf("%32s", "메뉴는 1 ~ 3번 중에서 선택해주세요\n");
				System.out.println();
				continue;
			}

			if (nInput == 1) {
				System.out.printf("%30s", "[[ 1번을 입력하셨습니다 ]]\n");
				System.out.printf("%32s", " [ Game Start ]\n");
				System.out.println("=".repeat(50));

				this.getCard();
				System.out.println("=".repeat(50));
				System.out.println();
				System.out.printf("%28s", "카드 배분이 끝났습니다\n");
				System.out.println();
				System.out.println("=".repeat(50));
				this.dealerHit();
				this.userHit();
				this.bust();
				this.turnBack();
				continue;

			} else if (strInput.equals("2")) {
				System.out.printf("%30s", "[[ 2번을 입력하셨습니다 ]]\n");
				System.out.printf("%29s", " [ Help ]\n");
				this.help();
				continue;

			} else if (strInput.equals("3")) {
				System.out.printf("%30s", "[[ 3번을 입력하셨습니다 ]]\n");
				System.out.printf("%28s", "게임을 종료합니다. :D");
				
			}
			return;

		} // while end

	} // selectMenu end
	
	public void help() {
		while (true) {
			System.out.println("=".repeat(50));
			System.out.printf("%31s\n", "BlackJack rule");
			System.out.println("-".repeat(50));
			System.out.println("딜러와 플레이어의 1:1 승부");
			System.out.println("카드는 조커를 제외한 총 52장의 카드가 있다.");
			System.out.println("딜러와 플레이어가 각 카드를 2장씩받는다.");
			System.out.println("중복된 카드는 없습니다.");
			System.out.println("더보기 : Enter, 메뉴화면 : < ( 1 / 2 )");
			System.out.print(">> ");
			String strInput = scan.nextLine();

			if (strInput.equals("<")) {
				System.out.println("=".repeat(50));
				System.out.println("메뉴화면입니다.");
				System.out.println("1 ~ 3를 선택해주세요.");
				this.selectMenu();

			} else if (strInput.equals("")) {

				System.out.println("받은 카드의 점수 합이 21 초과시 죽는다.");
				System.out.println("21에 가까운 사람이 이기거나 ");
				System.out.println("둘중 21을 초과하지 않고 높은 사람이 이깁니다.");
				System.out.println("딜러는 2장을 받고 17점 미만일 경우");
				System.out.println("자동으로 카드를 한장 더 건네 받습니다.");
				System.out.println("플레이어는 제약없이 원하면 카드를 계속 건네받을 수 있습니다.");
				System.out.println("메뉴화면 : Enter ( 2 / 2 )");
				System.out.println("=".repeat(50));
				System.out.println("도움말이 끝났습니다.");
				System.out.println("메뉴 1 ~ 3를 선택해주세요.");
			}
			break;
		}
		

	}

}