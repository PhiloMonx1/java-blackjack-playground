package blackjack.model;

public abstract class Player {

	public static final int MAX_SCORE = 21;
	private final PlayerName name;
	private Hand hand;

	protected Player(PlayerName name) {
		this.name = name;
		this.hand = new Hand();
	}

	public String getName() {
		return name.getName();
	}

	public String getHandInfo() {
		return hand.getCardsInfo();
	}

	public int getHandScore() {
		return hand.getScore();
	}

	public boolean isBust() {
		return getHandScore() > MAX_SCORE;
	}

	protected void addCard(Card card) {
		hand.addCard(card);
	}
	public abstract void receiveCard(Card card);
}
