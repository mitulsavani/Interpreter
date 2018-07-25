package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {

    protected String label;
    protected int arg;

    public FalseBranchCode() {
    }

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if (vm.popRunStack() == 0) {
            vm.setPC(arg);
        }
    }

    @Override
    public String toString() {
        return ("FALSEBRANCH " + label + "\n");
    }

    public void setArg(Integer arg) {
        this.arg = arg;
    }

    public String getLabel() {
        return label;
    }
}
