package blackjack.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardsTest {

	private Cards cards;
	private Player player;

	@BeforeEach
	void setUp() {
		cards = new Cards();
		player = new Player("pobi", 1000);

		cards = cards.add(new Card(CardSymbol.CLUB, 1), player);
		cards = cards.add(new Card(CardSymbol.DIAMOND, 13), player);
		// Player 객체는 이름만 동일해도 동일한 객체로 인식
		cards = cards.add(new Card(CardSymbol.HEART, 9), new Player("pobi", 2000));
		cards = cards.add(new Card(CardSymbol.SPADE, 12), new Player("crong", 1000));
	}

	@Test
	@DisplayName("플레이어의 카드 리스트 카드 정보를 나열해서 리턴")
	void getPlayerCardsInfo() {
		String result = cards.getPlayerCardsInfo(player);
		assertThat(result).isEqualTo("A클로버, K다이아몬드, 9하트");
	}

	@Test
	@DisplayName("플레이어의 카드 리스트 카드 값을 합산하여 리턴")
	void getPlayerCardsSumValue() {
		int result = cards.getPlayerCardsSumValue(player);
		assertThat(result).isEqualTo(20);
	}
}
