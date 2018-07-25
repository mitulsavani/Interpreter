package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {

    protected String label;
    protected int num;

    @Override
    public void init(ArrayList<String> args) {
        num = Integer.parseInt(args.get(0));
        label = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.storeRunStack(num);
    }

    @Override
    public String toString() {
        return ("STORE " + num + " " + label + "\n");
    }
}
