
package pdftest.data;

/**
 *
 * @author Gerardas
 */
public class Order {
    private String id;
    private String buyerName;
    private String invoiceNum;
    private String date;
    

    public Order() {
    }

    public Order(String date, String invoiceNum) {
        this.date = date;
        this.invoiceNum = invoiceNum;
        
    }

    
    
    
    public Order(String id, String buyerName, String invoiceNum, String date) {
        this.id = id;
        this.buyerName = buyerName;
        this.invoiceNum = invoiceNum;
        this.date = date;
    }
    
    
    
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   
    
}
