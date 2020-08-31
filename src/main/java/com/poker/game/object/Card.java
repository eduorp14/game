package com.poker.game.object;

public class Card {

	private String rank;
	private String suit;

	public Card() {
	}

	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + "]";
	}
	
	@Override
	public boolean equals(Object o) {

	    // Check if o == itself  
	    if (o == this) {
	        return true;
	    }

	    // Check to see if o is instance of Card or not
	    if (!(o instanceof Card)) {
	        return false;
	    }

	    // typecast o to Card to compare 
	    Card c = (Card) o;

	    // check equality (assuming Rank and Suit to be int, else you need to change equality condition here)
	    return this.rank.equals(c.rank)
	            && this.suit.equals(c.suit);
	}

}
