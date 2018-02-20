package pagh.cphbusiness;

import java.util.*;

public class Assignment3
{
    private List<Card> deck = new ArrayList<>();
    private String spade = new String("spade");
    private String heart = new String("heart");
    private String club = new String("club");
    private String diamond = new String("diamond");
    private ArrayList<String> suits = new ArrayList<>();


    public void tester()
    {
        cardMaker();
        deckShuffler(deck);

        deck = deckSorter(deck);
        for (int i = 0; i < deck.size(); i++)
        {
            System.out.println(deck.get(i));
        }

    }

    private List<Card> deckSorter(List<Card> deck)
    {
        Card[] deckTemp = deck.toArray(new Card[deck.size()]);

        for (int i = 1; i < deckTemp.length; i++)
        {
            try
            {
                Card cardOne = deckTemp[i];
                Card cardTwo = deckTemp[i - 1];
                if (i == 0)
                {
                }
                else if (suits.indexOf(cardOne.getSuit()) < suits.indexOf(cardTwo.getSuit()))
                {
                    deckTemp[i] = cardTwo;
                    deckTemp[i - 1] = cardOne;
                    i = i - 2;
                }
                else if (suits.indexOf(cardOne.getSuit()) == suits.indexOf(cardTwo.getSuit()) && cardOne.getValue() < cardTwo.getValue())
                {
                    deckTemp[i] = cardTwo;
                    deckTemp[i - 1] = cardOne;
                    i = i - 2;
                }
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("fuckey abound!");
            }
        }

        return Arrays.asList(deckTemp);
    }

    private void cardMaker()
    {
        suits.add(spade);
        suits.add(heart);
        suits.add(club);
        suits.add(diamond);
        for (int i = 0; i < suits.size(); i++)
        {
            for (int a = 1; a < 14; a++)
            {
                deck.add(new Card(suits.get(i), a));
            }
        }
    }

    private void deckShuffler(List<Card> deck)
    {
        Collections.shuffle(deck);
    }


}
