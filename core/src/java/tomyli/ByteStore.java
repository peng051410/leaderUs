package tomyli;

/**
 * lizp@ishugui.com
 *
 * @author tomyli 2016/12/07 22:25.
 */
public class ByteStore {

    static byte[] storeByteArry = new byte[3000];

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            MyItem myItem = new MyItem();
            myItem.setType((byte) i);
            myItem.setColor((byte) i);
            myItem.setPrice((byte) i);
            putMyItem(i, myItem);
        }

        MyItem myItem = getMyItem(2);
        System.out.println(myItem.getPrice());
    }

    private static void putMyItem(int index, MyItem item) {

        byte type = item.getType();
        byte color = item.getColor();
        byte price = item.getPrice();

        //0   1   2   3
        //012 345 678 91011
        int start = (index << 2) - index;
        storeByteArry[start] = type;
        storeByteArry[start + 1] = color;
        storeByteArry[start + 2] = price;
    }

    private static MyItem getMyItem(int index) {

        int start = index << 2 - index;

        byte type = storeByteArry[start];
        byte color = storeByteArry[start + 1];
        byte price = storeByteArry[start + 2];
        MyItem myItem = new MyItem();

        myItem.setType(type);
        myItem.setColor(color);
        myItem.setPrice(price);

        return myItem;
    }
}
