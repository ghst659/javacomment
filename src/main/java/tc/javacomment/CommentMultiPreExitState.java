package tc.javacomment;

import tc.fsm.ProcessResult;

public class CommentMultiPreExitState extends BaseState {
    public CommentMultiPreExitState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String target = this.name();
        Character result = ch;
        switch (ch) {
            case '/':
                target = classTag(CodeState.class);
                break;
            default:
                target = classTag(CommentMultiState.class);
                break;
        }
        return new ProcessResult<>(target, result);
    }
}
