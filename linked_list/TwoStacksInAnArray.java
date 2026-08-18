import java.util.*;

//TODO:

public class TwoStacksInAnArray {

    public static class TwoStack {

        int[] arr;

        int tos1;
        int tos2;

        public TwoStack(int cap) {

            arr = new int[cap];

            // Initialize top pointers
            // Stack 1 should start from the left
            // Stack 2 should start from the right

        }

        int size1() {
            // write your code
            return 0;
        }

        int size2() {
            // write your code
            return 0;
        }

        void push1(int val) {
            // write your code
        }

        void push2(int val) {
            // write your code
        }

        int pop1() {
            // write your code
            return -1;
        }

        int pop2() {
            // write your code
            return -1;
        }

        int top1() {
            // write your code
            return -1;
        }

        int top2() {
            // write your code
            return -1;
        }
    }

    public static void main(String[] args) {

        TwoStack st = new TwoStack(10);

        st.push1(10);
        st.push1(20);
        st.push1(30);

        st.push2(90);
        st.push2(80);
        st.push2(70);

        System.out.println("Stack 1 top: " + st.top1());
        System.out.println("Stack 2 top: " + st.top2());

        System.out.println("Stack 1 pop: " + st.pop1());
        System.out.println("Stack 2 pop: " + st.pop2());

        System.out.println("Stack 1 top: " + st.top1());
        System.out.println("Stack 2 top: " + st.top2());
    }
}