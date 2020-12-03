import java.util.Stack;

/*
    这里考察的主要是对队列和栈的理解。队列先进先出，栈先进后出。
    利于一个栈保存每次push的元素，然后pop到另外一个栈里面，再pop即是队列pop的结果。
 */

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() != 0)
            return stack2.pop();
        else
        {
            while (stack1.size() != 0)
                stack2.push(stack1.pop());
            return stack2.pop();
        }
    }
}