package blackjack.view;

import blackjack.model.Player;
import blackjack.model.Util;
import java.util.List;
import java.util.Map;

public class OutputView extends Util {
	private static final String SEPARATOR = "\n";
	private static final String MESSAGE_DISTRIBUTE_CARD = "에게 2장의 카드를 나누어 주었습니다.\"";
	private static final String MESSAGE_DEALER_DRAW = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
	private static final String MESSAGE_FINAL_PROFIT = "## 최종 수익";
	private static final String CARD = " 카드: ";
	private static final String RESULT = " - 결과: ";
	private static final String REST = ", ";
	private static final String COLON = ": ";



	private OutputView() {
		super();
	}

	public static void printPlayersHand(List<Player> players) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Player player : players) {
			stringBuilder.append(getPlayerHand(player));
			stringBuilder.append(SEPARATOR);
		}
		System.out.println(stringBuilder);
	}

	private static String getPlayerHand(Player player) {
		return player.getName() + CARD + player.getHandInfo() + RESULT
				+ player.getHandScore();
	}

	public static void printDistributeCards(List<Player> players) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Player player : players) {
			stringBuilder.append(player.getName() + REST);
		}
		System.out.println(stringBuilder.append(MESSAGE_DISTRIBUTE_CARD));
	}

	public static void printResult(Map<Player, Integer> playerProfits) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(MESSAGE_FINAL_PROFIT);
		stringBuilder.append(SEPARATOR);

		for (Map.Entry<Player, Integer> playerProfit : playerProfits.entrySet()) {
			stringBuilder.append(getFinalProfit(playerProfit));
		}
		System.out.println(stringBuilder);
	}

	private static String getFinalProfit(Map.Entry<Player, Integer> playerProfit) {
		Player player = playerProfit.getKey();
		int profit = playerProfit.getValue();

		return player.getName() + COLON + profit + SEPARATOR;
	}

	public static void dealerDrawCardMassage() {
		System.out.println(MESSAGE_DEALER_DRAW);
	}
}
