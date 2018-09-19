public class PlayingCards extends Card implements Comparable<PlayingCards>
{
    final static int MIN_VALUE = 2;
    final static int MAX_VALUE = 14;
    final static int MIN_SUIT = 0;
    final static int MAX_SUIT = 3;
    private int suit = 0;

    public PlayingCards()
    {
        this( 0, 0);
    }

    public PlayingCards(int suit, int value )
    {
        if( value < MIN_VALUE || value > MAX_VALUE)
            value = 0;
        if( suit < MIN_SUIT || suit > MAX_SUIT)
            suit = 0;
        this.setValue( value );
        this.setSuit( suit);
    }

    @Override
    public void setValue(int value) {
        if( value < MIN_VALUE || value > MAX_VALUE)
            return;
        super.setValue(value);
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit)
    {
        if( suit < MIN_SUIT || suit > MAX_SUIT)
            return;
        this.suit = suit;
    }

    @Override
    public int compareTo(PlayingCards pc)
    {
        return Integer.compare( this.getValue(), pc.getValue());
    }
}
