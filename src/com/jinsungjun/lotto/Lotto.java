package com.jinsungjun.lotto;

import java.util.Arrays;
import java.util.Random; 

/*
 * �ζ� ��ȣ�� �����ϴ� Ŭ����
 * 18.04.09
 */

public class Lotto {
	
	int[] lottoNum = new int[7];
	int i = 0; //lottoNum�� �ε���
	int bonusNum; //���ʽ� ��ȣ
	
	public void doLotto() {
		
		LottoEquip equip = new LottoEquip();
		YelloBall yello = new YelloBall(); //����� �� 
		BlueBall blue = new BlueBall(); //�Ķ��� ��
		RedBall red = new RedBall(); //������ ��
		GreyBall grey = new GreyBall(); //ȸ�� ��
		GreenBall green = new GreenBall(); //�ʷϻ� ��
		
		Random random = new Random();
		
		equip.getEquipToStage();
		equip.testEquip();
		
		for(int x = 0; x < 7; x++) {
			
			int num = random.nextInt(44) + 1; //1���� 45�� �ζǹ�ȣ�� ����
			
			if(num >= 1 && num <= 10) {
				
				num = yello.generateNum();
				lottoNum[i++] = num;
				System.out.println("��ȣ�� : " +  num);
				
			} else if(num > 10 && num <= 20) {
				
				num = blue.generateNum();
				lottoNum[i++] = num;
				System.out.println("��ȣ�� : " +  num);
				
			} else if(num > 20 && num <= 30) {
				
				num = red.generateNum();
				lottoNum[i++] = num;
				System.out.println("��ȣ�� : " +  num);
				
			} else if(num > 30 && num <= 40) {
				
				num = grey.generateNum();
				lottoNum[i++] = num;
				System.out.println("��ȣ�� : " +  num);
				
			} else {
				
				num = green.generateNum();
				lottoNum[i++] = num;
				System.out.println("��ȣ�� : " +  num);
				
			}			
		}
		
		bonusNum = random.nextInt(44) + 1; //1���� 45������ ���ʽ� ��ȣ ��÷
		i = 0; 
	}
		
	
	public void showAllNumbers() {
		
		Arrays.sort(lottoNum);
		System.out.println("");
		System.out.println("-----------------------------------");
		System.out.print("���� ��÷ ��ȣ�� : ");
		for(int num : lottoNum) {
			
			System.out.print(num + " ");
		}
		System.out.println("+ ���ʽ���ȣ " + bonusNum);
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
			System.err.println("��ȣ�� �ߺ� ��÷�Ǿ����ϴ�. ��÷�� �ٽ� �����մϴ�.");
			doLotto();
			showAllNumbers();
			compareArray();
		}		
	}		
}

class LottoEquip {
	
	private String name = "Venus ��÷��";
	private int weight = 200; //kg
	private int height = 220; //cm
	private int radius = 50; //cm
	
	Random random = new Random(); // ��� �׽�Ʈ�� ���� ���� ���� Ŭ����
	
	public void getEquipToStage() {
		
		System.out.println("�ζ� ��÷ ��� ��Ʈ������ �̵��Ǿ����ϴ�.");
		System.out.println("");
	}
	
	public void testEquip() {
		
		for(int i=0;i<3;i++) { //�� 3���� �׽�Ʈ�� �����Ѵ�.
			
			int num = random.nextInt(10);
			
			if(num != 0) {
				System.out.println("Test" + (i+1) + " -> ��÷����� �׽�Ʈ�� ���������� �Ϸ�Ǿ����ϴ�.");
				if(i == 2)
					System.out.println("");
			} else {
				System.err.println("��÷��� ������ �߻��Ͽ����ϴ�, ��� ������ �ּ���");	
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
	private String Color = "���";
	
	Random random = new Random(); //�ζ� ��ȣ ���⿡ ���Ǵ� Random Ŭ����
	
	public int generateNum() {
		
		System.out.println(Color + "���� ���� ��÷�Ǿ����ϴ�.");
		return random.nextInt(10) + 1; //nextInt��  0 ~ 9�̹Ƿ� 1~10�� ������ ���߱� ���ؼ��� +1�� ���ش�
	}
}

class BlueBall {
	
	//11 ~ 20
	private int weight = 4;
	private float radius = 4.5F; //cm
	private String Color = "�Ķ�";
	
	Random random = new Random(); //�ζ� ��ȣ ���⿡ ���Ǵ� Random Ŭ����
	
	public int generateNum() {
		
		System.out.println(Color + "���� ���� ��÷�Ǿ����ϴ�.");
		return random.nextInt(10) + 11; //nextInt(10)�� 0���� 9�̹Ƿ� 11~20�� ������ ���߱� ���ؼ� +11�� ���ش�	
	}
}

class RedBall {
	
	//21 ~ 30
	private int weight = 4;
	private float radius = 4.5F; //cm
	private String Color = "����";
	
	Random random = new Random(); //�ζ� ��ȣ ���⿡ ���Ǵ� Random Ŭ����
	
	public int generateNum() {
		
		System.out.println(Color + "���� ���� ��÷�Ǿ����ϴ�.");
		return random.nextInt(10) + 21;
	}
}

class GreyBall {
	
	//31 ~ 40
	private int weight = 4;
	private float radius = 4.5F; //cm
	private String Color = "ȸ";
	
	Random random = new Random(); //�ζ� ��ȣ ���⿡ ���Ǵ� Random Ŭ����
	
	public int generateNum() {
		
		System.out.println(Color + "���� ���� ��÷�Ǿ����ϴ�.");
		return random.nextInt(10) + 31;
	}
}

class GreenBall {
	//41 ~ 45
	private int weight = 4;
	private float radius = 4.5F;
	private String Color = "�ʷ�";
	
	Random random = new Random(); //�ζ� ��ȣ ���⿡ ���Ǵ� Random Ŭ����
	
	public int generateNum() {
		
		System.out.println(Color + "���� ���� ��÷�Ǿ����ϴ�.");
		int num = 0;
		
		do {
			num = random.nextInt(45) + 41;
		}while(num > 45); //num�� 45���� ũ�� ����÷�� �����ϰ� num�� 45���� ������ ������ �������´�
		
		return num; //�ζ� ��÷ ��ȣ�� ��ȯ
		
	}
}