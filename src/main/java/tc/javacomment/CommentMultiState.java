package tc.javacomment;

import tc.fsm.ProcessResult;

public class CommentMultiState extends BaseState {
    public CommentMultiState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String nextState = this.name();
        switch (ch) {
            case '*':
                nextState = classTag(CommentMultiPreExitState.class);
                break;
            default:
                break;
        }
        return new ProcessResult<>(nextState, ch);
    }
}
