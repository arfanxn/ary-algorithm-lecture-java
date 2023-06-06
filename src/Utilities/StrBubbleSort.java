package Utilities;

public class StrBubbleSort {
    private String[] data;

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public void sortData() {
        int lenData = this.data.length;
        for (int i = 0; i < lenData; i++) {
            System.out.println("---\ni = " + i + "\n---");

            for (int j = i + 1; j < lenData; j++) {
                System.out.println("---\n\tj = " + j + "\n---");

                if (this.data[j].compareTo(this.data[i]) < 0) {
                    String temp = this.getData()[i];
                    this.data[i] = this.data[j];
                    this.data[j] = temp;
                    for (String dataStep:this.data) {
                        System.out.println("\t");
                        System.out.println(dataStep + " ");
                    }
                }
                System.out.println("\n");
            }

            System.out.println("Result step "+(i+1)+"\n");
            for (String dataStep:this.data) {
                System.out.println(dataStep + " ");
            }
            System.out.println("\n\n");

        }
    }
}
