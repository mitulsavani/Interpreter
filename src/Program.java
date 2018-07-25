package src;


import src.ByteCode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return program.get(pc);
    }

    public int getSize() {
        return program.size();
    }

    public void add(ByteCode className) {
        program.add(className);
    }

    public void resolveAddrs(Program program) {
        HashMap<String, Integer> labelHash = new HashMap<>();

        for (int i = 0; i < program.getSize(); i++) {
            if (program.getCode(i) instanceof LabelCode) {
                LabelCode code = (LabelCode) program.getCode(i);
                labelHash.put(code.getLabel(), i);
            }
        }

        for (int i = 0; i < program.getSize(); i++) {
            if (program.getCode(i) instanceof GotoCode) {
                if (labelHash.containsKey(((GotoCode) program.getCode(i)).getLabel())) {
                    ((GotoCode) program.getCode(i)).setArg(labelHash.get(((GotoCode) program.getCode(i)).getLabel()));
                }
            } else if (program.getCode(i) instanceof FalseBranchCode) {
                if (labelHash.containsKey(((FalseBranchCode) program.getCode(i)).getLabel())) {
                    ((FalseBranchCode) program.getCode(i)).setArg(labelHash.get(((FalseBranchCode) program.getCode(i)).getLabel()));
                }
            } else if (program.getCode(i) instanceof CallCode) {
                if (labelHash.containsKey(((CallCode) program.getCode(i)).getLabel())) {
                    ((CallCode) program.getCode(i)).setArg(labelHash.get(((CallCode) program.getCode(i)).getLabel()));
                }
            }
        }
    }
}





