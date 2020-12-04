package project3.backend.model;
import javax.persistence.*;

@Entity
@Table(name = "page")
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPage;

    @Column(name = "url_page")
    private String urlPage;

    @Column(name = "note_page")
    private String notePage;

    public Page() {
    }

    public int getIdPage() {
        return idPage;
    }

    public void setIdPage(int idPage) {
        this.idPage = idPage;
    }

    public String getUrlPage() {
        return urlPage;
    }

    public void setUrlPage(String urlPage) {
        this.urlPage = urlPage;
    }

    public String getNotePage() {
        return notePage;
    }

    public void setNotePage(String notePage) {
        this.notePage = notePage;
    }
}
