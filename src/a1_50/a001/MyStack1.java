package a1_50.a001;

import java.util.Stack;

/**
 * 设计有getMin功能的栈
 * 要求实现pop，push，getMin操作都在O(1)时间内完成，
 * 不能遍历，所以要建立两个栈
 */
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum <= this.getMin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if (this.stackData.isEmpty()) return -1;
        int v = this.stackData.pop();
        if (v == this.getMin()) this.stackMin.pop();
        return v;
    }

    public int getMin(){
        if (this.stackMin.isEmpty()) return -1;
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(8);
        myStack1.push(2);
        myStack1.push(1);
        myStack1.push(3);
        System.out.println(myStack1.getMin());

    }

}
