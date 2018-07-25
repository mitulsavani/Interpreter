package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {

    private String label;
    private int num;

    @Override
    public void init(ArrayList<String> args) {
        num = Integer.parseInt(args.get(0));
        label = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.StackLoad(num);
    }

    @Override
    public String toString() {
        return ("LOAD " + num + " " + label + "\n");
    }
}
