package sharknado.project.weatherapp.responses.CurrentObservations;

/**
 * Created by Michael Leffert on 12/8/2015.
 */
public class image {
    String url, title, link;

    public image(String url, String title, String link) {
        this.url = url;
        this.title = title;
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
