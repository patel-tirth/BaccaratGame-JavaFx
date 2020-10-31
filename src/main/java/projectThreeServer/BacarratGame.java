package projectThreeServer;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;

public class BacarratGame {

	
	ArrayList<Card> playerHand;
	ArrayList<Card> bankerHand;
	
	BaccaratDealer theDealer;
	BaccaratGameLogic gameLogic;
	double currentBet;
	double totalWinnings;
	
	
	// constructor
	public BacarratGame()
	{
		// 
	}
	
	
	
	/* Function to determine if the user won or lost their bet and return the amount won or lost based
      on the current bet */
	public double evaluateWinnings()
	
	{
		theDealer.generateDeck();
		return currentBet;
		
	}
	
	
	
	
	
	
	
}
