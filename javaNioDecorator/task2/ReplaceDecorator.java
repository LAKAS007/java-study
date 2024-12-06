package javaNioDecorator.task2;

public class ReplaceDecorator extends TextDecorator {

    public ReplaceDecorator(TextProcessor decoratedText) {
        super(decoratedText);
    }
    @Override
    public String process(String str) {
        return str.replace(' ', '_');
    }
}
