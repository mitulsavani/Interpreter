package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {

    private String label;
    private int arg;

    public CallCode() {
    }

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAdrs(vm.getPC());
        vm.setPC(arg);
    }

    @Override
    public String toString() {
        return ("CAll " + label + "\n");

    }

    public void setArg(Integer arg) {
        this.arg = arg;
    }

    public String getLabel() {
        return label;
    }
}
