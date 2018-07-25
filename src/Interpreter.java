package src;

import java.io.IOException;

/**
 * <pre>
 *     Interpreter class runs the src:
 *     1. Perform all initializations
 *     2. Load the bytecodes from file
 *     3. Run the virtual machine
 * </pre>
 */
public class Interpreter {

    private ByteCodeLoader bcl;

    public Interpreter(String codeFile) {
        try {
            CodeTable.init();
            bcl = new ByteCodeLoader(codeFile);
        } catch (IOException e) {
            System.out.println("**** " + e);
        }
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("***Incorrect usage, try: java src.Interpreter <file>");
            System.exit(1);
        }
        (new Interpreter(args[0])).run();
    }

    void run() {
        Program program = bcl.loadCodes();
        VirtualMachine vm = new VirtualMachine(program);
        vm.executeProgram();
    }
}
