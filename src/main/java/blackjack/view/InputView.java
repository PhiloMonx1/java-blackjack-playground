package blackjack.view;

import blackjack.model.Dealer;
import blackjack.model.Player;
import blackjack.model.Util;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView extends Util {

	private static final String MESSAGE_ASK_PLAYER_NAME = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
	private static final String MESSAGE_ASK_BETTING_MONEY = "의 배팅 금액은?";
	private static final String MESSAGE_ASK_HIT = "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
	private static final String ERROR_MESSAGE_PLAYER_NAME_DEALER = "'딜러'가 포함된 이름은 설정할 수 없습니다.";
	private static final int MIN_MONEY = 10000;
	private static final String ERROR_MESSAGE_MONEY_NEGATIVE = "배팅 금액은" + MIN_MONEY + "원 이상의 금액으로 입력해주세요.";
	private static final String ERROR_MESSAGE_WRONG_INPUT = "'y' 혹은 'n' 만 입력 가능합니다.";
	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {
		super();
	}

	public static List<String> gameStart() {
		System.out.println(MESSAGE_ASK_PLAYER_NAME);
		String names = validateName(scanner.next());

		return Arrays.stream(names.split(","))
				.map(String::trim)
				.collect(Collectors.toList());
	}

	private static String validateName(String input) {
		if (input.contains(Dealer.DEALER_NAME)) {
			System.out.println(ERROR_MESSAGE_PLAYER_NAME_DEALER);
			gameStart();
		}
		return input;
	}

	public static int askBettingMoney(String playerName) {
		System.out.println(playerName + MESSAGE_ASK_BETTING_MONEY);
		int money = validateMoney(scanner.next(), playerName);

		if (money < MIN_MONEY) {
			System.out.println(ERROR_MESSAGE_MONEY_NEGATIVE);
			askBettingMoney(playerName);
		}

		return money;
	}

	private static int validateMoney(String input, String playerName) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println(ERROR_MESSAGE_MONEY_NEGATIVE);
			return askBettingMoney(playerName);
		}
	}

	public static boolean askReceiveCard(Player player) {
		if (player.isFull()) {
			return false;
		}

		if (player instanceof Dealer) {
			return true;
		}

		System.out.println(player.getName() + MESSAGE_ASK_HIT);
		String input = validateInput(scanner.next(), player);

		return input.equals("y");
	}

	private static String validateInput(String input, Player player) {
		if (!input.equals("y") && !input.equals("n")) {
			System.out.println(ERROR_MESSAGE_WRONG_INPUT);
			askReceiveCard(player);
		}
		return input;
	}
}
