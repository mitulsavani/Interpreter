package src.ByteCode;

import src.VirtualMachine;

import java.util.ArrayList;

/**
 * An abstract class
 */
public abstract class ByteCode {

    public abstract void init(ArrayList<String> args);

    public abstract void execute(VirtualMachine vm);

}
