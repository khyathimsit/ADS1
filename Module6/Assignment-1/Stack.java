class Stack {
    LinkedList stackll;
    Stack() {
       stackll = new LinkedList();
    }
    
    public String pop1() {
        return stackll.removeBack();
    }
    
    public void push1(final String value) {
        stackll.insertFront(value);
    }
}
