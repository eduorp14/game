package com.poker.game.util;

import java.util.Comparator;
import java.util.Map;

import com.poker.game.object.Card;

public class RankComparator implements Comparator<Card>{
    private Map<String, Integer> sortOrder;

    public RankComparator(Map<String, Integer> sortOrder)
    {
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Card i1, Card i2)
    {
        Integer rankPos1 = sortOrder.get(i1.getRank());
        if (rankPos1 == null)
        {
            throw new IllegalArgumentException("Bad rank encountered: " +
               i1.getRank());
        }
        Integer rankPos2 = sortOrder.get(i2.getRank());
        if (rankPos2 == null)
        {
            throw new IllegalArgumentException("Bad rank encountered: " +
               i2.getRank());
        }
        return rankPos1.compareTo(rankPos2);
    }
}
