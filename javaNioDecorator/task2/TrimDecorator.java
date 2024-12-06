package javaNioDecorator.task2;

public class TrimDecorator extends TextDecorator {
    public TrimDecorator(TextProcessor decoratedText) {
        super(decoratedText);
    }
    @Override
    public String process(String str) {
        return str.trim();
    }
}
