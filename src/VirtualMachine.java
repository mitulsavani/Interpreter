package src;

import src.ByteCode.ByteCode;
import src.ByteCode.DumpCode;

import java.util.Stack;

public class VirtualMachine {

    protected boolean isDump;
    private RunTimeStack runStack;
    private int pc;
    private Stack<Integer> returnAddrs;
    private boolean isRunning;
    private Program program;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack();
        isRunning = true;

        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if (isDump) {
                if (!(code instanceof DumpCode)) {
                    System.out.println(code);
                    runStack.dump();
                }
            }
            pc++;
        }
    }

    public int getPC() {
        return pc;
    }

    public void setPC(int newPc) {
        pc = newPc;
    }

    public int popRunStack() {
        return runStack.pop();
    }

    public void pushRunStack(int i) {
        runStack.push(i);
    }

    public void pushRunStack(Integer i) {
        runStack.push(i);
    }

    public int peekRunStack() {
        return runStack.peek();
    }

    public void StackLoad(int num) {
        runStack.load(num);
    }

    public void stop() {
        isRunning = false;
    }

    public void newFrame(int offset) {
        runStack.newFrameAt(offset);
    }

    public int storeRunStack(Integer in) {
        return runStack.store(in);
    }

    public void pushReturnAdrs(int i) {
        returnAddrs.push(i);
    }

    public int popReturnAdrs() {
        return returnAddrs.pop();
    }

    public void RTpopFrame() {
        runStack.popFrame();
    }

    public void setDump(boolean dumpSet) {
        isDump = dumpSet;
    }

}
