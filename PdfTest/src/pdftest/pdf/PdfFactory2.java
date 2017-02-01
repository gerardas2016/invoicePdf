
package pdftest.pdf;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
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
 * @author Gepardas
 */
public class PdfFactory2 {
  
         String invoice="INVOICE";
         String knock="COMPANY NAME";
         String knock2="SHORT DESCRIPTION";
         String invoiceDate= "Invoice Date: ";
         String invoiceNumber= "Invoice number: ";
         String sellerInfo= "Seler: ";
         String buyerInfo= "Buyer: ";
     
     
     public void createPdf2 (String dest, Order order,Seller seller, MarketInfo footerInfo, Buyer buyer,Items items,Total total) throws IOException {
//Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        
        PageSize ps = PageSize.A4;
        PdfPage page = pdf.addNewPage(ps);
        ArrayList <Items> itemsList = items.getArrayList();
        
        float selOrderSpaceWidth= 20;
        float invoiceContactSpaceWidth= 15;
                  
         
//Invoice Text
          Cell cellInvoice = new Cell().setBorder(Border.NO_BORDER);
          cellInvoice.setWidthPercent(100);
          cellInvoice.setTextAlignment(TextAlignment.RIGHT);
          cellInvoice.setFontSize(20);
          cellInvoice.add(invoice);
         
         document.add(cellInvoice);
         
//Body (Knock Knock, invoice number and date
        
        Style a= new Style();
        PdfFont tableFont = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        Table table = new Table( new float[]{10,5,5});// 
        table.setWidthPercent(100);
        table.addStyle(a);
        //First row = Knock knoc, date
        table.addCell(new Cell().add(knock)
                .setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.CENTER)
                .setFontSize(20)
                .setFontColor(Color.BLACK));
        table.addCell(new Cell().add(invoiceDate).setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.RIGHT).setVerticalAlignment(VerticalAlignment.BOTTOM));
        table.addCell(new Cell().add(order.getDate()).setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.LEFT).setVerticalAlignment(VerticalAlignment.BOTTOM));
        
//Second row Hand made+ invoice number
        table.addCell(new Cell().add(knock2)
                .setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.CENTER)
                .setFontSize(8)
                .setFontColor(Color.LIGHT_GRAY));
        table.addCell(new Cell().add(invoiceNumber).setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.RIGHT).setVerticalAlignment(VerticalAlignment.TOP));
        table.addCell(new Cell().add(order.getInvoiceNum()).setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.LEFT));
        
        //Space width invoive nr ard seller- buer contact
        table.addCell(new Cell().add("")
                .setBorder(Border.NO_BORDER).
                setHeight(invoiceContactSpaceWidth));
        
//Seller Buyer
        
        PdfFont tableSel = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        Table tableSeller = new Table( new float[]{2,5,2,5});// 
         tableSeller.setWidthPercent(100);
         
         //Seller
        tableSeller.addCell(new Cell().add(sellerInfo)
                .setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.RIGHT)
                .setFontSize(8)) ;
        tableSeller.addCell(new Cell().add(seller.toString())
                .setBorder(Border.NO_BORDER).
                setFontSize(10));
        
        //Buyer
        tableSeller.addCell(new Cell().add(buyerInfo)
                .setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.RIGHT)
                .setFontSize(8));
        tableSeller.addCell(new Cell().add(buyer.toString())
                .setBorder(Border.NO_BORDER).
                setFontSize(10));
        //Space width
        tableSeller.addCell(new Cell().add("")
                .setBorder(Border.NO_BORDER).
                setHeight(selOrderSpaceWidth));
        
         
    
  
    PdfFont tableOrderFont = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
    Table tableOrder = new Table( new float[]{1,2, 10, 6, 3});// 
    tableOrder.setWidthPercent(100);
    
    

       
    tableOrder.addHeaderCell(new Cell().add("ID").setBackgroundColor(Color.LIGHT_GRAY));
    tableOrder.addHeaderCell(new Cell().add("Qty").setBackgroundColor(Color.LIGHT_GRAY));
    tableOrder.addHeaderCell(new Cell().add("Description").setBackgroundColor(Color.LIGHT_GRAY));
    tableOrder.addHeaderCell(new Cell().add("Unit Price (GBP)").setBackgroundColor(Color.LIGHT_GRAY));
    tableOrder.addHeaderCell(new Cell().add("Total Price").setBackgroundColor(Color.LIGHT_GRAY));
    
      
    

     int i=1;
     for (Items x : itemsList) {
           
           
           
    tableOrder.addCell(new Cell().add(i+" ").setBackgroundColor(Color.WHITE));
    tableOrder.addCell(new Cell().add(x.getQuantity()+""));
    tableOrder.addCell(new Cell().add(x.getItemDescription()+""));
    tableOrder.addCell(new Cell().add(x.getUnitPrice()+""));
    tableOrder.addCell(new Cell().add(x.getTotalPrice()+""));
            
            i++;
            
        }
     
     
     //for (int i=0; i<itemsList.size();i++){}
   // items.getArrayList().size();
   // int j=items.getArrayList().size();
