package se.lnu.blackjack.model.rules;

import se.lnu.blackjack.model.Dealer;
import se.lnu.blackjack.model.Player;

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Dealer a_dealer, Player a_player) {

    a_dealer.pickCard(a_player, true);

    a_dealer.pickCard(a_dealer, true);

    a_dealer.pickCard(a_player, true);

    return true;
  }
}