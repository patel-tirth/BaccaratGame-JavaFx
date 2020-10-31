package projectThreeServer;

import java.util.ArrayList;
import java.util.Collections;

public class BaccaratDealer {
	ArrayList<Card> deck;
	
	
	BaccaratDealer()
	{
		
	}
	
	// Function to generate a new standard deck of 52 cards where each card is the instance of Card class
	// in ArrayList<Card> deck
	public void generateDeck()
	{
		// generate each suite
		//  generate diamonds
	     deck = new ArrayList<Card>();
//	     String TypeOfCard;
		for(int i = 1 ; i < 14 ; ++i)
		{
			Card diamondCard = new Card("Diamonds",i);
			deck.add(diamondCard);
		}
		// generate hearts
		for(int i = 1 ; i < 14 ; ++i)
		{
			Card heartCard = new Card("Hearts",i);
			deck.add(heartCard);
		}
		// generate Spades
		for(int i = 1 ; i < 14 ; ++i)
		{
			Card spadeCard = new Card("Spades",i);
			deck.add(spadeCard);
		}
		//generate Clubs
		for(int i = 1 ; i < 14 ; ++i)
		{
			Card clubCard = new Card("Clubs",i);
			deck.add(clubCard);
		}
		
	}
	
	
	// Function to deal two cards and return them in ArrayList <Card>
	public ArrayList<Card> dealHand()
	{
		
		ArrayList<Card> hand = new ArrayList<>();
		// we have to deal two cards... so after dealing those two remove them from the deck
		
		Card firstCard = deck.get(0); // get the first card from the deck 
		Card secondCard = deck.get(1); // get the second card  form the deck 
		hand.add(firstCard);       // add the first card to hand
		hand.add(secondCard);  // add the second card to the hand
		deck.remove(0);      // remove the first card from the deck 
		deck.remove(1);      // remove the second card from the deck 
		
		return hand;   // return the hand
		
	}
	
	//Function to draw a single card and return it
	public Card drawOne()
	{
		Card card1 = deck.get(0);   // get the top card
		deck.remove(0);    // remove the top card
		   
		return card1;
		
	}
	
	// Function to create a new deck of 52 cards and shuffle it
	public void shuffleDeck()
	{
		Collections.shuffle(deck); 
		
	}
	
	// Function to return the number of card in this deck at any given time
	public int deckSize()
	{
		return deck.size();
		
	}
}
