package blackjack.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {

	@Test
	@DisplayName("카드 값의 합 리턴 : A가 승격되지 않은 경우 & Q는 10으로 계산")
	void computeCardValueNotIncludeAce() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(CardSymbol.HEART, 1));  // 1
		cards.add(new Card(CardSymbol.HEART, 3));  // 3
		cards.add(new Card(CardSymbol.HEART, 12)); // 10

		int sumValue = Computer.computeCardValue(cards);
		assertThat(sumValue).isEqualTo(14);
	}

	@Test
	@DisplayName("카드 값의 합 리턴 : A가 승격된 경우")
	void computeCardValueIncludeAce() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(CardSymbol.HEART, 1));  // 11
		cards.add(new Card(CardSymbol.HEART, 9));  // 9

		int sumValue = Computer.computeCardValue(cards);
		assertThat(sumValue).isEqualTo(20);
	}

	@Test
	@DisplayName("카드 합이 21을 초과하는 경우 버스트")
	void isBust() {
		assertThat(Computer.testCondition(21, sumValue -> sumValue > 21)).isFalse();
		assertThat(Computer.testCondition(22, sumValue -> sumValue > 21)).isTrue();
	}

	@Test
	@DisplayName("카드 합이 21인 경우 블랙잭")
	void isBlackJack() {
		assertThat(Computer.testCondition(21, sumValue -> sumValue == 21)).isTrue();
	}

	@Test
	@DisplayName("카드 합이 17 이상인 경우 스테이")
	void isStay() {
		assertThat(Computer.testCondition(16, sumValue -> sumValue >= 17)).isFalse();
		assertThat(Computer.testCondition(17, sumValue -> sumValue >= 17)).isTrue();
	}

}
