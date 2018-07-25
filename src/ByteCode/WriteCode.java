package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {

    @Override
    public void init(ArrayList<String> args) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("Answer is : " + vm.peekRunStack());
    }

    @Override
    public String toString() {
        return ("WRITE \n");
    }
}
