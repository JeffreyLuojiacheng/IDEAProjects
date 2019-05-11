package a1_50.a002;

import java.util.Stack;

/**
 * 用两个栈实现队列的add poll peek 方法
 *
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;
    public TwoStackQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    private void pushToPop(){
        if (stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
        pushToPop();
    }

    public int poll(){
        if (stackPop.empty() && stackPush.empty())
            return -1;
        pushToPop();
        return stackPop.pop();

    }
    public int peek(){
        if (stackPop.empty() && stackPush.empty())
            return -1;
        pushToPop();
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue t = new TwoStackQueue();
        t.add(8);
        t.add(10);
        System.out.println(t.peek());
        System.out.println(t.poll());
        System.out.println(t.peek());
    }
}
