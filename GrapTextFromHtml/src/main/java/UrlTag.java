public class UrlTag {

    private String url;
    private String name;
    private String text;

    public UrlTag(String url, String name) {
        this.url = url;
        this.name = name;
        text = null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText(){
        return text;
    }


}
