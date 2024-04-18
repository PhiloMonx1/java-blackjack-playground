package blackjack.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CardDeckTest {

	@Test
	@DisplayName("생성될 때 52장의 카드가 존재하는지 테스트")
	void createCardDeckTest() {
		CardDeck cardDeck = new CardDeck();
		assertThat(cardDeck.getSize()).isEqualTo(52);
	}

	@Test
	@DisplayName("카드를 드로우 했을 때 해당 카드가 사리지며 Size가 줄어드는지 테스트")
	void drawCardTest() {
		CardDeck cardDeck = new CardDeck();
		Card card = cardDeck.drawCard();

		assertThat(cardDeck.contains(card)).isFalse();
		assertThat(cardDeck.getSize()).isEqualTo(51);
	}
}
