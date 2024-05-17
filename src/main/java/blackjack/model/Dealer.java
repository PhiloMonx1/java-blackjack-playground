package blackjack.model;

public class Dealer extends Player {

	public static final int DRAW_MAX_SCORE = 17;
	public static final String DEALER_NAME = "딜러";
	private boolean gameEnded;

	public Dealer() {
		super(new PlayerName(DEALER_NAME), new PlayerMoney(0));
		this.gameEnded = false;
	}

	@Override
	public String getHandInfo() {
		return super.getHandInfo(!gameEnded);
	}

	@Override
	public void receiveCard(Card card) {
		if (getHandScore() < DRAW_MAX_SCORE) {
			addCard(card);
		}
	}

	@Override
	public boolean isFull() {
		return super.isFull() || isDrawMaxScore();
	}

	private boolean isDrawMaxScore() {
		return getHandScore() >= DRAW_MAX_SCORE;
	}

	public void gameEnd() {
		this.gameEnded = true;
	}
}
