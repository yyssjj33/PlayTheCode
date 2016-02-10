package ood;

import java.util.Random;

class Card {
	int suit;
	int rank;
	public Card(int suit, int rank){
		this.suit = suit;
		this.rank = rank;
	}
	public String toString(){
		if (suit == 0)
			return ("["+"C, "+rank+"]");
		else if (suit == 1)
			return "["+"D, "+rank+"]";
		else if (suit == 2)
			return "["+"H, "+rank+"]";
		else if (suit == 3)
			return "["+"S, "+rank+"]";
		return "";
	}
}
public class DeckOfCard {
	

	
	private static final int CLUB = 0;
	private static final int DIAMOND = 1;
	private static final int HEART = 2;
	private static final int SPADE = 3;
	private Card[] deckOfCards;
	private int currentCard;
	public DeckOfCard(){
		deckOfCards = new Card[52];
		currentCard = 0;
		int c = 0;
		for (int i = CLUB; i <= SPADE; i++){
			for (int j = 1; j <= 13; j++){
				deckOfCards[c++] = new Card(i,j);
			}
		}
	}
	
	public String toString(){
		StringBuilder out = new StringBuilder();
		int c = 0;
		for (int i = CLUB; i <= SPADE; i++){
			for (int j = 0; j < 13; j++){
				out.append(deckOfCards[c++]+" ");
			}
			out.append("\n");
		}
		
		
		return out.toString();
	}
	
	public void shuffle(){
		Random r = new Random();
		for (int i = deckOfCards.length-1; i >= 1 ; i--){
			int randomIndex = r.nextInt(i+1);
			Card temp = deckOfCards[i];
			deckOfCards[i] = deckOfCards[randomIndex];
			deckOfCards[randomIndex] = temp;
		}
	}
	
	public Card deal(){
		if (currentCard<52)
			return deckOfCards[currentCard++];
		else{
			System.out.println("all cards are dealt");
			return null;
		}
	}
	
	public static void main(String[] args) {
		DeckOfCard dc = new DeckOfCard();
		System.out.println(dc);
		dc.shuffle();
		System.out.println();
		System.out.println(dc);
	}
}
