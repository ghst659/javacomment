package tc.javacomment;

import tc.fsm.ProcessResult;

public class CommentPreState extends BaseState {
    public CommentPreState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String nextState = this.name();
        switch (ch) {
            case '/':
                nextState = classTag(CommentLineState.class);
                break;
            case '*':
                nextState = classTag(CommentMultiState.class);
                break;
            default:
                nextState = classTag(CodeState.class);
                buffer.append('/');
                buffer.append(ch);
                break;
        }
        return new ProcessResult<>(nextState, ch);
    }
}
