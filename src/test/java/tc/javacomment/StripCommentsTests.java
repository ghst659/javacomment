package tc.javacomment;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class StripCommentsTests {
    @Test
    public void testApp() {
        String source = String.join(
            "\n",
            "/**",
            " * basic javadoc comment",
            "",
            " */",
            "class foo {",
            "    /* main entry point */",
            "    public static void main(String[] args) { // this is an end of line comment",
            "	System.out.print(\"Hello /*\" /* plus */ + \"world\");",
            "	String tail = \"*/ \\\"tail\\\".\";",
            "   int y = 10 / /*five*/ 5;",
            "	// end of program",
            "    }",
            "}"
        );
        String expected = String.join(
            "\n",
            "",
            "class foo {",
            "    ",
            "    public static void main(String[] args) { ",
            "	System.out.print(\"Hello /*\"  + \"world\");",
            "	String tail = \"*/ \\\"tail\\\".\";",
            "   int y = 10 /  5;",
            "	",
            "    }",
            "}"
            );
        Reader src = new StringReader(source);
        try {
            String clean = StripComments.stripCommentsFromFile(src);
            Assert.assertEquals(expected, clean);
        } catch (IOException e) {
            Assert.fail();
        }
    }
}
