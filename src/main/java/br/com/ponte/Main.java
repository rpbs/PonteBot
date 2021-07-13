package br.com.ponte;

public class Main {
    public static final String botId = "1839921548:AAHibJpOmo8oiX8NuKJd8UcO3FC0kmwfMNY";

    public static void main(String[] args) {

        System.out.println(args);

        if (args.length == 0) {
            TelegramMessageBOT telegram = new TelegramMessageBOT(botId);

            telegram.Start();
        }
    }
}
