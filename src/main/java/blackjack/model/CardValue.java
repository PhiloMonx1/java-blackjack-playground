package blackjack.model;

class CardValue {

	private final int value;

	CardValue(int value) {
		if (value < 1 || value > 13) {
			throw new IllegalArgumentException("카드의 값은 1~13 사이의 정수여야 합니다.");
		}
		this.value = value;
	}

	int getValue() {
		return value;
	}
}
