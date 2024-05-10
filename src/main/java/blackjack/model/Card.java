package blackjack.model;

public class Card {

	private Pattern pattern;
	private Denomination denomination;

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
