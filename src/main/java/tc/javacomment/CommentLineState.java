package tc.javacomment;

import tc.fsm.ProcessResult;

public class CommentLineState extends BaseState {
    public CommentLineState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String nextState = this.name();
        switch (ch) {
            case '\n':
                nextState = classTag(CodeState.class);
                buffer.append(ch);
                break;
            default:
                break;
        }
        return new ProcessResult<>(nextState, ch);
    }
}
