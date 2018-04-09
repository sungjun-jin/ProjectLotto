package com.jinsungjun.lotto;

public class LottoMain {
	//로또 메인
	public static void main(String[] args) {
		
		Lotto lotto = new Lotto();
		lotto.doLotto(); //추첨		
		lotto.showAllNumbers(); //출력
		lotto.compareArray(); //중복비교		
	}
}
