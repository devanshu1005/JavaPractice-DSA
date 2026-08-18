import java.util.*;

public class QueueToStackAdapterPushEfficient {

    public static class QueueToStackAdapter {

        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            mainQ.add(val);
        }

        int pop() {
         if(mainQ.size() == 0){
            return -1;
         } else {
            while(mainQ.size() > 1){
                helperQ.add(mainQ.remove());
            }
            int ans = mainQ.remove();
            // helperQ.add(mainQ.remove());

            Queue<Integer> temp = new ArrayDeque<>();
            temp = mainQ;
            mainQ = helperQ;
            helperQ = temp;
            return ans;
         }
        }

    int top() {
       if(mainQ.size() == 0){
            return -1;
         } else {
            while(mainQ.size() > 1){
                helperQ.add(mainQ.remove());
            }
            int ans = mainQ.peek();
            helperQ.add(mainQ.remove());

            Queue<Integer> temp = new ArrayDeque<>();
            temp = mainQ;
            mainQ = helperQ;
            helperQ = temp;
            return ans;
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