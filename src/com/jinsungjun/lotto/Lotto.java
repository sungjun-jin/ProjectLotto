package com.jinsungjun.lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner; 

/*
 * �ζ� ��ȣ�� �����ϴ� ���α׷�
 * 1. �ζ� ���(venus)�� ��Ʈ������ �̵���Ų��
 * 2. ��÷��� �� 3�� �׽�Ʈ �Ѵ�
 * 3. ����÷�� �Ѵ�
 * 4. ��÷ ����� �ֿܼ� ����Ѵ�.
 * 
 * 18.04.09
 */

public class Lotto {
	
	int[] lottoNum = new int[6]; //6���� �ζ� ��ȣ�������� �迭 (���ʽ� ����)
	int i = 0; //lottoNum�� �ε���
	int bonusNum; //���ʽ� ��ȣ
	
	public void doLotto() {
		//�ζ� ��÷�� ������ �޼ҵ�
		
		LottoEquip equip = new LottoEquip(); //�ζ� ���
		YelloBall yello = new YelloBall(); //����� �� 
		BlueBall blue = new BlueBall(); //�Ķ��� ��
		RedBall red = new RedBall(); //������ ��
		GreyBall grey = new GreyBall(); //ȸ�� ��
		GreenBall green = new GreenBall(); //�ʷϻ� ��
		
		Random random = new Random();
		
		equip.getEquipToStage(); //�ζ� ��� ��÷������ �̵�
		equip.testEquip(); //�ζ� ��� �׽�Ʈ
		
		for(int x = 0; x < 6; x++) {
			
			int num = random.nextInt(44) + 1; //1���� 45�� �ζǹ�ȣ�� ����
			
			if(num >= 1 && num <= 10) {
				//1 ~ 10�� ������ ���� ����� ��
				num = yello.generateNum(); //�ζ� ��÷ �� �������� ���� ���Դ��� ���
				lottoNum[i++] = num; //�ζ� ��÷ ��ȣ�� �迭�� ���� �� �ε��� ����
				System.out.println("��ȣ�� : " +  num); //��ȣ ���
				
			} else if(num > 10 && num <= 20) {
				//11 ~ 20�� ������ ���� �Ķ��� ��
				num = blue.generateNum(); //�ζ� ��÷ �� �������� ���� ���Դ��� ���
				lottoNum[i++] = num; //�ζ� ��÷ ��ȣ�� �迭�� ���� �� �ε��� ����
				System.out.println("��ȣ�� : " +  num); //��ȣ ���
				
			} else if(num > 20 && num <= 30) {
				//21 ~ 30�� ������ ���� ������ ��
				num = red.generateNum();
				lottoNum[i++] = num;
				System.out.println("��ȣ�� : " +  num);
				
			} else if(num > 30 && num <= 40) {
				//31 ~ 40�� ������ ���� ȸ�� ��
				num = grey.generateNum();
				lottoNum[i++] = num;
				System.out.println("��ȣ�� : " +  num);
				
			} else {
				//41 ~ 45�� ������ ���� �ʷϻ� ��
				num = green.generateNum();
				lottoNum[i++] = num;
				System.out.println("��ȣ�� : " +  num);
				
			}			
		}
		
		bonusNum = random.nextInt(44) + 1; //1���� 45������ ���ʽ� ��ȣ ��÷
		i = 0; //�迭�� �ε��� �� �ʱ�ȭ

	}

	
	public void showAllNumbers() {
		// ��÷�� ��� ��ȣ�� ����ϴ� �޼ҵ�
		Arrays.sort(lottoNum); //�迭 �������� ����
		System.out.println("");
		System.out.println("-----------------------------------");
		System.out.print("���� ��÷ ��ȣ�� : ");
		for(int num : lottoNum) {
			//�迭 ���
			System.out.print(num + " ");
		}
		System.out.println("+ ���ʽ���ȣ " + bonusNum); //���ʽ� ��ȣ ���
	}
	
	public void compareArray() {
		//��÷�� �ζ� ��ȣ ���� �ߺ��� üũ�ϱ� ���� �޼ҵ�
		boolean isOverlap = false; //�ߺ� ���θ� ��Ÿ���� boolean
		
		for(int i=0;i<lottoNum.length -1;i++) {
			//�������� ������ �̹� �Ǿ������Ƿ� �� ���� ���� �ߺ��Ǵ����� �˻����ָ� �ȴ�.
			if(lottoNum[i] == lottoNum[i+1]) { 
				
				isOverlap = true;
			}
		}
		for(int i=0;i<lottoNum.length;i++) {
			//���ʽ� ��ȣ�� ��÷�� 6���� ��ȣ�� �ߺ��Ǵ��� ����
			if(lottoNum[i] == bonusNum)
				isOverlap = true;
		}		
		if(isOverlap) {
			// �ߺ��� ��ȣ�� �ִٸ�
			System.err.println("��ȣ�� �ߺ� ��÷�Ǿ����ϴ�. ��÷�� �ٽ� �����մϴ�.");
			doLotto(); //�� ��÷ �ǽ�
			showAllNumbers(); //��ȣ ���
			compareArray(); //��˻� (�ǵ�ġ ���� ����Լ�)
		}		
	}		
}

class LottoEquip {
	//�ζ� ���
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
				System.exit(-1); //���α׷� ����
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

// �ζ� ��÷�� ���Ǵ� ������� Ŭ������ �����غ��Ҵ�

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
		} while(num > 45); //��÷ ���ڰ� 45���� ũ�� ����÷�� �����ϰ� ���ڰ� 45���� ������ ������ �������´�
		
		return num; //�ζ� ��÷ ��ȣ�� ��ȯ
		
	}
}