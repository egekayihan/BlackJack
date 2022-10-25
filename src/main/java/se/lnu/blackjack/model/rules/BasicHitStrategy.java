package se.lnu.blackjack.model.rules;

import se.lnu.blackjack.model.Player;

class BasicHitStrategy implements IHitStrategy {
    protected final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
      return a_dealer.CalcScore() < g_hitLimit;  
    }
}