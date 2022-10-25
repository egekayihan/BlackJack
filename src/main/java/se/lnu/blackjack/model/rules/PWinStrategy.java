package se.lnu.blackjack.model.rules;

import se.lnu.blackjack.model.Player;

public class PWinStrategy implements WinStrategy {
    @Override
    public boolean IsDealerWinner(Player a_player, Player a_dealer, int g_maxScore) {
        if (a_player.CalcScore() > g_maxScore) {
            return true;
        } else if (a_dealer.CalcScore() > g_maxScore) {
            return false;
        }
        return a_dealer.CalcScore() > a_player.CalcScore();
    }
    }

