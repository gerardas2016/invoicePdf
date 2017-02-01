
package pdftest.data;

/**
 *
 * @author Gerardas Butkevicius
 */
public class MarketInfo {
    
    private String webSiteName;
    private String websitePath;
    
    public MarketInfo(String webSiteName, String websitePath) {
        this.webSiteName = webSiteName;
        this.websitePath = websitePath;
    }

    public MarketInfo(String webSiteName) {
        this.webSiteName = webSiteName;
    }

    public void setWebSiteName(String webSiteName) {
        this.webSiteName = webSiteName;
    }

    public void setWebsitePath(String websitePath) {
        this.websitePath = websitePath;
    }
   


    public String getWebSiteName() {
        return webSiteName;
    }

    public String getWebsitePath() {
        return websitePath;
    }
    
    
    
    
}
