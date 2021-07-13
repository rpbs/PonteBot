package br.com.ponte;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ImageExtractor {
    public static List<String> extractImageUrl(String url) {
        List<String> imagens = new ArrayList<>();
        try {

            Document document = Jsoup.connect(url).get();

            Elements imgs = document.getElementsByTag("img");
            for (Element e : imgs) {
                String foto = e.attr("src").toString();
                if (foto.contains("camera01") || foto.contains("camera07")){
                    imagens.add(foto);
                }

            }
            return imagens;
        } catch (Exception e) {
            return null;
        }
    }
}
