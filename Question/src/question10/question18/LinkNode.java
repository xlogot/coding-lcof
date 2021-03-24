package question10.question18;

public class LinkNode {
    public int value;
    public LinkNode next;
    public LinkNode(){};
    public LinkNode(int i){
        value=i;
    }

    public LinkNode AddNode(LinkNode node,int index)
    {
        if (node.next == null)
        {
            node.next = new LinkNode(index);
            return node;
        }
        AddNode(node.next, index);
        return node;
    }
}
