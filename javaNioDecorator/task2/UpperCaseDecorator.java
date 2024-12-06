package javaNioDecorator.task2;

public class UpperCaseDecorator extends TextDecorator {

    public UpperCaseDecorator(TextProcessor decoratedText) {
        super(decoratedText);
    }
    @Override
    public String process(String str) {
        return str.toUpperCase();
    }
}

