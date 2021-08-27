package br.com.ponte;

public class Main {
    public static final String botId = "ID:CHAVE";

    public static void main(String[] args) {

        System.out.println(args);

        if (args.length == 0) {
            TelegramMessageBOT telegram = new TelegramMessageBOT(botId);

            telegram.Start();
        }
    }
}
