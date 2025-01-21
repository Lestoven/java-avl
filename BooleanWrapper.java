public class BooleanWrapper {
    private boolean value;

    public BooleanWrapper(boolean value) { this.value = value; }
    
    public boolean getValue() { return value; }
    public void setValue(boolean value) { this.value = value; }
    public void toggle() { value = !value; }

    @Override
    public String toString() {
        return "%s".formatted(value);
    }
}