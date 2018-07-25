package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {

    protected String label;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
    }

    @Override
    public String toString() {
        return ("LABEL " + label + "\n");
    }

    public String getLabel() {
        return label;
    }
}
