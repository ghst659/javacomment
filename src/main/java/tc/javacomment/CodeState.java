package tc.javacomment;

import tc.fsm.ProcessResult;

class CodeState extends BaseState {
    public CodeState(StringBuffer buf) {
        super(buf);
    }
    @Override
    public ProcessResult<Character> process(Character ch) {
        String target = this.name();
        Character result = ch;
        switch (ch) {
            case '"':
                target = classTag(CodeStringState.class);
                buffer.append(ch);
                break;
            case '/':
                target = classTag(CommentPreState.class);
                break;
            default:
                buffer.append(ch);
                break;
        }
        return new ProcessResult<>(target, result);
    }
}
