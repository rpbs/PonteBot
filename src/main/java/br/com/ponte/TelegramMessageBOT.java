package br.com.ponte;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Envia mensagem pro meu bot
 */
public class TelegramMessageBOT {

    private TelegramBot bot;

    public TelegramMessageBOT(String key) {
        this.bot = new TelegramBot(key);
    }

    public void Start(){

        bot.setUpdatesListener(updates -> {
            String opcao = updates.get(0).message().text();
            Long id = updates.get(0).message().chat().id();
            System.out.println(opcao);
            if (opcao.equals("ponte") || opcao.equals("Ponte")){
                bot.execute(new SendMessage(id, "Um instante..."));
                List<String> imagens = null;
                try {
                    imagens = ImageExtractor.extractImageUrl("https://www.rodosol.com.br/");
                    for (String img: imagens) {
                        bot.execute(new SendMessage(id, img));
                    }
                } catch (Exception e) {
                    bot.execute(new SendMessage(id, "Deu pau no site da rodosol!"));
                    return UpdatesListener.CONFIRMED_UPDATES_ALL;
                }

            } else {
                String msg = "Opcao errada!";
                ByteBuffer buffer = StandardCharsets.UTF_8.encode(msg);

                String utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();
                bot.execute(new SendMessage(id, utf8EncodedString));
            }

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
