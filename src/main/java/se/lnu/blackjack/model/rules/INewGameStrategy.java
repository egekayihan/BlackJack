package se.lnu.blackjack.model.rules;

import se.lnu.blackjack.model.Dealer;
import se.lnu.blackjack.model.Player;

public interface INewGameStrategy {
    boolean NewGame(Dealer a_dealer, Player a_player);
}