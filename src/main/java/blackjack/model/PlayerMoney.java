package blackjack.model;

public class PlayerMoney {

	private static final int MIN_MONEY = 1000;
	private static final String ERROR_MESSAGE = "배팅 금액은" + MIN_MONEY + "이상이어야 합니다.";
	final int money;

	public PlayerMoney(int money) {
		if (money < MIN_MONEY) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		this.money = money;
	}

	public int getMoney() {
		return money;
	}
}
