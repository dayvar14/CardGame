public class ItemType
{
    private static int count = 0;
    private int id;
    private String name;

    public ItemType( )
    {
        this( "ItemType");
    }

    public ItemType( String name)
    {
        this( "ItemType", count);
    }
    public ItemType( String name, int id)
    {
        this.name = name;
        this.id = id;
        count++;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
