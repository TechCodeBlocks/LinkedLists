public class main {
    public static void main(String[] args) {
        dLinkedList myList = new dLinkedList(new Node(null, null, "Test"));
        myList.append("Test2");
        myList.append("IntelliJ");
        myList.append("Version20");
        myList.insert("IntelliJ","Eclipse");
        myList.traverse();
        myList.delete("Test");
        myList.traverse();

    }

}
