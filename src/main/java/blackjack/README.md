# 블랙잭

## 기능 요구 사항
블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

- <b>플레이어는 게임을 시작할 때 배팅 금액을 정해야 한다.</b>
- 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
- 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다. 단, 카드를 추가로 뽑아 21을 초과할 경우 배팅 금액을 모두 잃게 된다.
- 처음 두 장의 카드 합이 21일 경우 블랙잭이 되면 베팅 금액의 1.5 배를 딜러에게 받는다. 딜러와 플레이어가 모두 동시에 블랙잭인 경우 플레이어는 베팅한 금액을 돌려받는다.
- 딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고, 17점 이상이면 추가로 받을 수 없다. 딜러가 21을 초과하면 그 시점까지 남아 있던 플레이어들은 가지고 있는 패에 상관 없이 승리해 베팅 금액을 받는다.

## 실행 결과

```
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

pobi의 배팅 금액은?
10000

jason의 배팅 금액은?
20000

딜러와 pobi, jason에게 2장의 나누었습니다.
딜러: 3다이아몬드
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드

딜러는 16이하라 한장의 카드를 더 받았습니다.

딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17

## 최종 수익
딜러: 10000
pobi: 10000 
jason: -20000
```

## 프로그래밍 요구 사항

- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 Google Java Style Guide을 원칙으로 한다.
    - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- else 예약어를 쓰지 않는다.
    - else 예약어를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    - 힌트: if문에서 값을 반환하는 방식으로 구현하면 else 예약어를 사용하지 않아도 된다.
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 컬렉션을 사용한다.
- 모든 원시 값과 문자열을 포장한다
- 줄여 쓰지 않는다(축약 금지).
- 일급 컬렉션을 쓴다.
- 모든 엔티티를 작게 유지한다.
- 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
- 딜러와 플레이어에서 발생하는 중복 코드를 제거해야 한다.

## 기능 목록 및 commit 로그 요구사항
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
    - git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    - 참고문서: AngularJS Commit Message Conventions

#### AngularJS Commit Message Conventions 중
- commit message 종류를 다음과 같이 구분
```
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
```

## 기능 구현
기능을 구현하다 설계가 복잡해지는 것을 경험한 후로 블랙잭 구현에 부담을 느끼게 되었다. 그로 인해 오랜 시간 블랙잭 프로젝트를 방치하게 되었고, 이제는 이전과 같은 집중력과 기억을 가지고 기존 프로젝트를 할 수 없다는 결론을 내렸다.

이런 상황이 지속되면 프로젝트를 생각만 해도 스트레스를 받게 되고, 이는 계속해서 프로젝트를 방치하는 악순환으로 이어지는 것을 경험했다. 그렇기에 스스로 휴식기를 가진 후 처음부터 다시 시작하게 되었다.

### 설계
- Card (객체)
  - 무늬와 숫자를 가진다.
  - 카드의 정보를 리턴한다.
- Deck (일급 컬렉션)
  - 52장의 고유한 카드 덱을 생성한다.
  - 카드 덱을 셔플한다.
  - 카드덱에서 한장을 뽑는다. (뽑은 카드는 덱에서 삭제된다)
- Gamer & Dealer (Player)
  - 이름과 핸드를 가진다.
  - Hand를 관리한다.
- Hand (일급 컬렉션)
  - 카드를 추가한다.
  - 카드의 총합을 계산한다.
- BlackJackGame (유틸)
  - 게임 진행을 관리한다.
  - 승자를 판단한다.
- InputView & OutputView

이번 설계는 [향로님의 깃헙](https://github.com/jojoldu/oop-java) 회고를 보며 직접 따라해보고 GPT 등을 사용해 설계를 했다. 이전 설계가 여전히 오버엔지니어링 된 설계였다는 것을 깨달았다.

가장 중요한 객체는 `Hand`이다. 점수 계산에 대한 책임을 맡기는 것으로 `Card`와 `Deck`는 트럼프 카드의 표본 역할을 유지할 수 있게된다. 또한 `Player` 객체 또한 `Hand`를 관리하는 것으로 역할이 보다 명확해진다. 만약 블랙잭이 아닌 다른 카드게임이 추가된다면 `Hand` 객체를 추상화 해서 카드 게임 규칙에 맞게 인터페이스를 정의해서 사용할 수 있을 것이다.

### 올바른 예외처리
![exception-gamer-name.png](images/exception-gamer-name.png)
해당 이미지는 Gamer의 이름을 '딜러'로 설정했을 때 발생하는 예외이다. 이것 말고 배팅 금액을 10000원 미만으로 설정했을 때도 `IllegalArgumentException`에러가 발생한다.

```java
public class Gamer extends Player {

	private static final String ERROR_MESSAGE_PLAYER_NAME_DEALER = "딜러를 이름으로 설정할 수 없습니다.";
	private static final int MIN_MONEY = 10000;
	private static final String ERROR_MESSAGE_MONEY_NEGATIVE =
			"배팅 금액은" + MIN_MONEY + "원 이상부터 가능합니다.";

	public Gamer(String name, int money) {
		super(new PlayerName(validateName(name)), new PlayerMoney(validateMoney(money)));
	}

	private static String validateName(String name) {
		if (name.equals(Dealer.DEALER_NAME)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_PLAYER_NAME_DEALER);
		}
		return name;
	}

	private static int validateMoney(int money) {
		if (money < MIN_MONEY) {
			throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_NEGATIVE);
		}
		return money;
	}
	//...(생략)
}
```

예외 처리는 `Gamer`에서 하고 있다. 해당 예외처리를 추상 클래스인 `Player`에서 하지 않는 이유는
```java
public class Dealer extends Player {

	public static final int DRAW_MAX_SCORE = 17;
	public static final String DEALER_NAME = "딜러";

	public Dealer() {
		super(new PlayerName(DEALER_NAME), new PlayerMoney(0));
	}
	//...(생략)
}
```
`Dealer`가 생성될 때 예외가 발생하지 않게 하기 위함이었다.

이제 다시 첨부한 이미지를 보면, 사용자는 프로그램을 사용하다가 예외를 맞이해야 한다.
![exception-typo.png](images/exception-typo.png)
심지어 만약 사용자가 배팅 금액을 입력할 때 오타가 발생하면 예외와 함께 프로그램이 종료되는 경험을 가질 수 밖에 없는 구조이다.

![recursion-in-error-handling.png](images/recursion-in-error-handling.png)
```java
public class InputView extends Util {

	private static final String ERROR_MESSAGE_WRONG_INPUT = "'y' 혹은 'n' 만 입력 가능합니다.";
	private static final Scanner scanner = new Scanner(System.in);

	//...(생략)

	public static int askBettingMoney(String playerName) {
		System.out.println(playerName + "의 배팅 금액은?");
		return scanner.nextInt();
	}

	public static boolean askReceiveCard(Player player) {
		if (player instanceof Dealer) {
			return true;
		}

		System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
		String input = scanner.next();
		if (!input.equals("y") && !input.equals("n")) {
			System.out.println(ERROR_MESSAGE_WRONG_INPUT);
			askReceiveCard(player);
		}
		return input.equals("y");
	}
}

```
반면 `askReceiveCard()` 에서는 재귀 호출을 통해 사용자에게 예외 메시지를 알리고, 다시 입력할 수 있도록 하고 있다.

해당 방식으로 예외가 발생해도 사용자에게 피드백과 함께 재입력 기회를 줘 프로그램의 중단 없이 예외처리를 할 수 있다.