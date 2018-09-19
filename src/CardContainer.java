import java.util.Stack;

public abstract class CardContainer extends Stack<Card>
{
    protected Card topCard;
    protected Card[] cards;
    protected int topIndex = -1;
}
