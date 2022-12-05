import java.lang.instrument.Instrumentation;

public class Course {

    Student head; // head of linked list
    Student tail; // tail of linked list
    int noOfNodes; // number of nodes int the linked list

    // Constructor
    public Course() {
        head = null;
        tail = null;
        noOfNodes = 0;
    }

    // Check list is empty or not
    public boolean isEmpty() {
        return head == null;
    }

    // This function first builds new node with the given data
    // than insert it to the LinkedList
    // new nodes are inserted to the tail of LinkedList
    public void insert(String name) {
        Student newStudent = new Student(name);
        if (head == null) {
            head = newStudent;
        } else {
            tail.next = newStudent;
            newStudent.previous=tail;
        }
        tail = newStudent;
        noOfNodes++;
    }

    // overload this method as new nodes are added to given position (int pos)
    public void insert(String name, int pos) {

        Student newStudent = new Student(name);

        if (pos < 0 || pos > noOfNodes) return;

        if (pos == 0) {
            head.previous = newStudent;
            newStudent.next = head;
            head = newStudent;

        } else if (pos == size()) {
            insert(name);

        } else {
            int i = 0;
            Student student = head;
            while (i <= pos-1) {
                student = student.next;
                i++;
            }
            Student temp = student.previous;
            temp.next = student.previous = newStudent;
            newStudent.next = student;
            newStudent.previous = temp;
        }
        noOfNodes++;
    }


    // This method finds how many node are exist in LinkedList
    public int size() {

        return noOfNodes;
    }

    // This functions delete a node in the LinkedList by a given "data"
    // parameter name changed as key in order to prevent confusion

    public Student deleteByName(String name) {

            Student current = head;
            if (name== head.getName()){
                head.next.previous=null;
                head=head.next;
            } else if (name==tail.getName()) {
                current=tail;
                tail.previous.next=null;
                tail=tail.previous;

            }
            else{
                int i=1;
                while(i<=size()){
                    current=current.next;
                    if(current.getName()==name){
                        current.next.previous=current.previous;
                        current.previous.next=current.next;
                        break;
                    }
                    i++;
                }
            }
            noOfNodes--;
            return current;
        }

    // This functions delete a node in the LinkedList by a given position
    public Student deleteByPosition(int pos) {
        if (pos == 0) {
            Student current = head;
            head.next.previous = null;
            head = head.next;
            noOfNodes--;

            return current;
        } else if (pos == size() - 1) {
            Student current = tail;
            tail.previous.next = null;
            tail = tail.previous;
            noOfNodes--;
            return current;

        } else {
            int i=0;
            Student current = head;

            while(i<=pos){
                current=current.next;
                i++;
            }


            current.next.previous = current.previous;
            current.previous.next = current.next;

            noOfNodes--;

            return current;
        }
    }


    // This function get student by given position
    public Student getByPosition(int pos) {
            Student student = head;

            if (isEmpty()) {
                System.out.println("List is empty");
                return null;
            }

            if (pos == 0)
                return student;

            for (int i = 1; i < size(); i++) {
                student=student.next;
                if(i==pos){
                    return student;
                }
            }
            return student;
        }

    // That function prints  the LinkenList
    public void print() {
        System.out.print("Course student list: ");
        Student student = this.head;  // make a copy of head

        // never operate on "head", otherwise you will lost the linkedlist
        // unless you want to change "head"
        while (student != null) {
            System.out.print(student.getName() + "  ");
            student = student.next;  // iterate to next node
        }

        System.out.println();
    }
}




