public class Node {
    Competitor competitor;
    Node left;
    Node right;

    public Node(Competitor competitor) {
        this.competitor = competitor;
        left = null;
        right = null;
    }
}
