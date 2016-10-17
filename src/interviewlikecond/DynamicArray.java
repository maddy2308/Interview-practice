package interviewlikecond;

public class DynamicArray {
    private Integer[] array = new Integer[2];
    private int lastIndexAdded = 0;
    private int length = 0;

    public void add(int element) {
        if (getLastIndexPosition() == array.length) {
            array = reInit();
        }
        array[lastIndexAdded++] = element;
        length++;
    }

    private Integer[] reInit() {
        int newSize = (getLastIndexPosition() + 1) * 2;
        int counter = 0;
        Integer[] temp = new Integer[newSize];
        for (Integer val : array) {
            if (val != null) {
                temp[counter++] = val;
            }
        }
        lastIndexAdded = counter;
        return temp;
    }

    public int getLastIndexPosition() {
        return lastIndexAdded;
    }

    public int getSize() {
        return length;
    }

    public void remove(int element) {
        for (int counter = 0; counter < array.length; counter++) {
            if (array[counter] == element) {
                array[counter] = null;
                length--;
            }
        }
    }

    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();
        da.add(1);
        da.add(1);

        System.out.println(da.getSize());

        da.add(2);
        da.add(3);
        da.add(4);
        da.add(5);

        da.remove(1);

        System.out.println(da.getSize());
    }
}

