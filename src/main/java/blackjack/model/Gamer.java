package blackjack.model;

public class Gamer extends Player {

	private static final String ERROR_MESSAGE_PLAYER_NAME_DEALER = "딜러를 이름으로 설정할 수 없습니다.";
	private static final int MIN_MONEY = 10000;
	private static final String ERROR_MESSAGE_MONEY_NEGATIVE = "배팅 금액은" + MIN_MONEY + "원 이상부터 가능합니다.";

	public Gamer(String name, int money) {
		super(new PlayerName(validateName(name)), new PlayerMoney(validateMoney(money)));
	}

	private static String validateName(String name) {
		if (name.equals(Dealer.DEALER_NAME)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_PLAYER_NAME_DEALER);
		}
		return name;
	}

	private static int validateMoney(int money) {
		if (money < MIN_MONEY) {
			throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_NEGATIVE);
		}
		return money;
	}

	@Override
	public void receiveCard(Card card) {
		addCard(card);
	}
}
