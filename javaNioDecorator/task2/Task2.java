package javaNioDecorator.task2;

public class Task2 {
    public static void main(String[] args) {

        //simple
        TextProcessor simpleText = new SimpleTextProcessor();
        System.out.println(simpleText.process("  Hello world !!!  "));

        //upper case
        TextProcessor upperCaseDecorated = new UpperCaseDecorator(simpleText);
        System.out.println(upperCaseDecorated.process("  Hello world !!!  "));

        //trim
        TextProcessor trimDecorated = new TrimDecorator(simpleText);
        System.out.println(trimDecorated.process("  Hello world !!!  "));

        //replace
        TextProcessor replaceDecorated = new ReplaceDecorator(simpleText);
        System.out.println(replaceDecorated.process("  Hello world !!!  "));
    }
}
