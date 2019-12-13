import java.util.*;

public class ReconstructItinerary {

    Map<String, PriorityQueue<String>> map;
    List<String> iter;

    public List<String> findItinerary(List<List<String>> tickets) {
        createMap(tickets);
        dfs("JFK");
        return iter;
    }

    public void dfs(String departure) {

        PriorityQueue<String> arrivals = map.get(departure);

        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        iter.add(0,departure);
    }

    public void createMap(List<List<String>> tickets) {
        map = new HashMap<>();
        iter = new LinkedList<>();

        for (List<String> ticket : tickets) {
            if(!map.containsKey(ticket.get(0)))
                map.put(ticket.get(0),new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
    }


    public static void main(String args[]){
        List<List<String>> tickets = new LinkedList<>();
        List<String> l1 = new LinkedList<>();
        List<String> l2 = new LinkedList<>();
        List<String> l3 = new LinkedList<>();
        List<String> l4 = new LinkedList<>();
        List<String> l5 = new LinkedList<>();
        List<String> l6 = new LinkedList<>();

        l1.add("JFK");
        l1.add("NRT");
        l2.add("JFK");
        l2.add("KUL");
        l3.add("NRT");
        l3.add("JFK");
        l4.add("KUL");
        l4.add("ALT");
        l5.add("ALT");
        l5.add("KUL");
        l6.add("KUL");
        l6.add("SFO");

        tickets.add(l1);
        tickets.add(l2);
        tickets.add(l3);
        tickets.add(l4);
        tickets.add(l5);
        tickets.add(l6);

        ReconstructItinerary obj = new ReconstructItinerary();
        List<String> finalIter = obj.findItinerary(tickets);
        System.out.print(finalIter);

    }

}
