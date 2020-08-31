package com.poker.game.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.poker.game.object.Card;

public class CardUtil {
	List<String> listOrden = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A");

	public int rankValue(String a) {
		return listOrden.indexOf(a);
	}

	public void ordenarLista(List<Card> lista) {
		Map<String, Integer> rankOrder = new HashMap<String, Integer>();
		for (int i = 0; i < listOrden.size(); i++) {
			String rank = listOrden.get(i);
			rankOrder.put(rank, i);
		}
		Collections.sort(lista, new RankComparator(rankOrder));
	}

	public int groupMapFind(String card, Map<String, Long> mapa) {

		return mapa.get(card).intValue();
	}

	public Map<String, Long> groupMap(List<Card> cards) {

		List<String> cardRanks = new ArrayList<>();

		for (int i = 0; i < cards.size(); i++) {
			cardRanks.add(cards.get(i).getRank());
		}

		Map<String, Long> elementCountMap = cardRanks.stream()
				.collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));

		return elementCountMap;
	}

	public static final List<Card> ROYAL_FLUSH_SPADES = Arrays.asList(new Card("T", "S"), new Card("J", "S"),
			new Card("Q", "S"), new Card("K", "S"), new Card("A", "S"));

	public static final List<Card> ROYAL_FLUSH_HEARTS = Arrays.asList(new Card("T", "H"), new Card("J", "H"),
			new Card("Q", "H"), new Card("K", "H"), new Card("A", "H"));

	public static final List<Card> ROYAL_FLUSH_CLUBS = Arrays.asList(new Card("T", "C"), new Card("J", "C"),
			new Card("Q", "C"), new Card("K", "C"), new Card("A", "C"));

	public static final List<Card> ROYAL_FLUSH_DIAMONDS = Arrays.asList(new Card("T", "D"), new Card("J", "D"),
			new Card("Q", "D"), new Card("K", "D"), new Card("A", "D"));

	public static final List<String> STRAIGHT_TWO_TO_SIX = Arrays.asList("2", "3", "4", "5", "6");

	public static final List<String> STRAIGHT_THREE_TO_SEVEN = Arrays.asList("3", "4", "5", "6", "7");

	public static final List<String> STRAIGHT_FOUR_TO_EIGHT = Arrays.asList("4", "5", "6", "7", "8");

	public static final List<String> STRAIGHT_FIVE_TO_NINE = Arrays.asList("5", "6", "7", "8", "9");

	public static final List<String> STRAIGHT_SIX_TO_TEN = Arrays.asList("6", "7", "8", "9", "T");

	public static final List<String> STRAIGHT_SEVEN_TO_JACK = Arrays.asList("7", "8", "9", "T", "J");

	public static final List<String> STRAIGHT_EIGHT_TO_QUEEN = Arrays.asList("8", "9", "T", "J", "Q");

	public static final List<String> STRAIGHT_NINE_TO_KING = Arrays.asList("9", "T", "J", "Q", "K");

	public static final List<String> STRAIGHT_TEN_TO_ACE = Arrays.asList("T", "J", "Q", "K", "A");
}
