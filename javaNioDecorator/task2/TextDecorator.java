package javaNioDecorator.task2;

abstract class TextDecorator implements TextProcessor {
    protected TextProcessor decoratedText;

    public TextDecorator(TextProcessor decoratedText) {
        this.decoratedText = decoratedText;
    }

     @Override
     public String process(String str) {
         return str;
     }
}
