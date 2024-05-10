package blackjack.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class Deck {

	private Stack<Card> cards;

	public Deck() {
		cards = generateCards();
		Collections.shuffle(cards);
	}

	private Stack<Card> generateCards() {
		return Arrays.stream(Pattern.values())
				.flatMap(pattern -> Arrays.stream(Denomination.values())
						.map(denomination -> new Card(pattern, denomination)))
				.collect(Collectors.toCollection(Stack::new));
	}

	public Card draw() {
		return cards.pop();
	}
}
