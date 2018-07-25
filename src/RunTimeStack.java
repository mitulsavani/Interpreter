package src;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer, frmHolder;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        framePointer.add(0);
    }

    public void dump() {
        int frameStackSize = framePointer.size() - 1;
        boolean Comma = true;

        if (!runTimeStack.isEmpty()) {
            frmHolder = new Stack();

            for (int i = frameStackSize; i >= 0; i--) {
                frmHolder.push(framePointer.get(i));
            }
            System.out.print("[");
            for (int i = 0; i < runTimeStack.size(); i++) {
                if (!frmHolder.empty()) {
                    if ((frmHolder.peek() == i) && i != 0) {
                        System.out.print(runTimeStack.get(i) + "] [");
                        frmHolder.pop();
                    }
                }
                if (!frmHolder.empty()) {
                    if (((frmHolder.peek() == (i + 1)))) {
                        Comma = false;
                    }
                }
                System.out.print(runTimeStack.get(i));
                if ((runTimeStack.size() != 1) && ((runTimeStack.size() - 1) != i) && Comma) {
                    System.out.print(",");
                }
                if (!Comma) {
                    Comma = true;
                }
            }
            System.out.println("]");
        } else {
            System.out.println("[]");
        }
    }

    public int peek() {
        if (!runTimeStack.isEmpty()) {
            int arg = runTimeStack.get(runTimeStack.size() - 1);
            return arg;
        }
        return 0;
    }

    public int pop() {
        if (!runTimeStack.isEmpty()) {
            return runTimeStack.remove(runTimeStack.size() - 1);
        }

        return -1;
    }

    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public Integer push(Integer x) {
        runTimeStack.add(x);
        return x;
    }

    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size() - offset);
    }

    void popFrame() {
        int top = runTimeStack.remove(runTimeStack.size() - 1);
        int topValue = framePointer.pop();
        int size = runTimeStack.size();

        for (int i = size - 1; i >= topValue; i--) {
            runTimeStack.remove(i);
        }
        runTimeStack.add(top);
    }

    public int store(int offset) {
        runTimeStack.set(framePointer.peek() + offset, runTimeStack.remove(runTimeStack.size() - 1));
        return offset;
    }

    public int load(int offset) {
        int getVal = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(getVal);
        return getVal;
    }
}
