package blackjack.model;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Player player = (Player) o;
		return Objects.equals(name, player.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
