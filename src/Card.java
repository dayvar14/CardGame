public class Card extends Item
{
    private static int count = 0;
    private int value;


    public Card()
    {
        this(0);
    }
    public Card( int value )
    {
        super("Card", count);
        this.value = value;
        count++;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
}
