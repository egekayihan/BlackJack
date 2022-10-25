package se.lnu.blackjack.view;


import se.lnu.blackjack.model.Card;

public interface IView
{
  public enum Option {
    NEWGAME,
    HIT,
    QUIT,
    STAND;
  }
  void DisplayWelcomeMessage();
  Option userInput();
  void CreateNewView();
  void DisplayCard(Card a_card);
  void DisplayPlayerHand(Iterable<Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);

}