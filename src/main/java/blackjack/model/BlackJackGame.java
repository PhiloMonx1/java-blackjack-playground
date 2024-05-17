package blackjack.model;

import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BlackJackGame {

	private Map<Player, Boolean> participants;
	private Deck deck;

	public BlackJackGame() {
		this.deck = new Deck();
		this.participants = new LinkedHashMap<>();
	}

	public void play() {
		addPlayers();
		List<Player> players = getPlayersToParticipants();
		distributeCardAllPlayer(players);
		boolean isDealerBust = false;

		while (!allPlayersTurnPass() && !isDealerBust) {
			isDealerBust = askDealerBust(players);
			receiveCardAllPlayer();
			isPlayersFull(players);
		}

		gameResult(players);
	}

	private void addPlayers() {
		participants.put(new Dealer(), false);

		List<String> names = InputView.gameStart();
		for (String name : names) {
			participants.put(new Gamer(name, InputView.askBettingMoney(name)), false);
		}
	}

	private List<Player> getPlayersToParticipants() {
		return participants.keySet().stream().collect(Collectors.toList());
	}

	private void distributeCardAllPlayer(List<Player> players) {
		OutputView.printDistributeCards(players);
		for (Player player : players) {
			player.receiveCard(deck.draw());
			player.receiveCard(deck.draw());
		}
		OutputView.printPlayersHand(players);
	}

	private void receiveCardAllPlayer() {
		List<Player> players = getPlayersToParticipants();

		players.stream()
				.filter(player -> !participants.get(player))
				.forEach(this::processPlayerDecision);

		OutputView.printPlayersHand(players);
	}

	private void processPlayerDecision(Player player) {
		if (InputView.askReceiveCard(player)) {
			player.receiveCard(deck.draw());
		} else {
			playerStay(player);
		}
	}

	private void isPlayersFull(List<Player> players) {
		players.stream()
				.filter(Player::isFull)
				.forEach(this::playerStay);
	}

	private boolean allPlayersTurnPass() {
		return participants.values().stream().allMatch(Boolean::booleanValue);
	}

	private void gameResult(List<Player> players) {
		Map<Player, Integer> playerProfits = Computer.settleBettingMoney(players);
		OutputView.printPlayersHand(players, true);
		OutputView.printResult(playerProfits);
	}

	private void playerStay(Player player) {
		participants.put(player, true);
	}

	private boolean askDealerBust(List<Player> players) {
		return players.stream()
				.anyMatch(this::askDealerBust);
	}

	private boolean askDealerBust(Player player) {
		if (player instanceof Dealer) {
			return ((Dealer) player).isBust();
		}
		return false;
	}
}
