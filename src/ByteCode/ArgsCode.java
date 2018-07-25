package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {

    private String arg;

    @Override
    public void init(ArrayList<String> args) {
        arg = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrame(Integer.parseInt(arg));
    }

    @Override
    public String toString() {
        return ("ARGS " + arg + "\n");
    }
}
