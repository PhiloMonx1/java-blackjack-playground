package blackjack.model;

import java.util.List;
import java.util.function.Predicate;

public class Computer extends Util {

	private Computer() {
		super();
	}

	public static int computeCardValue(List<Card> cards) {
		int sum = sumCardValue(cards);
		if (hasAce(cards) && sum <= 11) {
			return sum + 10;
		}
		return sum;
	}

	private static int sumCardValue(List<Card> cards) {
		return cards.stream()
				.mapToInt(card -> Math.min(card.getValue(), 10))
				.sum();
	}

	private static boolean hasAce(List<Card> cards) {
		return cards.stream()
				.anyMatch(card -> card.getValue() == 1);
	}

	public static boolean testCondition(int sumValue, Predicate<Integer> predicate) {
		return predicate.test(sumValue);
	}
}
