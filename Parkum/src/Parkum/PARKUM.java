/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Parkum;

import java.util.TreeMap;
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author ricardo
 */
public class PARKUM {
    private ParkumCSI pCSI;
    private TreeMap<String,SensorLugar> sensoresL;
    private TreeMap<String,MaqPagamento> maqPag;
    private TreeMap<String,PortalEntrada> portaisE;
    private TreeMap<String,PortalSaida> portaisS;
    private CarregarBD bd;

    PARKUM() {
        pCSI = new ParkumCSI();
        sensoresL = new TreeMap<String,SensorLugar>();
        maqPag = new TreeMap<String,MaqPagamento>();
        portaisE = new TreeMap<String,PortalEntrada>();
        portaisS = new TreeMap<String,PortalSaida>();
        bd = new CarregarBD();
    }

    public ParkumCSI getCSI() { return pCSI; }
}
