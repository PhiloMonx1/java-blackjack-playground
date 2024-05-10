package blackjack.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {

	private static final int SOFT_ACE = 11;
	private List<Card> cards;

	public Hand() {
		cards = new LinkedList<>();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public String getCardsInfo() {
		return cards.stream()
				.map(Card::getCardInfo)
				.collect(Collectors.joining(", "));
	}

	public int getScore() {
		int score = 0;

		for (Card card : cards) {
			Denomination denomination = card.getDenomination();
			score += denomination.getScore();
		}

		return adjustScoreForAces(score);
	}

	private int adjustScoreForAces(int score) {
		if (isAce() && score <= SOFT_ACE) {
			score += 10;
		}
		return score;
	}

	private boolean isAce() {
		return cards.stream().anyMatch(card -> card.getDenomination() == Denomination.ACE);
	}
}
