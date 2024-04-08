package blackjack.model;

public class Card {

	public static final String[] CARDS_VALUE = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	private final CardSymbol symbol;
	private final CardValue value;

	public Card(CardSymbol symbol, int value) {
		this.symbol = symbol;
		this.value = new CardValue(value);
	}

	public int getValue() {
		return value.getValue();
	}

	public String getInfo() {
		return CARDS_VALUE[getValue() - 1] + symbol.getSymbolName();
	}
}
