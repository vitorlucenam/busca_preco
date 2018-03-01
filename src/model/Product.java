package model;

public class Search {
    private String name;
    private String link;
    private String url_image;
    private double price;

    public Product(String name, String link, String url_image, double price){
        super();
        this.name=name;
        this.link=link;
        this.url_image=url_image;
        this.price=price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
