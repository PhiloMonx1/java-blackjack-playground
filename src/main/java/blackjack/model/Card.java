package blackjack.model;

public class Card {

	private final Pattern pattern;
	private final Denomination denomination;

	public Card(Pattern pattern, Denomination denomination) {
		this.pattern = pattern;
		this.denomination = denomination;
	}

	public String getCardInfo() {
		return denomination.getValue() + pattern.getSymbolName();
	}

	public Denomination getDenomination() {
		return denomination;
	}
}
