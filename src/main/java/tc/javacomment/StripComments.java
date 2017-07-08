package tc.javacomment;

import tc.fsm.Machine;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class StripComments {
    public static void main(String[] args) {
        for (String fileName : args) {
            try (Reader source = new FileReader(fileName)) {
                String clean = stripCommentsFromFile(source);
                System.out.println(clean);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } finally {
                // pass
            }
        }
    }

    public static String stripCommentsFromFile(Reader source) throws IOException {
        StringBuffer buf = new StringBuffer();
        Machine<Character, Character> dut = new Machine<>(new CodeState(buf),
                                                          new CodeStringState(buf),
                                                          new CodeStringEscapeState(buf),
                                                          new CommentPreState(buf),
                                                          new CommentLineState(buf),
                                                          new CommentMultiState(buf),
                                                          new CommentMultiPreExitState(buf));
        for (int raw = source.read(); raw != -1; raw = source.read()) {
            dut.process((char) raw);
        }
        return buf.toString();
    }
}
