package tc.javacomment;

import tc.fsm.ProcessResult;

public class CodeStringEscapeState extends BaseState {
    public CodeStringEscapeState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String target = CodeStringState.classTag(CodeStringState.class);
        Character result = ch;
        buffer.append(ch);
        return new ProcessResult<>(target, result);
    }
}
