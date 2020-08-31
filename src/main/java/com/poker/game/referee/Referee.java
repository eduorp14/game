package com.poker.game.referee;

import java.util.List;

import com.poker.game.object.Card;
import com.poker.game.object.ClassificationRank;
import com.poker.game.util.CardUtil;
import com.poker.game.util.ClassificationUtil;

public class Referee {
	CardUtil util = new CardUtil();
	ClassificationUtil claUtil = new ClassificationUtil();

	public int match(List<Card> p1, List<Card> p2) {
		// Ordenar manos
		util.ordenarLista(p1);
		util.ordenarLista(p2);

		// Calificar manos

		int cp1 = classifyHand(p1).getValue();

		int cp2 = classifyHand(p2).getValue();

		// Comparar manos decir ganador y solucionar empate
		if (cp1 == cp2) {
			return desempatar(p1, p2);
		} else if (cp1 > cp2) {
			return 1;
		} else {
			return 2;
		}
	}

	public int desempatar(List<Card> p1, List<Card> p2) {

		int cp1 = classifyHand(p1).getValue();

		int cp2 = classifyHand(p2).getValue();

		if (cp1 == ClassificationRank.ROYAL_FLUSH.getValue() && cp2 == ClassificationRank.ROYAL_FLUSH.getValue()) {
			return 3;
		}

		if (cp1 == ClassificationRank.STRAIGHT_FLUSH.getValue()
				&& cp2 == ClassificationRank.STRAIGHT_FLUSH.getValue()) {
			int rank1 = claUtil.detectNormalStraight(p1);
			int rank2 = claUtil.detectNormalStraight(p2);
			if (rank1 > rank2) {
				return 1;
			} else if (rank1 < rank2) {
				return 2;
			} else {
				return 3;
			}
		}

		if (cp1 == ClassificationRank.FOUR_OF_A_KIND.getValue()
				&& cp2 == ClassificationRank.FOUR_OF_A_KIND.getValue()) {
			int rank1 = claUtil.detectQuad(p1);
			int rank2 = claUtil.detectQuad(p2);
			if (rank1 > rank2) {
				return 1;
			} else if (rank1 < rank2) {
				return 2;
			} else {
				// Comparar carta mayor
				int hcp1 = claUtil.detectHighestCard(p1);
				int hcp2 = claUtil.detectHighestCard(p2);
				int r1 = 0;
				int r2 = 0;

				if (rank1 > hcp1) {
					r1 = rank1;
				} else {
					r1 = hcp1;
				}

				if (rank2 > hcp2) {
					r2 = rank2;
				} else {
					r2 = hcp2;
				}

				if (r1 > r2) {
					return 1;
				} else if (r1 < r2) {
					return 2;
				} else {
					return 3;
				}
			}
		}

		if (cp1 == ClassificationRank.FULL_HOUSE.getValue() && cp2 == ClassificationRank.FULL_HOUSE.getValue()) {
			int rank1 = claUtil.detectFullHouse(p1);
			int rank2 = claUtil.detectFullHouse(p2);
			if (rank1 > rank2) {
				return 1;
			} else if (rank1 < rank2) {
				return 2;
			} else {
				// Comparar carta mayor
				int hcp1 = claUtil.detectHighestCard(p1);
				int hcp2 = claUtil.detectHighestCard(p2);
				int r1 = 0;
				int r2 = 0;

				if (rank1 > hcp1) {
					r1 = rank1;
				} else {
					r1 = hcp1;
				}

				if (rank2 > hcp2) {
					r2 = rank2;
				} else {
					r2 = hcp2;
				}

				if (r1 > r2) {
					return 1;
				} else if (r1 < r2) {
					return 2;
				} else {
					return 3;
				}
			}
		}

		if (cp1 == ClassificationRank.FLUSH.getValue() && cp2 == ClassificationRank.FLUSH.getValue()) {
			// Comparar carta mayor

			int hcp1 = claUtil.detectHighestCard(p1);
			int hcp2 = claUtil.detectHighestCard(p2);

			if (hcp1 > hcp2) {
				return 1;
			} else if (hcp1 < hcp2) {
				return 2;
			} else {
				return 3;
			}
		}

		if (cp1 == ClassificationRank.STRAIGHT.getValue() && cp2 == ClassificationRank.STRAIGHT.getValue()) {
			int rank1 = claUtil.detectNormalStraight(p1);
			int rank2 = claUtil.detectNormalStraight(p2);
			if (rank1 > rank2) {
				return 1;
			} else if (rank1 < rank2) {
				return 2;
			} else {
				return 3;
			}
		}

		if (cp1 == ClassificationRank.THREE_OF_A_KIND.getValue()
				&& cp2 == ClassificationRank.THREE_OF_A_KIND.getValue()) {
			int rank1 = claUtil.detectThree(p1);
			int rank2 = claUtil.detectThree(p2);
			if (rank1 > rank2) {
				return 1;
			} else if (rank1 < rank2) {
				return 2;
			} else {
				// Comparar carta mayor
				int hcp1 = claUtil.detectHighestCard(p1);
				int hcp2 = claUtil.detectHighestCard(p2);
				int r1 = 0;
				int r2 = 0;

				if (rank1 > hcp1) {
					r1 = rank1;
				} else {
					r1 = hcp1;
				}

				if (rank2 > hcp2) {
					r2 = rank2;
				} else {
					r2 = hcp2;
				}

				if (r1 > r2) {
					return 1;
				} else if (r1 < r2) {
					return 2;
				} else {
					return 3;
				}
			}
		}

		if (cp1 == ClassificationRank.TWO_PAIR.getValue() && cp2 == ClassificationRank.TWO_PAIR.getValue()) {
			int rank1 = claUtil.detectTwoPair(p1);
			int rank2 = claUtil.detectTwoPair(p2);
			if (rank1 > rank2) {
				return 1;
			} else if (rank1 < rank2) {
				return 2;
			} else {
				// Comparar carta mayor
				int hcp1 = claUtil.detectHighestCard(p1);
				int hcp2 = claUtil.detectHighestCard(p2);
				int r1 = 0;
				int r2 = 0;

				if (rank1 > hcp1) {
					r1 = rank1;
				} else {
					r1 = hcp1;
				}

				if (rank2 > hcp2) {
					r2 = rank2;
				} else {
					r2 = hcp2;
				}

				if (r1 > r2) {
					return 1;
				} else if (r1 < r2) {
					return 2;
				} else {
					return 3;
				}
			}
		}

		if (cp1 == ClassificationRank.ONE_PAIR.getValue() && cp2 == ClassificationRank.ONE_PAIR.getValue()) {
			int rank1 = claUtil.detectPair(p1);
			int rank2 = claUtil.detectPair(p2);
			if (rank1 > rank2) {
				return 1;
			} else if (rank1 < rank2) {
				return 2;
			} else {
				// Comparar carta mayor
				int hcp1 = claUtil.detectHighestCard(p1);
				int hcp2 = claUtil.detectHighestCard(p2);
				int r1 = 0;
				int r2 = 0;

				if (rank1 > hcp1) {
					r1 = rank1;
				} else {
					r1 = hcp1;
				}

				if (rank2 > hcp2) {
					r2 = rank2;
				} else {
					r2 = hcp2;
				}

				if (r1 > r2) {
					return 1;
				} else if (r1 < r2) {
					return 2;
				} else {
					return 3;
				}
			}
		}

		if (cp1 == ClassificationRank.HIGH_CARD.getValue() && cp2 == ClassificationRank.HIGH_CARD.getValue()) {
			// Comparar carta mayor
			int hcp1 = claUtil.detectHighestCard(p1);
			int hcp2 = claUtil.detectHighestCard(p2);

			if (hcp1 > hcp2) {
				return 1;
			} else if (hcp1 < hcp2) {
				return 2;
			} else {
				return 3;
			}
		}

		return 0;

	}

	public ClassificationRank classifyHand(List<Card> cards) {
		if (claUtil.detectRoyalFlush(cards)) {
			return ClassificationRank.ROYAL_FLUSH;
		} else if (claUtil.detectNormalStraight(cards) > 0 && claUtil.detectFlush(cards)) {
			return ClassificationRank.STRAIGHT_FLUSH;
		} else if (claUtil.detectQuad(cards) > 0) {
			return ClassificationRank.FOUR_OF_A_KIND;
		} else if (claUtil.detectFullHouse(cards) > 0) {
			return ClassificationRank.FULL_HOUSE;
		} else if (claUtil.detectFlush(cards)) {
			return ClassificationRank.FLUSH;
		} else if (claUtil.detectNormalStraight(cards) > 0) {
			return ClassificationRank.STRAIGHT;
		} else if (claUtil.detectThree(cards) > 0) {
			return ClassificationRank.THREE_OF_A_KIND;
		} else if (claUtil.detectTwoPair(cards) > 0) {
			return ClassificationRank.TWO_PAIR;
		} else if (claUtil.detectPair(cards) > 0) {
			return ClassificationRank.ONE_PAIR;
		}
		return ClassificationRank.HIGH_CARD;
	}

}
