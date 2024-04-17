package blackjack.model;

import java.util.Objects;
import java.util.Random;

public class Card {

	public static final String[] CARDS_VALUE = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	private final CardSymbol symbol;
	private final CardValue value;

	public Card(CardSymbol symbol, int value) {
		this.symbol = symbol;
		this.value = new CardValue(value);
	}

	public Card() {
		this.symbol = CardSymbol.getRandomSymbol();
		this.value = new CardValue(new Random().nextInt(13) + 1);
	}

	public int getValue() {
		return value.getValue();
	}

	public String getInfo() {
		return CARDS_VALUE[getValue() - 1] + symbol.getSymbolName();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Card card = (Card) o;
		return symbol == card.symbol && Objects.equals(value, card.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(symbol, value);
	}
}
