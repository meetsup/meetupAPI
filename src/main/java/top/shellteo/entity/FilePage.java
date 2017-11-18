package top.shellteo.entity;

import java.io.Serializable;

/**
 * Created by HP on 2017/11/18.
 */
public class FilePage implements Serializable {
    private String url;

    public FilePage() {
    }

    public FilePage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
