
package pdftest.data;

/**
 *
 * @author Gerardas Butkevicius
 */
public class Total {
    
    
    
    protected double totalExcVat;
    protected double totalEcvVatWithDiscount;
    protected int vat; //Vat %
    protected double vatSum;
    protected double totalIncVat;
    protected double excangeRateToEur;
    protected double totalInEur;
    
    
    

    public Total() {
    }

    public Total(int vat, double excangeRateToEur) {
        this.vat = vat;
        this.excangeRateToEur = excangeRateToEur;
    }

    
   

    public double getTotalEcvVatWithDiscount() {
        return totalEcvVatWithDiscount;
    }

    public void setTotalEcvVatWithDiscount(double totalEcvVatWithDiscount) {
        this.totalEcvVatWithDiscount = totalEcvVatWithDiscount;
    }
      
      

    public double getVatSum() {
        vatSum=totalExcVat*vat/100;
        return vatSum;
    }

    public void setVatSum(double vatSum) {
        this.vatSum = vatSum;
    }
      
      

    public double getTotalExcVat(Items items) {
        totalExcVat= items.getTotalItemsPrice();
        return totalExcVat;
    }

    public void setTotalExcVat(double totalExcVat) {
        this.totalExcVat = totalExcVat;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public double getTotalIncVat() {
        totalIncVat=vatSum+totalExcVat;
        return totalIncVat;
    }

    public void setTotalIncVat(double totalIncVat) {
        this.totalIncVat = totalIncVat;
    }

    public double getExcangeRateToEur() {
        return excangeRateToEur;
    }

    public void setExcangeRateToEur(double excangeRateToEur) {
        this.excangeRateToEur = excangeRateToEur;
    }

    public double getTotalInEur() {
        
        totalInEur= totalIncVat*excangeRateToEur;
        return totalInEur;
    }

    public void setTotalInEur(double totalInEur) {
        this.totalInEur = totalInEur;
    }

  
    
    
    
    
}
