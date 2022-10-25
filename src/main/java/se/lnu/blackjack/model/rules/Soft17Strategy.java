package se.lnu.blackjack.model.rules;

import se.lnu.blackjack.model.Card;
import se.lnu.blackjack.model.Player;

public class Soft17Strategy extends BasicHitStrategy {
    // In case of playing soft 17, checking for card Ace in delar's hand.
    @Override
    public boolean DoHit(Player a_dealer) {
        if (a_dealer.CalcScoreWithoutAce() == g_hitLimit) {
            for (Card c : a_dealer.GetHand()) {
                if (c.GetValue() == Card.Value.Ace) {
                    return true;
                }
            }
        }
        return super.DoHit(a_dealer);
    }
}
