package src;

import src.ByteCode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {
    //started

    private BufferedReader byteSource;
    private Program program = new Program();

    public ByteCodeLoader(String file) throws IOException {
        byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts.
     * Grab correct class name for the given bytecode from CodeTable
     * create an instance of the bytecode class name returned from code table.
     * Parse any additional arguments for the given bytecode and send them to
     * the newly created bytecode instance via the init function.
     *
     * @return
     */
    public Program loadCodes() {
        String line;
        StringTokenizer tokenizer;
        String eachchar;

        try {
            while ((line = byteSource.readLine()) != null) {

                tokenizer = new StringTokenizer(line);

                eachchar = tokenizer.nextToken();


                String className = CodeTable.getClassName(eachchar);
                ByteCode bytes = (ByteCode) (Class.forName("src.ByteCode." + className).newInstance());
                ArrayList<String> argHolder = new ArrayList<>();
                while (tokenizer.hasMoreTokens()) {
                    argHolder.add(tokenizer.nextToken());
                }
                bytes.init(argHolder);
                program.add(bytes);
            }
            program.resolveAddrs(program);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
        return program;
    }
}
