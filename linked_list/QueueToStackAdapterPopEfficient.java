import java.util.*;

public class QueueToStackAdapterPopEfficient {

    public static class QueueToStackAdapter {

        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            // write your code here
            return 0;
        }

        //Approach 1

        void push(int val) {

            while(mainQ.size() > 0){
                helperQ.add(mainQ.remove());
            }

            mainQ.add(val);

             while(helperQ.size() > 0){
                mainQ.add(helperQ.remove());
            }
        }

        //Approach 2

        //  void push(int val) {

        //     while(mainQ.size() > 0){
        //         helperQ.add(mainQ.remove());
        //     }

        //     mainQ.add(val);

        //      while(helperQ.size() > 0){
        //         mainQ.add(helperQ.remove());
        //     }
        // }

        int pop() {
            if(mainQ.size() == 0){
                return -1;
            } else {
                return mainQ.remove();
            }
        }

        int top() {
            if(mainQ.size() == 0){
                return -1;
            } else {
                return mainQ.peek();
            }
        }
    }

    public static void main(String[] args) {

        QueueToStackAdapter st = new QueueToStackAdapter();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}