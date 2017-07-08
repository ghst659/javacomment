package tc.javacomment;

import tc.fsm.ProcessResult;

public class CodeStringEscapeState extends BaseState {
    public CodeStringEscapeState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String nextState = CodeStringState.classTag(CodeStringState.class);
        buffer.append(ch);
        return new ProcessResult<>(nextState, ch);
    }
}
