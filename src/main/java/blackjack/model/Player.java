package blackjack.model;

public abstract class Player {

	public static final int MAX_SCORE = 21;
	private final PlayerName name;
	private final PlayerMoney money;
	private Hand hand;

	protected Player(PlayerName name, PlayerMoney money) {
		this.name = name;
		this.money = money;
		this.hand = new Hand();
	}

	public String getName() {
		return name.getName();
	}

	public int getMoney() {
		return money.getMoney();
	}

	public String getHandInfo() {
		return hand.getCardsInfo(false);
	}

	protected String getHandInfo(boolean firstCardHidden) {
		return hand.getCardsInfo(firstCardHidden);
	}


	public int getHandScore() {
		return hand.getScore();
	}

	public boolean isFull() {
		return getHandScore() >= MAX_SCORE;
	}

	protected void addCard(Card card) {
		hand.addCard(card);
	}

	public abstract void receiveCard(Card card);
}