//    int j= itemsList.size();
//    for (int i=1; i<=j; i++){
//     if (i%2!=0)
//    tableOrder.addCell(new Cell().add(i+" "));
//    tableOrder.addCell(new Cell().add(items.getQuantity()+""));
//   // items.getArrayList().get(i+1);
//    tableOrder.addCell(new Cell().add(items.getItemDescription()+""));
//    tableOrder.addCell(new Cell().add(items.getUnitPrice()+""));
//    tableOrder.addCell(new Cell().add(items.getTotalPrice()+""));
//    
//        
//        if (i<j){
//            i++;
//        tableOrder.addCell(new Cell().add(i+" ").setBackgroundColor(Color.LIGHT_GRAY));
//        tableOrder.addCell(new Cell().add(items.getQuantity()+"").setBackgroundColor(Color.LIGHT_GRAY));
//        tableOrder.addCell(new Cell().add(items.getItemDescription()+" b").setBackgroundColor(Color.LIGHT_GRAY));
//        tableOrder.addCell(new Cell().add(items.getUnitPrice()+" c").setBackgroundColor(Color.LIGHT_GRAY));
//        tableOrder.addCell(new Cell().add(items.getTotalPrice()+" c").setBackgroundColor(Color.LIGHT_GRAY));
//       
//        
//        
//        
//        }
    
    
    //}
    
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("Total (exc VAT)").setBackgroundColor(Color.LIGHT_GRAY));
    tableOrder.addCell(new Cell().add(total.getTotalExcVat(items) +"").setBackgroundColor(Color.LIGHT_GRAY));
    
    
    if (total.getTotalEcvVatWithDiscount()!=0){
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("Total (exc VAT) with discount").setBackgroundColor(Color.LIGHT_GRAY));
    tableOrder.addCell(new Cell().add(total.getTotalEcvVatWithDiscount() +"").setBackgroundColor(Color.LIGHT_GRAY));
    
    
    
    }
        
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("VAT ("+total.getVat()+")"));
    tableOrder.addCell(new Cell().add(total.getVatSum()+"")); 
    
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("Total inc. VAT").setBackgroundColor(Color.LIGHT_GRAY));
    tableOrder.addCell(new Cell().add(String.format("%.2f", total.getTotalIncVat())+"").setBackgroundColor(Color.LIGHT_GRAY)); 
    
    
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("Excange Rate to Euros"));
    tableOrder.addCell(new Cell().add(total.getExcangeRateToEur()+"")); 
    
    
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
    tableOrder.addCell(new Cell().add("Total in Euros").setBackgroundColor(Color.LIGHT_GRAY));
    tableOrder.addCell(new Cell().add(String.format("%.2f",total.getTotalInEur())+"").setBackgroundColor(Color.LIGHT_GRAY)); 

    
    
    PdfFont footerFont = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
       Text footer= new Text (footerInfo.getWebSiteName());
       footer.setFontSize(8);
       document.add (new Paragraph(footer).setFixedPosition(50, 25 , ps.getWidth()));
       
      PdfFont footerFont1 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
      
       Text pageNumber= new Text (pdf.getPageNumber(page)+"");
       pageNumber.setFontSize(8);
       document.add (new Paragraph(pageNumber).setFixedPosition(ps.getWidth()-50, 25 , ps.getWidth()));
       
       
       
         
    document.add(table);
    document.add(tableSeller);
    document.add(tableOrder);
   
     document.close();

    }
}
