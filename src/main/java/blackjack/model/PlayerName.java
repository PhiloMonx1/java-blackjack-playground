package blackjack.model;

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
}
