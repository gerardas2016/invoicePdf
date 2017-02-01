
package pdftest.data;

import java.util.ArrayList;

/**
 *
 * @author Gepardas
 */
public class Items {
    
    protected int quantity;
    protected String itemDescription;
    protected double unitPrice;
    protected double totalPrice;
    private ArrayList<Items> arrayList=new ArrayList<>();

    public Items() {
    }
    
    
    

    public Items(int quantity, String itemDescription, double unitPrice, double totalPrice) {
        this.quantity = quantity;
        this.itemDescription = itemDescription;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public Items(int quantity, String itemDescription, double unitPrice) {
        this.quantity = quantity;
        this.itemDescription = itemDescription;
        this.unitPrice = unitPrice;
    }
    
    

    public Items(ArrayList<Items> arrayList) {
        this.arrayList=arrayList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Items> getArrayList() {
       // arrayList.add(this.quantity,this.itemDescription, this.unitPrice, this.totalPrice);
        return arrayList;
    }

    public void setArrayList(ArrayList<Items> arrayList) {
     //  arrayList.addAll(arrayList);
        this.arrayList = arrayList;
    }
    
    
    
    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        this.totalPrice= unitPrice*quantity;
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        
    }
    
    public double getTotalItemsPrice(){
        double sum=0;
        for (Items items : arrayList) {
            sum+=items.getTotalPrice();    
        }
    return sum;
    }
    
    
    
    
}
