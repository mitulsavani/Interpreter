package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {

    protected String label;
    protected int arg;

    public GotoCode() {
    }

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setPC(arg);
    }

    @Override
    public String toString() {
        return ("GOTO " + label + "\n");
    }

    public void setArg(int arg) {
        this.arg = arg;
    }

    public String getLabel() {
        return label;
    }
}
