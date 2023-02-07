//package com.kirilyuk.agrigator.parser;
//
//import com.kirilyuk.agrigator.entities.Product;
//import com.kirilyuk.agrigator.service.ProductService;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class ProductParserTask {
//
//    public static final String INFO_TITLE = "productdescription";
//    public static final String IMG = "img.productPicture";
//    public static final String LINK = "a.breadcumbInternalLink";
//    public static final String UNIQUE = "span.productIdentifier";
//
//    private final ProductService service;
//    @Autowired
//    public ProductParserTask(ProductService service) {
//        this.service = service;
//    }
//
//    @Scheduled(fixedDelay = 10000)
//    public void parseProduct() {
//
//        String url = "https://mall.industry.siemens.com/mall/en/us/Catalog/Product/6RP00000AA250AA0";
//        String url2 ="https://mall.industry.siemens.com/mall/en/us/Catalog/Product/6RP00202AC325AA0";
//
//
//
//        try {
//            Document doc = Jsoup.connect(url2)
//                    .timeout(5000)
//                    .userAgent("GoogleChrome")
//                    .referrer("https://google.com")
//                    .get();
//
//            Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
//
//            Elements titleEl = doc.getElementsByClass(INFO_TITLE);
//            Elements infoEl = doc.getElementsByClass(INFO_TITLE);
//            Elements imgEl = doc.select(IMG);
//            Elements linkEl = doc.select(LINK);
//            Elements uniqueEl = doc.select(UNIQUE);
//
//            List<String> titleList = new ArrayList<>();
//            List<String> infoList = new ArrayList<>();
//            List<String> imgList = new ArrayList<>();
//            List<String> linkList = new ArrayList<>();
//            List<String> uniqueList = new ArrayList<>();
//
//            for (Element el : titleEl) {
//                String title = el.text();
//
//                if (!service.isExist(title)) {
//                    titleList.add(title);
//                }
//            }
//
//            for (Element el : infoEl) {
//                String info = el.text();
//
//                if (!service.isExist(info)) {
//                    infoList.add(info);
//                }
//            }
//
//            for (Element el : imgEl) {
//
//                String image = el.attr("src");
//
//                if (!service.isExist(image)) {
//                    imgList.add(image);
//                }
//            }
//
//            for (Element el : linkEl) {
//                String link = el.attr("href");
//
//                if (!service.isExist(link)) {
//                    linkList.add(link);
//                }
//            }
//
//            for (Element el : uniqueEl) {
//                String unique = el.text();
//
//                if (!service.isExist(unique)) {
//                    uniqueList.add(unique);
//                }
//            }
//
//            var i1 = titleList.iterator();
//            var i2 = infoList.iterator();
//            var i3 = imgList.iterator();
//            var i4 = linkList.iterator();
//            var i5 = uniqueList.iterator();
//
//            while (i1.hasNext() && i2.hasNext() && i3.hasNext() && i5.hasNext()) {
//                Product obj = new Product();
//                obj.setTitle(i1.next());
//                obj.setInfo(i2.next());
//                obj.setImage(i3.next());
//                obj.setLink_production(i4.next());
//                obj.setUnique_number(i5.next());
//                service.productSave(obj);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}