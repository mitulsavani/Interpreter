package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {

    @Override
    public void init(ArrayList<String> args) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.stop();
    }

    @Override
    public String toString() {
        return ("HALT \n");
    }
}
