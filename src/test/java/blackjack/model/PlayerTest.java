package blackjack.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	@DisplayName("플레이어 생성자 테스트")
	void createInstance() {
		Player pobi = new Player("pobi", 10000);

		assertThat(pobi.getName()).isEqualTo("pobi");
		assertThat(pobi.getMoney()).isEqualTo(10000);
	}
}
