// Java program for linked-list implementation of queue

// A linked list (LL) node to store a queue entry
class Node {
    Player player;
    Node next;

    // constructor to create a new linked list node
    public Node(Player player)
    {
        this.player = player;
        this.next = null;
    }
}

// A class to represent a queue
// The queue, front stores the front node of LL and rear stores the
// last node of LL
class Queue {
    Node front, rear;

    public Queue()
    {
        this.front = this.rear = null;
    }


    void enqueue(Player player)
    {

        // Create a new LL node
        Node temp = new Node(player);

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }


    void dequeue()
    {
        // If queue is empty, return NULL.
        if (this.front == null)
            return;

        // Store previous front and move front one node ahead
        Node temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
    }
}

