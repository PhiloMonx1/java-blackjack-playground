package blackjack.model;

public enum Pattern {
	HEART("하트"), DIAMOND("다이아몬드"), CLUB("클로버"), SPADE("스페이드");
	private final String symbol;

	Pattern(String symbol) {
		this.symbol = symbol;
	}

	String getSymbolName() {
		return symbol;
	}
}
