package question30.question35;

public class ComplexListNode {
    ComplexListNode next;
    ComplexListNode sibling;
    int value;

    public ComplexListNode() {
    }

    public ComplexListNode(int value) {
        this.value = value;
    }

    public ComplexListNode(ComplexListNode sibling) {
        this.sibling = sibling;
    }
}
