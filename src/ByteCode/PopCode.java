package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {

    protected String arg;

    @Override
    public void init(ArrayList<String> args) {
        arg = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        for (int i = 0; i < Integer.parseInt(arg); i++) {
            vm.popRunStack();
        }
    }

    @Override
    public String toString() {
        return ("POP " + arg + "\n");
    }
}
        
