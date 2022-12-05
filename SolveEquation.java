public class SolveEquation {
        Digit top; // top of stack
        int noOfDigits; // number of Digits

        // Constructor
        SolveEquation(){
           top=null;
           noOfDigits=0;
        }

        public double solve(String exp) {

            SolveEquation myStack = new SolveEquation();

            for(int i=0;i<exp.length();i+=2) {
                char ch = exp.charAt(i);
                if (Character.isDigit(ch)) {
                    myStack.push(ch - '0');
                } else {
                    int val1= myStack.pop();
                    int val2=myStack.pop();

                    switch (ch){
                        case '+':
                            myStack.push(val1+val2);
                            break;
                        case '-':
                            myStack.push(val2-val1);
                            break;
                        case '*':
                            myStack.push(val1*val2);
                            break;
                        case '/':
                            myStack.push(val2/val1);
                            break;
                    }
                }
            }

            return myStack.pop();
        }

        // Utility function to add an element Digit to the stack
        public void push(int d){
            Digit digit = top;
            top=new Digit(d);
            top.next=digit;
            noOfDigits++;
        }

        // Utility function to pop a top element from the stack
        public int pop(){
            if(top==null){
                System.out.println("Stcack is empty");
                return -1;
            }
            int value=top.d;
            top=top.next;
            noOfDigits--;
            return value;
        }

        // Utility function to return the top element of the stack
        public int top(){
            return top.d;
        }

        // Utility function to check if the stack is empty or not
        public Boolean isEmpty(){
            return (noOfDigits==0);
        }

        // Utility function to return the size of the stack
        public int size() {
            return noOfDigits;
        }

    }

