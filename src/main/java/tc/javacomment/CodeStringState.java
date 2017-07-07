package tc.javacomment;

import tc.fsm.ProcessResult;

public class CodeStringState extends BaseState {
    public CodeStringState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String target = this.name();
        Character result = ch;
        switch (ch) {
            case '\\':
                target = classTag(CodeStringEscapeState.class);
                break;
            case '"':
                target = classTag(CodeState.class);
                break;
            default:
                break;
        }
        buffer.append(ch);
        return new ProcessResult<>(target, result);
    }
}
