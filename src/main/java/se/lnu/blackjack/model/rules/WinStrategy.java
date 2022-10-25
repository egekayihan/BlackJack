package se.lnu.blackjack.model.rules;

import se.lnu.blackjack.model.Player;

public interface WinStrategy {
    boolean IsDealerWinner(Player a_player, Player a_dealer, int g_maxScore);
}
