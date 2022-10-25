package se.lnu.blackjack;

import se.lnu.blackjack.controller.PlayGame;
import se.lnu.blackjack.model.Game;
import se.lnu.blackjack.view.IView;
import se.lnu.blackjack.view.SimpleView;

public class Program
{

  public static void main(String[] a_args)
  {
  
    Game g = new Game();
    IView v = new SimpleView(); //new SwedishView();
    PlayGame ctrl = new PlayGame(g,v);
    
    while (ctrl.Play());
  }
}