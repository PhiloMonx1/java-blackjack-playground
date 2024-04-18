package blackjack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CardDeck {

	private final static String DECK_IS_EMPTY = "덱에 카드가 없습니다.";
	private List<Card> cards;

	public CardDeck() {
		this.cards = new ArrayList<>();
		cards = initializeDeck();
		Collections.shuffle(cards);
	}

	private List<Card> initializeDeck() {
		return Arrays.stream(CardSymbol.values())
				.flatMap(symbol -> IntStream.rangeClosed(CardValue.MIN, CardValue.MAX)
						.mapToObj(i -> new Card(symbol, i)))
				.collect(Collectors.toList());
	}

	public Card drawCard() {
		if (cards.isEmpty()) {
			throw new IllegalStateException(DECK_IS_EMPTY);
		}
		return cards.remove(0);
	}

	public int getSize() {
		return cards.size();
	}

	public boolean contains(Card card) {
		return cards.contains(card);
	}
}
