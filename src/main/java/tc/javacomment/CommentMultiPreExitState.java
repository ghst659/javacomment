package tc.javacomment;

import tc.fsm.ProcessResult;

public class CommentMultiPreExitState extends BaseState {
    public CommentMultiPreExitState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String nextState = this.name();
        switch (ch) {
            case '/':
                nextState = classTag(CodeState.class);
                break;
            default:
                nextState = classTag(CommentMultiState.class);
                break;
        }
        return new ProcessResult<>(nextState, ch);
    }
}
