package blackjack.model;

public class Dealer extends Player {

	public static final int DRAW_MAX_SCORE = 17;
	public static final String DEALER_NAME = "딜러";

	public Dealer() {
		super(new PlayerName(DEALER_NAME));
	}

	@Override
	public void receiveCard(Card card) {
		if (getHandScore() < DRAW_MAX_SCORE) {
			addCard(card);
		}
	}
}
