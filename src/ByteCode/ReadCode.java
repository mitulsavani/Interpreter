package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {

    protected int num;

    @Override
    public void init(ArrayList<String> args) {
    }

    @Override
    public void execute(VirtualMachine vm) {

        Scanner in = new Scanner(System.in);
        System.out.print("Please Enter a Number : ");
        num = in.nextInt();
        vm.pushRunStack(num);
    }

    @Override
    public String toString() {
        return ("Read \n");
    }
}
