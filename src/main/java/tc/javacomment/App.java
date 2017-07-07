package tc.javacomment;

import tc.fsm.Machine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        for (String fileName : args) {
            try (FileReader fh = new FileReader(fileName)) {
                String clean = stripCommentsFromFile(fh);
                System.out.println(clean);
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } finally {
                // pass
            }
        }
    }

    public static String stripCommentsFromFile(FileReader source) throws IOException {
        StringBuffer buf = new StringBuffer();
        Machine<Character, Character> dut = new Machine<>(new CodeState(buf),
                                                          new CodeStringState(buf),
                                                          new CodeStringEscapeState(buf),
                                                          new CommentPreState(buf),
                                                          new CommentLineState(buf),
                                                          new CommentMultiState(buf),
                                                          new CommentMultiPreExitState(buf));
        for (int raw = source.read(); raw != -1; raw = source.read()) {
            char ch = (char) raw;
            dut.process(ch);
        }
        return buf.toString();
    }
}
