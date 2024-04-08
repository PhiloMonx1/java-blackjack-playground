package blackjack.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	@DisplayName("생성자 테스트")
	void createInstance() {
		Card towHeart = new Card(CardSymbol.HEART, 2);
		assertThat(towHeart.getValue()).isEqualTo(2);
		assertThat(towHeart.getInfo()).isEqualTo("2하트");

		Card aceSpade = new Card(CardSymbol.SPADE, 13);
		assertThat(aceSpade.getValue()).isEqualTo(13);
		assertThat(aceSpade.getInfo()).isEqualTo("K스페이드");

		assertThatIllegalArgumentException()
				.isThrownBy(() -> {
					new Card(CardSymbol.SPADE, 0);
				});

		assertThatIllegalArgumentException()
				.isThrownBy(() -> {
					new Card(CardSymbol.SPADE, 14);
				});
	}
}
