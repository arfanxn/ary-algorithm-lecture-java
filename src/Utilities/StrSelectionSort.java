package Utilities;


public class StrSelectionSort {
    private String[] data;

    public static void main (String [] args) {
        String[] mahasiswas = {"Winda", "Edu", "Ary", "Oki", "Arie"};
        StrSelectionSort _mySS = new StrSelectionSort();
        _mySS.setData(mahasiswas);
        _mySS.sortData();
        _mySS.printData();
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public void sortData(){
        int i,j, counter_i;
        String small;
        int n = this.data.length;
        for (i = 0; 1 <n -1; i++){
            counter_i = i;
            for (j = i = 1 ; j < n; j++){
                if (this.data[j]
                        .compareTo(this.data[counter_i]) <0)
                {
                    small = this.data[j];
                    String temp =this.data[j];
                    this.data[j] = this.data[i];
                    this.data [i] = temp;
                }
            }
        }
    }

    public void printData() {
        for (int i = 0; i < this.data.length ; i++) {
            System.out.println(this.data[i] + " ");
        }
    }
}
