package blackjack.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Computer extends Util {

	public Computer() {
		super();
	}

	public static Map<Player, Integer> settleBettingMoney(List<Player> players) {
		Map<Player, Integer> finalProfits = new HashMap<>();

		Dealer dealer = findDealer(players);
		List<Gamer> gamers = findGamers(players);
		finalProfits.put(dealer, 0);

		for (Gamer gamer : gamers) {
			int profit = calculatePlayerProfit(gamer, dealer);
			finalProfits.put(gamer, profit);
		}

		int dealerProfit = finalProfits.values().stream().mapToInt(Integer::intValue).sum();
		finalProfits.put(dealer, -dealerProfit);
		return finalProfits;
	}

	private static Dealer findDealer(List<Player> players) {
		return (Dealer) players.stream()
				.filter(Dealer.class::isInstance)
				.findFirst()
				.orElse(null);
	}

	private static List<Gamer> findGamers(List<Player> players) {
		return players.stream()
				.filter(Gamer.class::isInstance)
				.map(Gamer.class::cast)
				.collect(Collectors.toList());
	}

	private static int calculatePlayerProfit(Player gamer, Dealer dealer) {
		int gamerScore = gamer.getHandScore();
		int dealerScore = dealer.getHandScore();
		int gamerMoney = gamer.getMoney();

		boolean isGamerBust = gamerScore > 21;
		boolean isDealerBust = dealerScore > 21;
		boolean isGamerWin = (gamerScore > dealerScore && !isGamerBust) || isDealerBust;
		boolean isDealerWin = (dealerScore > gamerScore && !isDealerBust) || isGamerBust;

		if (isGamerWin) {
			return gamerMoney;
		}
		if (isDealerWin) {
			return -gamerMoney;
		}
		return 0;
	}
}
