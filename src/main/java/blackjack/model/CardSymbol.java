package blackjack.model;

import java.util.Random;

enum CardSymbol {
	HEART("하트"), DIAMOND("다이아몬드"), CLUB("클로버"), SPADE("스페이드");
	private final String symbolName;

	CardSymbol(String symbolName) {
		this.symbolName = symbolName;
	}

	String getSymbolName() {
		return symbolName;
	}

	public static CardSymbol getRandomSymbol() {
		Random random = new Random();
		CardSymbol[] symbols = CardSymbol.values();
		return symbols[random.nextInt(symbols.length)];
	}
}
