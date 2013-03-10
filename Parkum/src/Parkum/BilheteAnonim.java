/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

import java.util.GregorianCalendar;
import java.util.Date;

/**
 *
 * @author miguel
 */
public class BilheteAnonim extends Bilhete{
    
    private GregorianCalendar dataPagamento;
    private Date d = new Date();


    public BilheteAnonim(){
        super();
        dataPagamento=null;
    }

    public BilheteAnonim(String id){
        super();
        super.setIdBilhete(id);
        dataPagamento=null;
    }

    public BilheteAnonim(String id_b, GregorianCalendar dataE, GregorianCalendar dataS, double total, boolean proc, GregorianCalendar dataP){
    super(id_b, dataE, dataS, total, proc);
    dataPagamento=dataP;
    }

    public BilheteAnonim(BilheteAnonim b){
        super(b);
        dataPagamento=b.getDataPagamento();
    }
   
    public GregorianCalendar getDataPagamento(){return dataPagamento;}
    public void setDataPagamento(GregorianCalendar data){dataPagamento=data;}

    public String toString() {
        StringBuilder s = new StringBuilder("-----Bilhete Cliente Anónimo-----\n");
        s.append(super.toString());
        s.append("Data Pagamento: ");
        if (dataPagamento!=null)
            s.append(dataPagamento.get(dataPagamento.YEAR) + "-" + dataPagamento.get(dataPagamento.MONTH) + "-" + dataPagamento.get(dataPagamento.DAY_OF_MONTH) + " " + dataPagamento.get(dataPagamento.HOUR_OF_DAY) + ":" + dataPagamento.get(dataPagamento.MINUTE)+"\n\n");
        else
            s.append(dataPagamento + "\n\n");
        return s.toString();
    }
    
    public BilheteAnonim clone(){return new BilheteAnonim(this);}

}
