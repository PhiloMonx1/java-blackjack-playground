package blackjack.model;

public class Gamer extends Player {

	private static final String ERROR_MESSAGE_PLAYER_NAME_DEALER = "딜러를 이름으로 설정할 수 없습니다.";
	private final PlayerMoney money;

	public Gamer(String name, int money) {
		super(new PlayerName(validateName(name)));
		this.money = new PlayerMoney(money);
	}

	private static String validateName(String name) {
		if (name.equals(Dealer.DEALER_NAME)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_PLAYER_NAME_DEALER);
		}
		return name;
	}

	public int getMoney() {
		return money.getMoney();
	}

	@Override
	public void receiveCard(Card card) {
		addCard(card);
	}
}
