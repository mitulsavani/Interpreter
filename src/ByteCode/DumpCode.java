package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {

    private String arg;
    private boolean dumpState;

    @Override
    public void init(ArrayList<String> args) {
        arg = args.get(0);

        if (arg.equals("ON")) {
            dumpState = true;
        } else {
            dumpState = false;
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.setDump(dumpState);
    }

    @Override
    public String toString() {
        if (dumpState) {
            return ("DUMP ON");
        } else {
            return ("DUMP OFF");
        }
    }
}
