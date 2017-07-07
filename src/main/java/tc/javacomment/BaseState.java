package tc.javacomment;

import tc.fsm.State;

abstract class BaseState implements State<Character, Character> {
    protected StringBuffer buffer = null;
    protected BaseState(StringBuffer buffer) {
        this.buffer = buffer;
    }
    protected static String classTag(Class cls) {
        String fullName = cls.getName();
        int dot = fullName.lastIndexOf('.');
        return fullName.substring(dot + 1);
    }
    public String name() {
        return classTag(this.getClass());
    }
}
