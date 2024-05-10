package blackjack.model;

public class PlayerMoney {

	private static final int MIN_MONEY = 10000;
	private static final String ERROR_MESSAGE_MONEY_NEGATIVE = "배팅 금액은" + MIN_MONEY + "원 이상부터 가능합니다.";
	private final int money;

	public PlayerMoney(int money) {
		if (money < MIN_MONEY) {
			throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_NEGATIVE);
		}
		this.money = money;
	}

	public int getMoney() {
		return money;
	}
}
