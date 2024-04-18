package blackjack.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cards {

	private final Map<Card, Player> cards;

	Cards(Map<Card, Player> cards) {
		this.cards = cards;
	}

	public Cards() {
		this(new HashMap<>());
	}

	public Cards add(Card card, Player player) {
		Map<Card, Player> copiedCards = new LinkedHashMap<>(this.cards);
		copiedCards.put(card, player);
		return new Cards(copiedCards);
	}

	public String getPlayerCardsInfo(Player player) {
		return getPlayerCards(player).stream()
				.map(Card::getInfo)
				.collect(Collectors.joining(", "));
	}

	public int getPlayerCardsSumValue(Player player) {
		return Computer.computeCardValue(getPlayerCards(player));
	}

	private List<Card> getPlayerCards(Player player) {
		return cards.entrySet().stream()
				.filter(entry -> entry.getValue().equals(player))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}
}