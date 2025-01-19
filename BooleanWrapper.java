public class BooleanWrapper {
    private boolean value;

    public BooleanWrapper(boolean value) { this.value = value; }
    
    public void toggle() { value = !value; }
    public boolean getValue() { return value; }
}