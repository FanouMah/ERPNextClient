package itu.prom16.ERPNextClient.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Fanou
 */
public class LangueDTO {
    @JsonProperty("language_code")
    private String languageCode;

    @JsonProperty("language_name")
    private String languageName;

    public LangueDTO() {
    }

    public LangueDTO(String languageCode, String languageName) {
        this.languageCode = languageCode;
        this.languageName = languageName;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    
}
