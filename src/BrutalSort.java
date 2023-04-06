public class BrutalSort {
    int compares;

    BrutalSort() {
        compares = 0;
    }

    int[] bubbleSort(int[] array) {
        boolean swapping = true;
        int temp;

        while(swapping){
            swapping = false;
            for(int i = 1; i < array.length; i++) {
                if(array[i-1] > array[i]) {
                    temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                    swapping = true;

                }
                compares++;
            }

        }
        return array;
    }
}
