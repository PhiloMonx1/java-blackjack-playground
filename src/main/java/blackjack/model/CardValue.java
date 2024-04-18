package blackjack.model;

import java.util.Objects;

class CardValue {

	private static final String ERROR_MESSAGE = "카드의 값은 1~13 사이의 정수여야 합니다.";
	public static final int MIN = 1;
	public static final int MAX = 13;
	private final int value;

	CardValue(int value) {
		if (value < MIN || value > MAX) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		this.value = value;
	}

	int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CardValue cardValue = (CardValue) o;
		return value == cardValue.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
