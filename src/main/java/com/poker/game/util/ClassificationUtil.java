package com.poker.game.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.poker.game.object.Card;

public class ClassificationUtil {
	CardUtil util = new CardUtil();

	public boolean detectRoyalFlush(List<Card> cards) {
		final List<Card> handCards = new ArrayList<>(cards);

		if (handCards.containsAll(CardUtil.ROYAL_FLUSH_SPADES)) {
			return true;
		} else if (handCards.containsAll(CardUtil.ROYAL_FLUSH_HEARTS)) {
			return true;
		} else if (handCards.containsAll(CardUtil.ROYAL_FLUSH_CLUBS)) {
			return true;
		} else if (handCards.containsAll(CardUtil.ROYAL_FLUSH_DIAMONDS)) {
			return true;
		}
		return false;
	}

	public int detectNormalStraight(List<Card> cards) {

		ArrayList<String> cardRanks = new ArrayList<>();

		for (int i = 0; i < cards.size(); i++) {
			cardRanks.add(cards.get(i).getRank());
		}

		if (cardRanks.containsAll(CardUtil.STRAIGHT_TEN_TO_ACE)) {
			return 9;
		} else if (cardRanks.containsAll(CardUtil.STRAIGHT_NINE_TO_KING)) {
			return 8;
		} else if (cardRanks.containsAll(CardUtil.STRAIGHT_EIGHT_TO_QUEEN)) {
			return 7;
		} else if (cardRanks.containsAll(CardUtil.STRAIGHT_SEVEN_TO_JACK)) {
			return 6;
		} else if (cardRanks.containsAll(CardUtil.STRAIGHT_SIX_TO_TEN)) {
			return 5;
		} else if (cardRanks.containsAll(CardUtil.STRAIGHT_FIVE_TO_NINE)) {
			return 4;
		} else if (cardRanks.containsAll(CardUtil.STRAIGHT_FOUR_TO_EIGHT)) {
			return 3;
		} else if (cardRanks.containsAll(CardUtil.STRAIGHT_THREE_TO_SEVEN)) {
			return 2;
		} else if (cardRanks.containsAll(CardUtil.STRAIGHT_TWO_TO_SIX)) {
			return 1;
		}
		return 0;
	}

	public boolean detectFlush(List<Card> cards) {
		int contador = 0;

		for (int i = 1; i < cards.size(); i++) {
			if (cards.get(i).getSuit().equals(cards.get(i - 1).getSuit())) {
				contador++;
			}
		}
		if (contador == 4) {
			return true;
		}
		return false;
	}

	public int detectQuad(List<Card> cards) {

		Map<String, Long> mapa = util.groupMap(cards);

		for (int i = 0; i < cards.size(); i++) {
			if (util.groupMapFind(cards.get(i).getRank(), mapa) == 4) {
				return util.rankValue(cards.get(i).getRank());
			}
		}

		return 0;
	}

	public int detectFullHouse(List<Card> cards) {

		Map<String, Long> mapa = util.groupMap(cards);

		for (int i = 1; i < cards.size(); i++) {
			if (util.groupMapFind(cards.get(i).getRank(), mapa) == 3
					&& util.groupMapFind(cards.get(i - 1).getRank(), mapa) == 2) {
				return util.rankValue(cards.get(i).getRank());
			}
			if (util.groupMapFind(cards.get(i).getRank(), mapa) == 2
					&& util.groupMapFind(cards.get(i - 1).getRank(), mapa) == 3) {
				return util.rankValue(cards.get(i - 1).getRank());
			}
		}

		return 0;
	}

	public int detectThree(List<Card> cards) {

		Map<String, Long> mapa = util.groupMap(cards);

		for (int i = 0; i < cards.size(); i++) {
			if (util.groupMapFind(cards.get(i).getRank(), mapa) == 3) {
				return util.rankValue(cards.get(i).getRank());
			}
		}

		return 0;
	}

	public int detectTwoPair(List<Card> cards) {

		Map<String, Long> mapa = util.groupMap(cards);

		for (int i = 1; i < cards.size(); i++) {
			if (util.groupMapFind(cards.get(i).getRank(), mapa) == 2
					&& util.groupMapFind(cards.get(i - 1).getRank(), mapa) == 2
					&& !cards.get(i).getRank().equals(cards.get(i - 1).getRank())) {
				return util.rankValue(cards.get(i).getRank());
			}
		}

		return 0;
	}

	public int detectPair(List<Card> cards) {

		Map<String, Long> mapa = util.groupMap(cards);

		for (int i = 0; i < cards.size(); i++) {
			if (util.groupMapFind(cards.get(i).getRank(), mapa) == 2) {
				return util.rankValue(cards.get(i).getRank());
			}
		}

		return 0;
	}

	public int detectHighestCard(List<Card> cards) {
		String cartMayor = "";

		for (int i = 1; i < cards.size(); i++) {
			if (util.rankValue(cards.get(i).getRank()) > util.rankValue(cards.get(i - 1).getRank())) {
				cartMayor = cards.get(i).getRank();
			} else {
				cartMayor = cards.get(i - 1).getRank();
			}
		}
		return util.rankValue(cartMayor);
	}

}
