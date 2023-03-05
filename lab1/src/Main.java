import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        File file = new File("lab1/src/MOCK_DATA.csv");
        ArrayList<Competitor> listOfCompetitors = new ArrayList<>();
        int position;



        Competitor competitor0;
        competitor0 = Competitor.createCompetitorFromString("Bryna;Jaine;Chile;2008;26;II");
        Competitor competitor50;
        competitor50 = Competitor.createCompetitorFromString("Karla;Cotgrove;China;1993;50;II");
        Competitor competitor25;
        competitor25 = Competitor.createCompetitorFromString("Flinn;Escolme;Poland;2009;13;I");
        Competitor competitor1;
        competitor1 = Competitor.createCompetitorFromString("Nelle;Ditchett;Portugal;2008;1;I");
        Competitor unexisting;
        unexisting = Competitor.createCompetitorFromString("Karla;Cotgrove;China;2008;26;II");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String st;
            while ((st = br.readLine()) != null) {
                listOfCompetitors.add(Competitor.createCompetitorFromString(st));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        TreeSet<Competitor> treeSet = new TreeSet<>(listOfCompetitors);
        for(Competitor competitor : treeSet){
            System.out.println(competitor);
        }


        /*System.out.println("------------Linear search-------------");
        System.out.println("Speed O(N)");

        System.out.println("");
        System.out.println("Find of first element\n Expected time O(1)");
        position = Algorithms.linearSearch(listOfCompetitors,competitor0);
        System.out.println("Position of the element = " + position);

        System.out.println("");
        System.out.println("Find of the last element\n Expected time O(50)");
        position = Algorithms.linearSearch(listOfCompetitors,competitor50);
        System.out.println("Position of the element = " + position);


        System.out.println("");
        System.out.println("Find of the middle element\n Expected time O(25)");
        position = Algorithms.linearSearch(listOfCompetitors, competitor25);
        System.out.println("Position of the element = " + position);


        System.out.println("");
        System.out.println("Find of the unexisting element\n Expected time O(50)");
        position = Algorithms.linearSearch(listOfCompetitors,unexisting);
        System.out.println("Position of the element = " + position);*/

        Collections.sort(listOfCompetitors);

/*        System.out.println("----------Binary search---------");

        System.out.println("");
        System.out.println("Find of first element");
        position = Algorithms.binarySearch(listOfCompetitors,competitor1);
        System.out.println("Position of the element = " + position);

        System.out.println("");
        System.out.println("Find of the last element");
        position = Algorithms.binarySearch(listOfCompetitors,competitor50);
        System.out.println("Position of the element = " + position);


        System.out.println("");
        System.out.println("Find of the middle element");
        position = Algorithms.binarySearch(listOfCompetitors, competitor25);
        System.out.println("Position of the element = " + position);


        System.out.println("");
        System.out.println("Find of the unexisting element");
        position = Algorithms.binarySearch(listOfCompetitors,unexisting);
        System.out.println("Position of the element = " + position);*/


/*        MyTree tree = new MyTree();
        for (Competitor competitor : listOfCompetitors){
            tree.add(competitor);
        }

        System.out.println("--------Tree-------");

        long before = System.nanoTime();
        System.out.println("Contains first element==> " + tree.contains(competitor1));
        long after =System.nanoTime();
        System.out.println("Time of search => " + (after-before));*/



    }
}