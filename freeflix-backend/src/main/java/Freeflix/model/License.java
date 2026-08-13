package Freeflix.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("licenses")
public class License {
  @Id
  private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRightsHolder() {
        return rightsHolder;
    }

    public void setRightsHolder(String rightsHolder) {
        this.rightsHolder = rightsHolder;
    }

    public String getTermsUrl() {
        return termsUrl;
    }

    public void setTermsUrl(String termsUrl) {
        this.termsUrl = termsUrl;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
  private String source; // "PUBLIC_DOMAIN" or "INDIE_PARTNER"
  private String rightsHolder;
  private String termsUrl;
  private boolean valid;
  // getters/setters
}