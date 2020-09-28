package be.ugent.reeks1;

public class BlogPost {
    private String titel;
    private String content;

    public BlogPost(){

    }

    public BlogPost(String titel,String content){
        this.titel=titel;
        this.content=content;
    }

    public String getTitel(){
        return titel;
    }

    public String getContent() {
        return content;
    }

    public void setTitel(String titel){
        this.titel = titel;
    }

    public void setContent(String content){
        this.content = content;
    }
}
