package com.jinsungjun.lotto;

import java.util.Arrays;
import java.util.Random; 

/*
 * 로또 번호를 생성하는 클래스
 * 18.04.09
 */

public class Lotto {
	
	int[] lottoNum = new int[7];
	int i = 0; //lottoNum의 인덱스
	int bonusNum; //보너스 번호
	
	public void doLotto() {
		
		LottoEquip equip = new LottoEquip();
		YelloBall yello = new YelloBall(); //노란색 공 
		BlueBall blue = new BlueBall(); //파란색 공
		RedBall red = new RedBall(); //빨간색 공
		GreyBall grey = new GreyBall(); //회색 공
		GreenBall green = new GreenBall(); //초록색 공
		
		Random random = new Random();
		
		equip.getEquipToStage();
		equip.testEquip();
		
		for(int x = 0; x < 7; x++) {
			
			int num = random.nextInt(44) + 1; //1부터 45의 로또번호가 지정
			
			if(num >= 1 && num <= 10) {
				
				num = yello.generateNum();
				lottoNum[i++] = num;
				System.out.println("번호는 : " +  num);
				
			} else if(num > 10 && num <= 20) {
				
				num = blue.generateNum();
				lottoNum[i++] = num;
				System.out.println("번호는 : " +  num);
				
			} else if(num > 20 && num <= 30) {
				
				num = red.generateNum();
				lottoNum[i++] = num;
				System.out.println("번호는 : " +  num);
				
			} else if(num > 30 && num <= 40) {
				
				num = grey.generateNum();
				lottoNum[i++] = num;
				System.out.println("번호는 : " +  num);
				
			} else {
				
				num = green.generateNum();
				lottoNum[i++] = num;
				System.out.println("번호는 : " +  num);
				
			}			
		}
		
		bonusNum = random.nextInt(44) + 1; //1부터 45까지의 보너스 번호 추첨
		i = 0; 
	}
		
	
	public void showAllNumbers() {
		
		Arrays.sort(lottoNum);
		System.out.println("");
		System.out.println("-----------------------------------");
		System.out.print("최종 추첨 번호는 : ");
		for(int num : lottoNum) {
			
			System.out.print(num + " ");
		}
		System.out.println("+ 보너스번호 " + bonusNum);
	}
	
	public void compareArray() {
		boolean isOverlap = false;
		
		for(int i=0;i<lottoNum.length -1;i++) {
			
			if(lottoNum[i] == lottoNum[i+1]) {
				
				isOverlap = true;
			}
		}
		for(int i=0;i<lottoNum.length;i++) {
			
			if(lottoNum[i] == bonusNum)
				isOverlap = true;
		}		
		if(isOverlap) {			
			System.err.println("번호가 중복 추첨되었습니다. 추첨을 다시 진행합니다.");
			doLotto();
			showAllNumbers();
			compareArray();
		}		
	}		
}

class LottoEquip {
	
	private String name = "Venus 추첨기";
	private int weight = 200; //kg
	private int height = 220; //cm
	private int radius = 50; //cm
	
	Random random = new Random(); // 장비 테스트를 위한 난수 생성 클래스
	
	public void getEquipToStage() {
		
		System.out.println("로또 추첨 장비가 세트장으로 이동되었습니다.");
		System.out.println("");
	}
	
	public void testEquip() {
		
		for(int i=0;i<3;i++) { //총 3번의 테스트를 진행한다.
			
			int num = random.nextInt(10);
			
			if(num != 0) {
				System.out.println("Test" + (i+1) + " -> 추첨장비의 테스트가 성공적으로 완료되었습니다.");
				if(i == 2)
					System.out.println("");
			} else {
				System.err.println("추첨장비에 오류가 발생하였습니다, 장비를 수리해 주세요");	
				System.exit(-1);
				return;
				
			}
		}		
	}			
}

class YelloBall {
	
	//1 ~ 10
	private int weight = 4; //g
	private float radius = 4.5F; //cm
	private String Color = "노란";
	
	Random random = new Random(); //로또 번호 추출에 사용되는 Random 클래스
	
	public int generateNum() {
		
		System.out.println(Color + "색의 공이 추첨되었습니다.");
		return random.nextInt(10) + 1; //nextInt는  0 ~ 9이므로 1~10의 범위를 맞추기 위해서는 +1을 해준다
	}
}

class BlueBall {
	
	//11 ~ 20
	private int weight = 4;
	private float radius = 4.5F; //cm
	private String Color = "파란";
	
	Random random = new Random(); //로또 번호 추출에 사용되는 Random 클래스
	
	public int generateNum() {
		
		System.out.println(Color + "색의 공이 추첨되었습니다.");
		return random.nextInt(10) + 11; //nextInt(10)은 0부터 9이므로 11~20의 범위를 맞추기 위해선 +11을 해준다	
	}
}

class RedBall {
	
	//21 ~ 30
	private int weight = 4;
	private float radius = 4.5F; //cm
	private String Color = "빨간";
	
	Random random = new Random(); //로또 번호 추출에 사용되는 Random 클래스
	
	public int generateNum() {
		
		System.out.println(Color + "색의 공이 추첨되었습니다.");
		return random.nextInt(10) + 21;
	}
}

class GreyBall {
	
	//31 ~ 40
	private int weight = 4;
	private float radius = 4.5F; //cm
	private String Color = "회";
	
	Random random = new Random(); //로또 번호 추출에 사용되는 Random 클래스
	
	public int generateNum() {
		
		System.out.println(Color + "색의 공이 추첨되었습니다.");
		return random.nextInt(10) + 31;
	}
}

class GreenBall {
	//41 ~ 45
	private int weight = 4;
	private float radius = 4.5F;
	private String Color = "초록";
	
	Random random = new Random(); //로또 번호 추출에 사용되는 Random 클래스
	
	public int generateNum() {
		
		System.out.println(Color + "색의 공이 추첨되었습니다.");
		int num = 0;
		
		do {
			num = random.nextInt(45) + 41;
		}while(num > 45); //num이 45보다 크면 재추첨을 시작하고 num이 45보다 작으면 루프를 빠져나온다
		
		return num; //로또 추첨 번호를 반환
		
	}
}