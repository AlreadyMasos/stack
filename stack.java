

public class stack {
    public int length;
    public String[] stack;
    public int Index;

    public stack(int size) {
        length = size;
        Index = -1;
        stack = new String[length];
    }
    public boolean isEmpty() {
        if (Index == -1) {
            return true;
        }
        return false;
    }
    public void push(String value) {
        Index += 1;
        length += 1;
        stack[Index] = value;
    }
    public String pop() {
        String Out = stack[Index];
        length -= 1;
        Index -= 1;
        return Out;
    }
}