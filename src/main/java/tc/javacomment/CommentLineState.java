package tc.javacomment;

import tc.fsm.ProcessResult;

public class CommentLineState extends BaseState {
    public CommentLineState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String target = this.name();
        Character result = ch;
        switch (ch) {
            case '\n':
                target = classTag(CodeState.class);
                buffer.append(ch);
                break;
            default:
                break;
        }
        return new ProcessResult<>(target, result);
    }
}
