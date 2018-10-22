class BinarySearchTree<Key extends Comparable<Key>,Value> {
    private Node root;
    private int size;

    private class Node {
        private BookList key;
        private Value val;
        private Node left, right;
        private int count; 

        public Node () {
        }
    }
    /**
     * { function_description }
     *
     * @param      key   The key
     * @param      val   The value
     * Time complexity : O(logn)
     */
    public void put(BookList key, Value val) {
        if (key == null) {
            System.out.println("key is null");
        }
        root = put(root, key, val);
    }
    /**
     * { function_description }
     *
     * @param      head  The head
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logn)
     */
    public Node put(Node head, BookList key, Value val) {
        if (head == null) {
            Node node = new Node();
            node.key = key;
            node.val = val;
            node.left = node.right = null;
            head = node;
            size++;
        }
        int compare = key.compareTo(head.key);
        if (compare < 0) {
            head.left  = put(head.left, key, val);
        } else if (compare > 0) {
            head.right = put(head.right, key, val);
        } else {
            head.val = val;
        }
        head.count = 1 + size(head.left) + size(head.right);
        return head;
    }
    /**
     * { function_description }
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logn)
     */
    public Value get(BookList key) {
        return get(root, key);
    }
    /**
     * { function_description }
     *
     * @param      root  The root
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logn)
     */
    private Value get(Node root, BookList key) {
        if (key == null) {
            System.out.println("key is null");
        }
        
        if (root == null) {
            return null;
        }
        int compare = key.compareTo(root.key);
        if (compare < 0) {
            return get(root.left, key);
        } else if (compare > 0) {
            return get(root.right, key);
        } else{
            return root.val;
        }
    }

    public BookList min() {
        return min(root).key;
    }

    public Node min(Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    public BookList max() {
        return max(root).key;
    }

    public Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }

    public BookList floor(BookList key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    public Node floor(Node x, BookList key) {
        if (x == null) {
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare == 0) {
            return x;
        }
        if (compare < 0) {
            return floor(x.left, key);
        }
        Node temp = floor(x.right, key);
        if (temp != null) {
            return temp;
        } else {
            return x;
        }
    }

    public BookList ceiling(BookList key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    public Node ceiling(Node x, BookList key) {
        if (x == null) {
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare == 0) {
            return x;
        }
        if (compare < 0) {
            Node temp = ceiling(x.left, key);
            if (temp != null) {
                return temp;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }

    // public int rank(BookList key) {
    //     return rank(root, key);
    // }

    // public int rank(Node x, BookList key) {
    //     if (x == null) {
    //         return 0;
    //     }
    //     int compare = key.compareTo(x.key); 
    //     if (compare < 0) {
    //         return rank(x.left, key); 
    //     } else if (compare > 0) {
    //         return 1 + size(x.left) + rank(x.right, key); 
    //     } else {
    //         return size(x.left);
    //     }
    // }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
    	if (x == null) {
    		return 0;
    	}
        return x.count;
    }

    public BookList select(int k) {
        if (k < 0 || k >= size()) {
            return null;
        }
        Node x = select(root, k);
        return x.key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null; 
        }
        int t = size(x.left); 
        if (t > k) {
            return select(x.left,  k); 
        } else if (t < k) {
            return select(x.right, k-t-1); 
        } else {
            return x;
        }
    }
}
