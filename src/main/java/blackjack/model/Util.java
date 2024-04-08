package blackjack.model;

public abstract class Util {
	private final static String INFORMATION = "는 유틸리티 클래스입니다.";
	protected Util() {
		throw new IllegalStateException(this.getClass().getSimpleName() + INFORMATION);
	}
}
