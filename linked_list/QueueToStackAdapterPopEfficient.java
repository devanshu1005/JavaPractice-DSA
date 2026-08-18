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

        void push(int val) {

            while(mainQ.size() > 0){
                helperQ.push(mainQ.remove());
            }
            
            mainQ.push(val);

             while(helperQ.size() > 0){
                mainQ.push(helperQ.remove());
            }
        }

        int pop() {
            // write your code here
            return -1;
        }

        int top() {
            // write your code here
            return -1;
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