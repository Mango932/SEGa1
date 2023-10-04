import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class PartTwo{

    public static void main(String[] args) {
        int collectionSize = 1000000; 
        Random random = new Random();

        //Part A
        //arraylist
        long arrayListStartTime = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < collectionSize; i++) {
            arrayList.add(random.nextInt(10));
        }
        long arrayListEndTime = System.nanoTime();
        long arrayListConstructionTime = arrayListEndTime - arrayListStartTime;

        //vector
        long vectorStartTime = System.nanoTime();
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < collectionSize; i++) {
            vector.addElement(random.nextInt(10));
        }
        long vectorEndTime = System.nanoTime();
        long vectorConstructionTime = vectorEndTime - vectorStartTime;

        //array
        long arrayStartTime = System.nanoTime();
        int[] array = new int[collectionSize];
        for (int i = 0; i < collectionSize; i++) {
            array[i] = random.nextInt(10);
        }
        long arrayEndTime = System.nanoTime();
        long arrayConstructionTime = arrayEndTime - arrayStartTime;

        //Part B
        //arraylist
        long arrayListIterationStartTime = System.nanoTime();
        int arrayListSum = 0;
        for (Integer num : arrayList) {
            arrayListSum += num;
        }
        long arrayListIterationEndTime = System.nanoTime();
        long arrayListIterationTime = arrayListIterationEndTime - arrayListIterationStartTime;

        //vector
        long vectorIterationStartTime = System.nanoTime();
        int vectorSum = 0;
        for (Integer num : vector) {
            vectorSum += num;
        }
        long vectorIterationEndTime = System.nanoTime();
        long vectorIterationTime = vectorIterationEndTime - vectorIterationStartTime;

        //array
        long arrayIterationStartTime = System.nanoTime();
        int arraySum = 0;
        for (int i = 0; i < array.length; i++) {
            arraySum += array[i];
        }
        long arrayIterationEndTime = System.nanoTime();
        long arrayIterationTime = arrayIterationEndTime - arrayIterationStartTime;

        //output
        System.out.println("Construction time arraylist " + arrayListConstructionTime + " ns");
        System.out.println("Construction time vector: " + vectorConstructionTime + " ns");
        System.out.println("Construction time array: " + arrayConstructionTime + " ns");
        System.out.println("Iteration time arraylist: " + arrayListIterationTime + " ns");
        System.out.println("Iteration time vector: " + vectorIterationTime + " ns");
        System.out.println("Iteration time array: " + arrayIterationTime + " ns");
    }
}
