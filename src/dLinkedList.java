public class dLinkedList {
    Node head;
    Node tail;

    //Initialises a doubly linked list with one item which will start as the head and the tail.
    public dLinkedList(Node startNode) {
        head = startNode;
        tail = startNode;

    }

    //Append a value to the end of the list (the most efficient way of adding to the list)
    //Simply works by giving the old tail a following node and setting tail to be the new final node
    //Constant time complexity O(1)
    public void append(String value) {
        Node newNode = new Node(tail, null, value);
        tail.setFollowing(newNode);
        tail = newNode;


    }

    //Insert function to insert a new value after the given value, uses a recursive method to traverse LL to find insertion point
    //Publicly accessible method for the class.
    public void insert(String after, String value) {
        Node newNode = new Node(null, null, value);
        Node throwNode = traverseInsert(head, newNode, after);


    }

    //Publicly accessible delete, calls to a recursive function.
    public void delete(String target) {
        Node throwNode = traverseDelete(head, target);

    }

    //Traverse the list, public caller function
    public void traverse() {
        Node throwaway = traverseUntil(head, "-1");
    }

    //Can set to recuse up to a set point, yet to use but might be useful
    //loops through the LL and prints out each value in order
    private Node traverseUntil(Node node, String limiter) {
        System.out.println(node.contents);
        if (node.following == null) {

            return node;
        }
        if (node.contents.equals(limiter)) {
            return node;
        } else {
            return traverseUntil(node.following, limiter);

        }

    }

    //Traverses LL to insert a new item. Recursive process, O(n)
    private Node traverseInsert(Node node, Node newNode, String limiter) {
        //If node is the tail, no need to assign this as the preceding for any other node as it is the last node
        //Updates the pointers in the new node to refer to the new position before it. Updates the preceding node to point to
        //new node
        if (node.following == null) {
            newNode.setPreceding(node);
            node.setFollowing(newNode);
            return node;
        }
        //Checks if the target point to insert after has been found
        if (node.contents.equals(limiter)) {
            //Updates the newNode to have pointers to the previous following node and the node that comes before it
            //Updates the pointers of the node after the one it is being inserted after to have a new preceding node
            //Updates the pointer of the preceding node to point to the new node
            newNode.setFollowing(node.following);
            newNode.setPreceding(node);
            node.following.setPreceding(newNode);
            node.setFollowing(newNode);
            return node;
        } else {

            return traverseInsert(node.following, newNode, limiter);

        }

    }
    //Traverse through the LL to delete a target item. O(n)
    private Node traverseDelete(Node node, String target) {
        //Ends recursion, will trigger at end if target not found
        if (node.following == null) {
            return node;
        }
        //Check if target has been found
        if (node.contents.equals(target)) {
            //Accounts for deleting the first item in the LL
            if (node.preceding == null) {
                node.following.setPreceding(null);
                head = node.following;

            }   //Accounts for deleting the tail of the LL
                //Both the above 2 need special cases to update the overall lists pointers and to account for null pointers
                else if (node.following == null) {
                node.preceding.setFollowing(null);
                tail = node.preceding;
            }   //Remove all pointers to the node thats being removed. Set new preceding pointer for the following node
                //Set new following node for the preceding node.
                else {
                node.following.setPreceding(node.preceding);
                node.preceding.setFollowing(node.following);
            }


            return node;
        } else {

            return traverseDelete(node.following, target);

        }

    }


}
