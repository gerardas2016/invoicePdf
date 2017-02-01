
package pdftest.data;

/**
 *
 * @author Gerardas
 */
public class Seller {
    
    private String name="JSC Name";
    private String company="COMPANY NO: 674744";
    private String vat= "VAT NO.LT100010244812";
    private String adress= "Street 31-22";
    private String adress2="VILNIUS, LT-03114";
    private String country= "LITHUANIA";

    public Seller() {
    }

    public Seller(String name, String company, String vat, String adress, String adress2, String country) {
        this.name = name;
        this.company = company;
        this.vat = vat;
        this.adress = adress;
        this.adress2 = adress2;
        this.country = country;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress2() {
        return adress2;
    }

    public void setAdress2(String adress2) {
        this.adress2 = adress2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return  name+ "\n"+ company+ "\n"+ vat+"\n"+ adress+ "\n"+ adress2+ "\n"+country;
    }
    
    
}
