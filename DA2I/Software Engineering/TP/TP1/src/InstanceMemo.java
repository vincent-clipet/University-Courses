public class InstanceMemo
{

    public static int index = 0;
    public static InstanceMemo[] last10 = new InstanceMemo[10];

    public InstanceMemo()
    {
	InstanceMemo.last10[index % 10] = this;
    }

    public String toString()
    {
	
    }

}