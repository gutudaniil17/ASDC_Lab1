public class MyTree {
    Node root;
    private Node addRecursive(Node current, Competitor comp){
        if (current == null){
            return new Node(comp);
        }
        if(comp.getNumberInTable() < current.competitor.getNumberInTable()){
            current.left = addRecursive(current.left,comp);
        } else if (comp.getNumberInTable() < current.competitor.getNumberInTable()) {
            current.right = addRecursive(current.right,comp);
        } else {
            return current;
        }
        return current;
    }
    public void add(Competitor competitor){
        root = addRecursive(root,competitor);
    }

    private boolean containsRecursive(Node current,Competitor competitor){
        if(current==null) return false;
        if(competitor.equals(current.competitor)) return true;
        return competitor.getNumberInTable() < current.competitor.getNumberInTable()
                ?containsRecursive(current.left,competitor)
                :containsRecursive(current.right,competitor);
    }
    public boolean contains(Competitor competitor){
        return containsRecursive(root,competitor);
    }
}
