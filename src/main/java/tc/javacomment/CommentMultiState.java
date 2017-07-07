package tc.javacomment;

import tc.fsm.ProcessResult;

public class CommentMultiState extends BaseState {
    public CommentMultiState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String target = this.name();
        Character result = ch;
        switch (ch) {
            case '*':
                target = classTag(CommentMultiPreExitState.class);
                break;
            default:
                break;
        }
        return new ProcessResult<>(target, result);
    }
}
