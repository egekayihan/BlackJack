package se.lnu.blackjack.controller;

import se.lnu.blackjack.model.Game;
import se.lnu.blackjack.model.Observable;
import se.lnu.blackjack.view.IView;

public class PlayGame implements Observable {
    private Game a_game;
    private IView a_view;

    public PlayGame(Game a_game, IView a_view) {
        this.a_game = a_game;
        this.a_view = a_view;
        Subscribe(this);
    }

    public boolean Play() {
        this.a_view.DisplayWelcomeMessage();
        IView.Option input = a_view.userInput();
        switch (input) {
            case NEWGAME:
                a_game.NewGame();
                break;
            case HIT:
                a_game.Hit();
                break;
            case STAND:
                a_game.Stand();
                break;
            default:
                break;
        }
        return input != IView.Option.QUIT;
    }

    @Override
    public void PlayerGetNewCard() {
        try {
            a_view.CreateNewView();
            a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
            a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

            if (a_game.IsGameOver()) {
                a_view.DisplayGameOver(a_game.IsDealerWinner());
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void Subscribe(Observable a_subscriber) {
        this.a_game.AddSubscribers(a_subscriber);
    }
}