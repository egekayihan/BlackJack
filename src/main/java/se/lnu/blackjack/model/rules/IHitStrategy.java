package se.lnu.blackjack.model.rules;

import se.lnu.blackjack.model.Player;

public interface IHitStrategy {
    boolean DoHit(Player a_dealer);
}