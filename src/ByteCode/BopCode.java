package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {

    private String sign;
    private int ans;

    @Override
    public void init(ArrayList<String> args) {
        sign = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        ans = 0;
        int firstOp = vm.popRunStack();
        int secondOp = vm.popRunStack();

        if ("+".equals(sign)) {
            ans = firstOp + secondOp;
        } else if ("-".equals(sign)) {
            ans = secondOp - firstOp;
        } else if ("/".equals(sign)) {
            ans = secondOp / firstOp;
        } else if ("*".equals(sign)) {
            ans = secondOp * firstOp;
        } else if ("==".equals(sign)) {
            if (firstOp == secondOp) {
                ans = 1;
            }
        } else if ("!=".equals(sign)) {
            if (secondOp != firstOp) {
                ans = 1;
            }
        } else if ("<=".equals(sign)) {
            if (secondOp <= firstOp) {
                ans = 1;
            }
        } else if (">=".equals(sign)) {
            if (secondOp >= firstOp) {
                ans = 1;
            }
        } else if (">".equals(sign)) {
            if (secondOp > firstOp) {
                ans = 1;
            }
        } else if ("<".equals(sign)) {
            if (secondOp < firstOp) {
                ans = 1;
            }
        } else if ("|".equals(sign)) {
            if (firstOp == 1 || secondOp == 1) {
                ans = 1;
            }
        } else if ("&".equals(sign)) {
            if ((firstOp == 1) && (secondOp == 1)) {
                ans = 1;
            }
        } else {
            System.out.println("******  INVALID   *******");
        }
        vm.pushRunStack(ans);
    }

    @Override
    public String toString() {
        return ("BOP " + sign + "\n");
    }
}
