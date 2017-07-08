package tc.javacomment;

import tc.fsm.ProcessResult;

class CodeState extends BaseState {
    public CodeState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String nextState = this.name();
        switch (ch) {
            case '"':
                nextState = classTag(CodeStringState.class);
                buffer.append(ch);
                break;
            case '/':
                nextState = classTag(CommentPreState.class);
                break;
            default:
                buffer.append(ch);
                break;
        }
        return new ProcessResult<>(nextState, ch);
    }
}
