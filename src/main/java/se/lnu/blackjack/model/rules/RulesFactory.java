package se.lnu.blackjack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new BasicHitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
  public WinStrategy GetWinRule(){
    return new PWinStrategy();
  }
}