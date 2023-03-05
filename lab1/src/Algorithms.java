import java.util.ArrayList;

public class Algorithms {


    public static int linearSearch(ArrayList<Competitor> listOfCompetitors, Competitor searchedCompetitor) {
        int index = 0;
        long before = System.nanoTime();
        for (Competitor comp : listOfCompetitors) {
            if (comp.equals(searchedCompetitor)) {
                final long after = System.nanoTime();
                System.out.println("Time of search ==> " + (after - before));
                return index;
            } else index++;
        }
        long after = System.nanoTime();
        System.out.println("Time of search ==> " + (after - before));
        return -1;
    }

    public static int binarySearch(ArrayList<Competitor> list, Competitor searchedCompetitor) {
        int firstIndex = 0;
        int lastIndex = list.size() - 1;
        int maxOfIterations = (int) (Math.log(list.size()) / Math.log(2));
        int k = 0;
        long before = System.nanoTime();

        while (firstIndex <= lastIndex) {

            if (k > maxOfIterations) {
                System.out.println("No such element :(");
                long after = System.nanoTime();
                System.out.println("Time of search ==> " + (after - before));
                return -1;
            }
            k++;

            int middleIndex = (lastIndex + firstIndex) / 2;
            if (searchedCompetitor.equals(list.get(middleIndex))) {
                long after = System.nanoTime();
                System.out.println("Time of search ==> " + (after - before));
                return middleIndex;
            } else if (searchedCompetitor.getNumberInTable() < list.get(middleIndex).getNumberInTable()) {
                lastIndex = middleIndex - 1;
            } else if (searchedCompetitor.getNumberInTable() > list.get(middleIndex).getNumberInTable()) {
                firstIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    public static int interpolationSearch(ArrayList<Competitor> list, Competitor searched) {
        int firstIndex = 0;
        int lastIndex = list.size() - 1;
        long before = System.nanoTime();
        int maxOfIterations = (int) (Math.log(list.size()) / Math.log(2));
        int l = 0;

        while (firstIndex <= lastIndex) {
            if (l > maxOfIterations) {
                System.out.println("No such element :(");
                long after = System.nanoTime();
                System.out.println("Time of search ==> " + (after - before));
                return -1;
            }
            l++;
            int k = list.get(lastIndex).getNumberInTable() - list.get(firstIndex).getNumberInTable();
            int z = searched.getNumberInTable() - list.get(firstIndex).getNumberInTable();
            int pos = firstIndex + (lastIndex - firstIndex) / k * z;
            if (list.get(pos).equals(searched)) {
                long after = System.nanoTime();
                System.out.println("Time of search ==> " + (after - before));
                return pos;
            } else if (list.get(pos).getNumberInTable() < searched.getNumberInTable()) {
                firstIndex = pos + 1;
            } else if (list.get(pos).getNumberInTable() > searched.getNumberInTable()) {
                lastIndex = pos - 1;
            }
        }
        return -1;
    }
    private static long getFibonacciNumber(int num) {
        long firstNumber = 0;
        long secondNumber = 1;
        for (int i = 0; i < num; i++) {
            long temp = secondNumber;
            secondNumber += firstNumber;
            firstNumber = temp;
        }
        return firstNumber;
    }

    public static int fibonacciSearch(ArrayList<Competitor> list, Competitor searched){
        long startTime = System.nanoTime();
        long endTime;


        int i,q,p,m;
        int k = 0;
        int listSize = list.size();
        boolean stop = false;

        while (getFibonacciNumber(k + 1) < listSize + 1) {
            k++;
        }

        m = (int) (getFibonacciNumber(k + 1) - (listSize + 1));
        i = (int) (getFibonacciNumber(k) - m);
        p = (int) getFibonacciNumber(k - 1);
        q = (int) getFibonacciNumber(k - 2);




        int result = -1;
        while (!stop) {
            if (i < 0) {
                if (p == 1)
                    stop = true;
                i = i + q;
                p = p - q;
                q = q - p;
            } else if (i >= listSize) {
                if (q == 0)
                    stop = true;
                i = i - q;
                int temp = q;
                q = p - q;
                p = temp;;
            } else if (searched.getNumberInTable() < list.get(i).getNumberInTable()) {
                if (q == 0)
                    stop = true;
                i = i - q;
                int temp = q;
                q = p - q;
                p = temp;
            } else if (searched.getNumberInTable() > list.get(i).getNumberInTable()) {
                if (p == 1)
                    stop = true;
                i = i + q;
                p = p - q;
                q = q - p;
            }
            else if (list.get(i).getNumberInTable() ==searched.getNumberInTable()) {
                result = i;
                break;
            }
        }
        endTime = System.nanoTime();
        System.out.println("Time of execution: " + (endTime - startTime) + " Nano Seconds");
        return result;
    }
}
