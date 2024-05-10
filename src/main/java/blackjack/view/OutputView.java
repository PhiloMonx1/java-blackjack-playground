package blackjack.view;

import blackjack.model.Player;
import blackjack.model.Util;
import java.util.List;

public class OutputView extends Util {

	private OutputView() {
		super();
	}

	public static void printPlayersHand(List<Player> players) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Player player : players) {
			stringBuilder.append(getPlayerHand(player));
			stringBuilder.append("\n");
		}
		System.out.println(stringBuilder);
	}

	private static String getPlayerHand(Player player) {
		return player.getName() + " 카드: " + player.getHandInfo() + " - 결과: " + player.getHandScore();
	}

	public static void printDistributeCards(List<Player> players) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Player player : players) {
			stringBuilder.append(player.getName() + ", ");
		}
		System.out.println(stringBuilder.append("에게 2장의 카드를 나누어 주었습니다."));
	}

	public static void printResult(List<Player> players) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("## 최종 수익");
		stringBuilder.append("\n");

		for (Player player : players) {
			stringBuilder.append(player.getName() + ": " + player.getMoney() + "\n");
		}
		System.out.println(stringBuilder);
	}

	public static void dealerDrawCardMassage(String message) {
		System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
	}
}
