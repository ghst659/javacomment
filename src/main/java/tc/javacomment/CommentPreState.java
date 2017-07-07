package tc.javacomment;

import tc.fsm.ProcessResult;

public class CommentPreState extends BaseState {
    public CommentPreState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String target = this.name();
        Character result = ch;
        switch (ch) {
            case '/':
                target = classTag(CommentLineState.class);
                break;
            case '*':
                target = classTag(CommentMultiState.class);
                break;
            default:
                target = classTag(CodeState.class);
                buffer.append('/');
                buffer.append(ch);
                break;
        }
        return new ProcessResult<>(target, result);
    }
}
