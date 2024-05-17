package blackjack.model;

public class Gamer extends Player {
	public Gamer(String name, int money) {
		super(new PlayerName(name), new PlayerMoney(money));
	}

	@Override
	public String getHandInfo(boolean isGameEnded) {
		return super.getHandInfo();
	}

	@Override
	public void receiveCard(Card card) {
		addCard(card);
	}
}
