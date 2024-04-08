package blackjack.model;

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
}
