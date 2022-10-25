package se.lnu.blackjack.model;

import se.lnu.blackjack.model.rules.IHitStrategy;
import se.lnu.blackjack.model.rules.INewGameStrategy;
import se.lnu.blackjack.model.rules.RulesFactory;
import se.lnu.blackjack.model.rules.WinStrategy;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private WinStrategy m_winRule;

  public Dealer(RulesFactory a_rulesFactory) {
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_winRule = a_rulesFactory.GetWinRule();
  }

  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(this, a_player);
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      pickCard(a_player, true);
      return true;
    }
    return false;
  }

  public boolean stand(Player m_player) {
    if (m_deck != null) {
      ShowHand();
      while (m_hitRule.DoHit(this)) {
        pickCard(this, true);
      }
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {
    return m_winRule.IsDealerWinner(a_player, this, g_maxScore);
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
      return true;
    }
    return false;
  }

  public void pickCard(Player a_player, boolean visibility){
    Card c = m_deck.GetCard();
    c.Show(visibility);
    a_player.DealCard(c);
  }
}