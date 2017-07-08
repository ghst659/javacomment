package tc.javacomment;

import tc.fsm.ProcessResult;

public class CodeStringState extends BaseState {
    public CodeStringState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String nextState = this.name();
        switch (ch) {
            case '\\':
                nextState = classTag(CodeStringEscapeState.class);
                break;
            case '"':
                nextState = classTag(CodeState.class);
                break;
            default:
                break;
        }
        buffer.append(ch);
        return new ProcessResult<>(nextState, ch);
    }
}
