package blackjack.model;

import java.util.Objects;

class CardValue {

	private static final String ERROR_MESSAGE = "카드의 값은 1~13 사이의 정수여야 합니다.";
	private final int value;

	CardValue(int value) {
		if (value < 1 || value > 13) {
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
