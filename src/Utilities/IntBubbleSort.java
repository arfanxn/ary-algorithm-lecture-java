package Utilities;

public class IntBubbleSort {
    private int[] data;

    public IntBubbleSort(){};

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public void sortData () {
        int lenData = this.data.length;
        for (int i = 0; i < lenData; i++) {
            System.out.println("i = " + i);

            for (int j = i + 1; j < lenData; j++) {
                System.out.println("j = " + i);

                if (this.data[j] < this.data[i]) {
                    int temp = this.getData()[i];
                    this.data[i] = this.data[j];
                    this.data[j] = temp;
                    System.out.println(
                            "value i and j are switched, i value = " + this.data[i]
                            + ", j value = " + this.data[j]
                    );
                }
            }
        }
    }
}
