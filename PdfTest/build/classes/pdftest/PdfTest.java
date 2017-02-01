
package pdftest;

import java.io.File;
import pdftest.pdf.PdfFactory2;
import java.io.IOException;
import java.util.ArrayList;
import pdftest.data.MarketInfo;
import pdftest.data.Order;
import pdftest.data.Seller;
import pdftest.data.Buyer;
import pdftest.data.Items;
import pdftest.data.Total;

/**
 *
 * @author Gerardas Butkevicius
 */
public class PdfTest {

    
    //Path to created Pdf
   public static final String DEST2 = "C:/Users/Gepardas/Desktop/pdfExamples/Invoice.pdf";
    public static final String DEST3 = "C:/Users/Gepardas/Desktop/pdfExamples/Invoice.pdf";
    
    public static void main(String[] args) throws IOException {
        
        
        Order order = new Order("2017/01/01", "KL09778586474");
        Seller seller=new Seller();
        MarketInfo footer=new MarketInfo("www.company.com");
        Buyer buyer= new Buyer();
        
        //Vat, excange rate
        Total total= new Total(21,1.3);
       
        
        //Items List
        Items items1= new Items(new ArrayList <Items>());
     
        
        ArrayList <Items> itemsList = new ArrayList <>();
        itemsList.add(new Items(2,"Dress", 1.0));
        itemsList.add(new Items(3,"Scarf", 10.0));
        itemsList.add(new Items(3,"Pants", 2.0));
        itemsList.add(new Items(1,"Dress Red", 1.0));
        itemsList.add(new Items(3,"Scarf Blue", 10.0));
        itemsList.add(new Items(3,"Pants Gray", 12.0));
        
        items1.setArrayList(itemsList);
        
       
   
        
        PdfFactory2 pdf2= new PdfFactory2();
        
        // Creating Pdf
        pdf2.createPdf2(DEST2, order, seller, footer, buyer,items1, total);
        File file2 =new File(DEST2);
        
        
        //Opens file after executing
       Runtime.getRuntime().exec(new String []{"rundll32","url.dll,FileProtocolHandler",file2.getAbsolutePath()});
        
        

    }

   
}
