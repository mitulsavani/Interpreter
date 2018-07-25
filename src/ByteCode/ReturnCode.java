package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {

    protected String label;

    @Override
    public void init(ArrayList<String> args) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setPC(vm.popReturnAdrs());
        vm.RTpopFrame();
    }

    @Override
    public String toString() {
        return "RETURN";
    }
}
