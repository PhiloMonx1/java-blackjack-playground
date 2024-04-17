package blackjack.model;

import java.util.HashMap;
import java.util.Map;

public class Cards {

	private final Map<Card, Player> cards;

	Cards(Map<Card, Player> cards) {
		this.cards = cards;
	}

	public Cards() {
		this(new HashMap<>());
	}

	public Cards drawCard(Player player) {
		Map<Card, Player> copiedCards = new HashMap<>(this.cards);
		copiedCards.put(new Card(), player);
		return new Cards(copiedCards);
	}
}