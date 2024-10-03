class Website{
    private String domain;
    private boolean eComEnabled;
    private boolean blogEnabled;
    private int storage;
    private String template;

    private Website(WebsiteBuilder websiteBuilder){
        this.template = websiteBuilder.template;
        this.storage  = websiteBuilder.storage;
        this.domain = websiteBuilder.domain;
        this.storage = websiteBuilder.storage;
        this.blogEnabled = websiteBuilder.blogEnabled;
        this.eComEnabled = websiteBuilder.eComEnabled;
    }

    public String toString(){
        return this.domain + " "+ this.storage;
    }
    static class WebsiteBuilder{
        String domain;
        boolean eComEnabled;
        boolean blogEnabled;
        int storage;
        String template;


        public WebsiteBuilder(String domain){
            this.domain = domain;
        }
        public WebsiteBuilder setEComEnabled(){
            this.eComEnabled = true;
            return this;
        }
        public WebsiteBuilder setBlogEnabled(){
            this.blogEnabled = true;
            return this;
        }
        public WebsiteBuilder setStorage(int storage){
            this.storage = storage;
            return this;
        }
        public WebsiteBuilder setTemplate(String template){
            this.template = template;
            return this;
        }

        public Website build(){
            return new Website(this);
        }
    }
}
public class BuilderDesignPattern {
    public static void main(String[] args) {
        Website website = new Website.WebsiteBuilder("test.com")
                .setEComEnabled()
                .setBlogEnabled()
                .setStorage(100)
                .setTemplate("test")
                .build();
        System.out.println(website);
    }
}
