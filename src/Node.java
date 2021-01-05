public class Node {
    Node preceding;
    Node following;
    String contents;

    Node(Node preceding, Node following, String contents){
        this.contents =contents;
        this.following = following;
        this.preceding = preceding;
    }

    public void setPreceding(Node preceding) {
        this.preceding = preceding;
    }

    public void setFollowing(Node following) {

        this.following = following;
    }
}
