package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {

    protected String label;
    protected String arg;
    protected Integer literal;

    @Override


    public void init(ArrayList<String> args) {
        arg = args.get(0);
        literal = Integer.parseInt(arg);
        if (args.size() > 1) {
            label = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushRunStack(literal);
    }

    @Override
    public String toString() {
        return ("LABEL " + arg + "\n");

    }
}

