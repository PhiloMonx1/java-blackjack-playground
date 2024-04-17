package blackjack.model;

import java.util.Objects;

public class PlayerName {
	private static final String ERROR_MESSAGE = "이름은 빈 값일 수 없습니다.";
	final String name;

	public PlayerName(String name) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PlayerName that = (PlayerName) o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
