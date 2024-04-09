package blackjack.model;

public class Player {

	private final PlayerName name;
	private final PlayerMoney money;

	public Player(String name, int money) {
		this.name = new PlayerName(name);
		this.money = new PlayerMoney(money);
	}

	public String getName() {
		return name.getName();
	}

	public int getMoney() {
		return money.getMoney();
	}
}
