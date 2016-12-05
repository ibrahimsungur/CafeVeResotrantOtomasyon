
package resturant;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static resturant.Masalar.durum;
import static resturant.Menu.d;


public class Veritabani 
{
Connection con=null; 
Statement st=null;
ResultSet rs=null;
static int count=0;
int kategoriAd=0,menuAd=0;
 int ad=0,sifre=0,pin=0,mekanAd=0,masaAd=0;
public static String butonClick=null;

public Veritabani()
{
if(baglantiKur())
{
    System.out.println("Veritabanina Bağlandi.");
    urunlerTable();
    kategoriTable();
    menuTable();
    personelTable();
    mekanTable();
    kullaniciTable();
    masaTable();
   acilanMasaTable();
   hareketDokumuTable();
   sistemGirisTable();
}
else 
{
    System.out.println("Bağlantı Hatasi!!");
}
}
public boolean baglantiKur() 
{ 
   boolean sonuc = false;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Restoran", "postgres", "12345");
           st =(Statement) con.createStatement();
            sonuc = true;
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {}
        

        return sonuc;
}

public void urunlerTable() {

        try {
            st = con.createStatement();
            String sqlur = "CREATE TABLE urunTablo("
                    + "   ur_ID SERIAL PRIMARY KEY  ,"
                    + "   urunAd        TEXT     NOT NULL,"
                    + "   urunFiyat      TEXT     NOT NULL,"
                    + "   urunAdet      TEXT     NOT NULL,"
                    + "   kategoriAd       TEXT     NOT NULL"
                    + ");";
            st.executeUpdate(sqlur);

        } catch (SQLException ex) {
            System.out.println("Tablo Var..");
        }

    }
public void kategoriTable() {

        try {
            st = con.createStatement();
            String sqlkate = "CREATE TABLE kategoriTablo("
                    + "   kate_ID SERIAL PRIMARY KEY  ,"
                    + "  kategoriAd     TEXT    NOT NULL"
                   
                    + ");";
            st.executeUpdate(sqlkate);

        } catch (SQLException ex) {
            System.out.println("Tablo Var..");
        }

    }
public void menuTable() {

        try {
            st = con.createStatement();
            String sqlmenu = "CREATE TABLE menuTablo("
                    + "   me_ID SERIAL PRIMARY KEY  ,"
                    + "  menuAd    TEXT    NOT NULL,"
                    + "  fiyat   TEXT    NOT NULL,"
                    + " menuicerik   TEXT    NOT NULL"
                    + ");";
            st.executeUpdate(sqlmenu);

        } catch (SQLException ex) {
            System.out.println("Tablo Var..");
        }

    }
public void personelTable() {

        try {
            st = con.createStatement();
            String sqlPer = "CREATE TABLE PersonelTablo("
                    + "   pe_ID SERIAL PRIMARY KEY  ,"
                    + "   ad           TEXT    NOT NULL,"
                    + "   soyad        TEXT     NOT NULL,"
                    + "   evtelno       TEXT     NOT NULL,"
                    + "   ceptelno       TEXT     NOT NULL,"
                    + "   aciklama       TEXT     NOT NULL,"
                    + "   adres        TEXT     NOT NULL"
                    + ");";
            st.executeUpdate(sqlPer);

        } catch (SQLException ex) {
            System.out.println("Tablo Var..");
        }

    }
public void mekanTable() {

        try {
            st = con.createStatement();
            String sqlmekan = "CREATE TABLE mekanTablo("
                    + "   mekan_ID SERIAL PRIMARY KEY  ,"
                    + "    mekanAd           TEXT    NOT NULL"
                    
                    + ");";
            st.executeUpdate(sqlmekan);

        } catch (SQLException ex) {
            System.out.println("Tablo Var..");
        }

    }
public void kullaniciTable() {

        try {
            String sqlkul = "CREATE TABLE  kullanici ("
                    + "   kullan_ID SERIAL PRIMARY KEY ,"
                    + "   ad           TEXT    NOT NULL,"
                    + "   soyad        TEXT     NOT NULL,"
                    + "   sifre        TEXT     NOT NULL,"
                    + "   pin        TEXT     NOT NULL,"
                    + "   yetki        TEXT     NOT NULL"
                    + ");";
            st.execute(sqlkul);
        } catch (SQLException ex) {
            System.out.println("Tablo Var..");
        }

    }
public void masaTable() {

        try {
            st = con.createStatement();
            String sqlmasa = "CREATE TABLE masaTablo("
                    + "   masa_ID SERIAL PRIMARY KEY  ,"
                    + "    masaAd           TEXT    NOT NULL,"
                    + "    mekanAd           TEXT    NOT NULL,"
                    + "    durum             TEXT    NOT NULL"
                    
                    + ");";
            st.executeUpdate(sqlmasa);

        } catch (SQLException ex) {
            System.out.println("Tablo Var..");
        }

    }
public void acilanMasaTable() {

        try {
            st = con.createStatement();
            String sqlAcmasa = "CREATE TABLE acilanmasaTablo("
                    + "    Acmasa_ID SERIAL PRIMARY KEY  ,"
                    + "    masaAd           TEXT    NOT NULL,"
                    + "    zaman           TEXT    NOT NULL,"
                    + "    masaUrunler          TEXT    NOT NULL,"
                    + "    fiyat          TEXT    NOT NULL,"
                    + "    mekanad           TEXT    NOT NULL"
                    
                    + ");";
            st.executeUpdate(sqlAcmasa);

        } catch (SQLException ex) {
            System.out.println("Tablo Var..");
        }

    }
public void hareketDokumuTable() {

        try {
            st = con.createStatement();
            String sqlhareket = "CREATE TABLE hareketTablo("
                    + "    hareket_ID SERIAL PRIMARY KEY  ,"
                    + "    hesapkesenAd           TEXT    NOT NULL,"
                    + "    tarih           TEXT    NOT NULL,"
                    + "    saat         TEXT    NOT NULL,"
                    + "    hesap          TEXT    NOT NULL"
                    + ");";
            st.executeUpdate(sqlhareket);

        } catch (SQLException ex) {
            System.out.println("Tablo Var..");
        }

    }
public void sistemGirisTable() {

        try {
            st = con.createStatement();
            String sqlsistemgiris = "CREATE TABLE sistemgirisTablo("
                    + "    giris_ID SERIAL PRIMARY KEY  ,"
                    + "    kullanici           TEXT    NOT NULL,"
                    + "    tarih           TEXT    NOT NULL,"
                    + "    saat         TEXT    NOT NULL"
                    + ");";
            st.executeUpdate(sqlsistemgiris);

        } catch (SQLException ex) {
            System.out.println("Tablo Var..");
        }

    }




 public void urunEkle(String TabloAdi, String[] values) {

        try {
            
            
            String sqlur = "INSERT INTO " + TabloAdi + "(urunAd,urunFiyat,urunAdet,kategoriAd) VALUES('"
                    + values[0] + "','"
                    + values[1] + "','"
                    + values[2] + "','"
                    + values[3] + "');";
            st.executeUpdate(sqlur);
        } catch (SQLException ex) {

        }

    }
 public void kategoriEkle(String TabloAdi, String[] values) {

        try {
            
            rs = st.executeQuery("select * from kategoritablo where kategoriAd='" + values[0] + "';");
            while (rs.next()) {
                kategoriAd= 1;
            }
            if(kategoriAd==0)
         {
            String sqlkate = "INSERT INTO " + TabloAdi + "(kategoriAd) VALUES('"
                   
           + values[0] + "');";
            st.executeUpdate(sqlkate);
             JOptionPane.showMessageDialog(null, "Veritabanına Başarıyla Eklendi.");
         }
        } catch (SQLException ex) {

        
        }
    }
 public void menuEkle(String TabloAdi, String[] values) {

        try {
            
            rs = st.executeQuery("select * from menuTablo where menuAd='" + values[0] + "';");
            while (rs.next()) {
                menuAd= 1;
              JOptionPane.showMessageDialog(null, " Aynı Menü Adı Var!!!.");  
            }
            if(menuAd==0)
         {
            String sqlmenu = "INSERT INTO " + TabloAdi + "(menuAd,fiyat,menuicerik) VALUES('"
            + values[0] + "','"  
            + values[1] + "','" 
            + values[2] + "');";
            st.executeUpdate(sqlmenu);
             JOptionPane.showMessageDialog(null, "Menü Başarıyla Eklendi.");
         }
        } catch (SQLException ex) {

        
        }
    }
 public void personelEkle(String TabloAdi, String[] values) {

        try {
            String sqlPer = "INSERT INTO " + TabloAdi + "(ad,soyad,evtelno,ceptelno,aciklama,adres) VALUES('"
                    + values[0] + "','"
                    + values[1] + "','"
                    + values[2] + "','"
                    + values[3] + "','"
                    + values[4] + "','"
                    + values[5] + "');";
            st.executeUpdate(sqlPer);
        } catch (SQLException ex) {

        }

    }
 public void mekanEkle(String TabloAdi, String[] values) {

        try {
            String sqlmekan = "INSERT INTO " + TabloAdi + "(mekanAd) VALUES('"
                    
                    + values[0] + "');";
            st.executeUpdate(sqlmekan);
        } catch (SQLException ex) {

        }

    }
 public void kullaniciEkleme(String TabloAdi, String[] values) {

       
            
        try {
            rs = st.executeQuery("select * from kullanici where ad='" + values[0] + "';");
            while (rs.next())
            {
                ad = 1;
            }
            rs = st.executeQuery("select * from kullanici where sifre='" + values[2] + "';");
            while (rs.next())
            {
                sifre = 1;
            }
             rs = st.executeQuery("select * from kullanici where pin='" + values[3] + "';");
            while (rs.next())
            {
                pin = 1;
            }
            if(ad==0 && sifre==0&& pin==0)
            {
                String sqlkul = "INSERT INTO " + TabloAdi + "(ad,soyad,sifre,pin,yetki) VALUES('"
                        + values[0] + "','"
                        + values[1] + "','"
                        + values[2] + "','"
                        + values[3] + "','"
                        + values[4] + "');";
                st.execute(sqlkul);
                JOptionPane.showMessageDialog(null, "Başarıyla Eklendi.");
            }
            else
            {
                if (ad == 1 && sifre == 0) {
                    JOptionPane.showMessageDialog(null, "Ad  ve Şifre Uygun Değil!!");
                    ad = 0;

                }
                if (ad == 0 && sifre == 1) {
                    JOptionPane.showMessageDialog(null, " Ad ve Şifre Uygun Değil!!.", "Uyarı", JOptionPane.WARNING_MESSAGE);
                    ad = 0;

                }
                if (ad == 1 && sifre == 1) {
                    JOptionPane.showMessageDialog(null, "Ad ve Şifre uygun değil!!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                    ad = 0;
                    sifre = 0;
                }
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }

                     }
 public void masaEkle(String TabloAdi, String[] values) {

        try {
            rs = st.executeQuery("select * from masaTablo where masaAd='" + values[0] + "' AND mekanAd='"+values[1]+"';");
            while (rs.next())
            {
                masaAd = 1;
                 
            }
            
            if(masaAd==0 )
            {
            String sqlmasa = "INSERT INTO " + TabloAdi + "(masaAd,mekanAd,durum) VALUES('"
                    + values[0] + "','"
                    + values[1] + "','"
                    + values[2] + "');";
            st.executeUpdate(sqlmasa);
            JOptionPane.showMessageDialog(null, "Veri Başarıyle Eklendi.");
         
            }
             else
            {
                if (masaAd == 1 )
                {
                    JOptionPane.showMessageDialog(null, "Masa Uygun Değil.!!!");
                    masaAd = 0;

                }
     
            }
        } catch (SQLException ex) {

        }
        
    }
 public void acilanMasaEkle(String TabloAdi, String[] values) {

        try {
           
            String sqlAcmasa = "INSERT INTO " + TabloAdi + "(masaAd,zaman,masaurunler,fiyat,mekanad) VALUES('"
                    + values[0] + "','"
                    + values[1] + "','"
                    + values[2] + "','"
                    + values[3] + "','"
                    + values[4] + "');";
            st.executeUpdate(sqlAcmasa);
            JOptionPane.showMessageDialog(null, "Veri Başarıyle Eklendi.");
         
            
        } catch (SQLException ex) {

        }
        
    }
 public void hareketEkle(String TabloAdi, String[] values) {

        try {
           
            String sqlhareket = "INSERT INTO " + TabloAdi + "(hesapkesenAd,tarih,saat,hesap) VALUES('"
                    + values[0] + "','"
                    + values[1] + "','"
                    + values[2] + "','"
                    + values[3] + "');";
            st.executeUpdate(sqlhareket);
            JOptionPane.showMessageDialog(null, "Veri Başarıyle Eklendi.");
         
            
        } catch (SQLException ex) {

        }
        
    }
 public void sistemGirisEkle(String TabloAdi, String[] values) {

        try {
           
            String sqlsistemgiris = "INSERT INTO " + TabloAdi + "(kullanici,tarih,saat) VALUES('"
                    + values[0] + "','"
                    + values[1] + "','"
                    + values[2] + "');";
            st.executeUpdate(sqlsistemgiris);
            JOptionPane.showMessageDialog(null, "Veri Başarıyle Eklendi.");
         
            
        } catch (SQLException ex) {

        }
        
    }
 
  public String[][] kategoriKayitListele() {
      
                count = SatirSayisi("kategoritablo");
                String[][] dizi = new String[count][3];
                 if(count==0)
               { 
                     
                   if(butonClick.equals("kategoriLis"))
                   {
                       butonClick=null;
                       JOptionPane.showMessageDialog(null, "Listelenecek  Veri Bulunamadı!!!.");
                   }
               }
             
                    try {
                        int i = 0;
                        st = con.createStatement();
                       String sqlur = "SELECT * FROM kategoriTABLO order by kategoriAd;";  
                       ResultSet rs = st.executeQuery(sqlur);
                     
                        while (rs.next()) 
                            { 
                           
                           
                                
                            dizi[i][0] = String.valueOf(i + 1);
                            dizi[i][1] = rs.getString("kate_id");
                            dizi[i][2] = rs.getString("kategoriAd");
                         
                            i++;
                            } 
                            
                          
                    } catch (SQLException ex) {
                        Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
                    
                
    }return dizi;
    }
  public String[][] urunKayitListele() {
      
                count = SatirSayisi("uruntablo");
                String[][] dizi = new String[count][4];
               if(count==0)
               { 
//                     
//                   if(butonClick.equals("urunLis"))
//                   {
//                       butonClick=null;
//                       JOptionPane.showMessageDialog(null, "Listelenecek  Veri Bulunamadı!!!.");
//                   }
               }
             
                    try {
                        int i = 0;
                        st = con.createStatement();
                        String sqlur = "SELECT * FROM urunTABLO order by ur_id;";
                        ResultSet rs = st.executeQuery(sqlur);
                        while (rs.next()) {
                            dizi[i][0] = rs.getString("ur_id");
                            dizi[i][1] = rs.getString("urunAd");
                            dizi[i][2] = rs.getString("urunFiyat");
                            dizi[i][3] = rs.getString("urunAdet");
                           
                            i++;
                         
                        }  
                    } catch (SQLException ex) {
                        Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
          
    }return dizi;
    }
  public String[][] menuKayitListele() {
      
                count = SatirSayisi("menutablo");
                String[][] dizi = new String[count][3];
                 if(count==0)
               { 
                     
                  /* if(butonClick.equals("menuLis"))
                   {
                       butonClick=null;
                       JOptionPane.showMessageDialog(null, "Listelenecek  Veri Bulunamadı!!!.");
                   }*/
               }
             
                    try {
                        int i = 0;
                        st = con.createStatement();
                       String sqlmenu = "SELECT * FROM menuTABLO order by  me_id;";  
                       ResultSet rs = st.executeQuery(sqlmenu);
                     
                        while (rs.next()) 
                            { 
                           
                           // dizi[i][0] = String.valueOf(i + 1);
                           // dizi[i][0] = rs.getString("me_id");
                            dizi[i][0] = rs.getString("me_id");
                            dizi[i][1] = rs.getString("menuAd");
                            dizi[i][2] = rs.getString("fiyat");
                            //dizi[i][3] = rs.getString("m");
                         
                            i++;
                            } 
                            
                          
                    } catch (SQLException ex) {
                        Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
                    
                
    }return dizi;
    }
  public String[][] menu1KayitListele() {
      
                count = SatirSayisi("menutablo");
                String[][] dizi = new String[count][3];
                 if(count==0)
               { 
                     
                  /* if(butonClick.equals("menuLis"))
                   {
                       butonClick=null;
                       JOptionPane.showMessageDialog(null, "Listelenecek  Veri Bulunamadı!!!.");
                   }*/
               }
             
                    try {
                        int i = 0;
                        st = con.createStatement();
                       String sqlmenu = "SELECT * FROM menuTABLO order by  me_id;";  
                       ResultSet rs = st.executeQuery(sqlmenu);
                     
                        while (rs.next()) 
                            { 
                           
                           // dizi[i][0] = String.valueOf(i + 1);
                            dizi[i][0] = rs.getString("menuicerik");
                            dizi[i][1] = rs.getString("menuAd");
                            dizi[i][2] = rs.getString("fiyat");
                            //dizi[i][3] = rs.getString("m");
                         
                            i++;
                            } 
                            
                          
                    } catch (SQLException ex) {
                        Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
                    
                
    }return dizi;
    }
  public String[][] PersonelKayitListele() {
      
                count = SatirSayisi("personeltablo");
                String[][] dizi = new String[count][7];
               if(count==0)
               { 
                     
//                   if(butonClick.equals("personelLis"))
//                   {
//                       butonClick=null;
//                       JOptionPane.showMessageDialog(null, "Listelenecek  Veri Bulunamadı!!!.");
//                   }
               }
             
                    try {
                        int i = 0;
                        st = con.createStatement();
                        String sqlper = "SELECT * FROM personelTABLO order by pe_id;";
                        ResultSet rs = st.executeQuery(sqlper);
                        while (rs.next()) {
                            //dizi[i][0] = String.valueOf(i + 1);
                            dizi[i][0] = rs.getString("pe_id");
                            dizi[i][1] = rs.getString("ad");
                            dizi[i][2] = rs.getString("soyad");
                            dizi[i][3] = rs.getString("evtelno");
                            dizi[i][4] = rs.getString("ceptelno");
                            dizi[i][5] = rs.getString("aciklama");
                            dizi[i][6] = rs.getString("adres");
                            
                            i++;
                            // ad,soyad,telno,adres,mevki

                        }  
                    } catch (SQLException ex) {
                        Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
                    
                
    }return dizi;
    }
  public String[][] mekanKayitListele() {
      
                count = SatirSayisi("mekantablo");
                String[][] dizi = new String[count][2];
               if(count==0)
               { 
                     
//                   if(butonClick.equals("mekanLis"))
//                   {
//                       butonClick=null;
//                       JOptionPane.showMessageDialog(null, "Listelenecek  Veri Bulunamadı!!!.");
//                   }
               }
             
                    try {
                        int i = 0;
                        st = con.createStatement();
                        String sqlper = "SELECT * FROM mekanTABLO order by mekan_id;";
                        ResultSet rs = st.executeQuery(sqlper);
                        while (rs.next()) {
                            //dizi[i][0] = String.valueOf(i + 1);
                            dizi[i][0] = rs.getString("mekan_id");
                            dizi[i][1] = rs.getString("mekanAd");
                           
                            
                            i++;
                            
                        }  
                    } catch (SQLException ex) {
                        Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
                    
                
    }return dizi;
    }
  public String[][] masaKayitListele() {
      
                count = SatirSayisi("masatablo");
                String[][] dizi = new String[count][2];
               if(count==0)
               { 
                     
//                   if(butonClick.equals("masaLis"))
//                   {
//                       butonClick=null;
//                       JOptionPane.showMessageDialog(null, "Listelenecek  Veri Bulunamadı!!!.");
//                   }
               }
             
                    try {
                        int i = 0;
                        st = con.createStatement();
                        String sqlmasa = "SELECT * FROM masaTABLO order by masa_id;";
                        ResultSet rs = st.executeQuery(sqlmasa);
                        while (rs.next()) {
                            //dizi[i][0] = String.valueOf(i + 1);
                              dizi[i][0] = rs.getString("masa_id");
                              dizi[i][1] = rs.getString("masaAd");
                            //dizi[i][1] = rs.getString("mekanAd");
                           
                            
                            i++;
                            
                        }  
                    } catch (SQLException ex) {
                        Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
       
    }
                    return dizi;
    }
  public String[][] acilanMasaKayitListele() {
      
                count = SatirSayisi("acilanmasatablo");
                String[][] dizi = new String[count][5];
               if(count==0)
               { 
//                     
//                   if(butonClick.equals("aclinamasaLis"))
//                   {
//                       butonClick=null;
//                       JOptionPane.showMessageDialog(null, "Listelenecek  Veri Bulunamadı!!!.");
//                   }
               }
             
                    try {
                        int i = 0;
                        st = con.createStatement();
                        String sqlAcmasa = "SELECT * FROM acilanmasaTABLO order by acmasa_id;";
                        ResultSet rs = st.executeQuery(sqlAcmasa);
                        while (rs.next()) {
                           
                             // dizi[i][0] = rs.getString("acmasa_id");
                              dizi[i][1] = rs.getString("masaad");
                              dizi[i][2] = rs.getString("zaman");
                              dizi[i][3] = rs.getString("masaurunler");
                              dizi[i][4] = rs.getString("fiyat");
                         
                            i++;
                            
                        }  
                    } catch (SQLException ex) {
                        Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
       
    }
                    return dizi;
    }
  public String[][] kullaniciKayitListele() {
         count=SatirSayisi("kullanici");
        String[][] dizi = new String[count][6];
         if(count==0)
               { 
                     
                   if(butonClick.equals("kullaniciLis"))
                   {
                       butonClick=null;
                       JOptionPane.showMessageDialog(null, "Listelenecek  Veri Bulunamadı!!!.");
                   }
               }
        try {
            int i = 0;
            st = con.createStatement();
            String sqlkul= "SELECT * FROM kullanici order by kullan_id;";
            ResultSet rs = st.executeQuery(sqlkul);
            while (rs.next()) {
               // dizi[i][0] = String.valueOf(i+1);
                dizi[i][0] = rs.getString("kullan_id");
                dizi[i][1] = rs.getString("ad");
                dizi[i][2] = rs.getString("soyad");
                dizi[i][3] = rs.getString("sifre");
                dizi[i][4] = rs.getString("pin");
                dizi[i][5] = rs.getString("yetki");
               

                i++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dizi;
    }
  public String[][] hareketKayitListele() {
         count=SatirSayisi("harekettablo");
        String[][] dizi = new String[count][4];
         if(count==0)
               { 
                     
//                   if(butonClick.equals("hareketLis"))
//                   {
//                       butonClick=null;
//                       JOptionPane.showMessageDialog(null, "Listelenecek  Veri Bulunamadı!!!.");
//                   }
               }
        try {
            int i = 0;
            st = con.createStatement();
            String sqlhareket= "SELECT * FROM harekettablo order by hareket_id;";
            ResultSet rs = st.executeQuery(sqlhareket);
            while (rs.next()) {
               // dizi[i][0] = String.valueOf(i+1);
                dizi[i][0] = rs.getString("hesapkesenad");
                dizi[i][1] = rs.getString("tarih");
                dizi[i][2] = rs.getString("saat");
                dizi[i][3] = rs.getString("hesap");
           
                i++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dizi;
    }
   public String[][] sistemGirisKayitListele() {
         count=SatirSayisi("sistemgiristablo");
        String[][] dizi = new String[count][3];
         if(count==0)
               { 
                     
                   if(butonClick.equals("hareketLis"))
                   {
                       butonClick=null;
                       JOptionPane.showMessageDialog(null, "Listelenecek  Veri Bulunamadı!!!.");
                   }
               }
        try {
            int i = 0;
            st = con.createStatement();
            String sqlsistemgiris= "SELECT * FROM sistemgiristablo order by giris_id;";
            ResultSet rs = st.executeQuery(sqlsistemgiris);
            while (rs.next()) {
              
                dizi[i][0] = rs.getString("kullanici");
                dizi[i][1] = rs.getString("tarih");
                dizi[i][2] = rs.getString("saat");
              
                i++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dizi;
    }
  
  
   public void menuSilme(String TabloAdi, String no) {
        try {
            st = con.createStatement();
            String sqlmenu = "DELETE FROM  "
                    + TabloAdi
                    + " WHERE me_id='"
                    + no
                    + "';";
            st.executeQuery(sqlmenu);
        } catch (SQLException ex) {

        }

    }
   public void personelSilme(String TabloAdi, String no) {
        try {
            st = con.createStatement();
            String sqlper = "DELETE FROM  "
                    + TabloAdi
                    + " WHERE pe_id='"
                    + no
                    + "';";
            st.executeQuery(sqlper);
        } catch (SQLException ex) {

        }

    }
   public void mekanSilme(String TabloAdi, String no) {
        try {
            st = con.createStatement();
            String sqlmekan = "DELETE FROM  "
                    + TabloAdi
                    + " WHERE mekan_id='"
                    + no
                    + "';";
            st.executeQuery(sqlmekan);
        } catch (SQLException ex) {

        }

    }
   public void kullaniciSilme(String TabloAdi, String no) {
        try {
            st = con.createStatement();
            String sqlkul = "DELETE FROM  "
                    + TabloAdi
                    + " WHERE  kullan_id='"
                    + no
                    + "';";
            st.executeQuery(sqlkul);
        } catch (SQLException ex) {

        }
    }
   public void masaSilme(String TabloAdi, String no) {
        try {
            st = con.createStatement();
            String sqlmasa = "DELETE FROM  "
                    + TabloAdi
                    + " WHERE masa_id='"
                    + no
                    + "';";
            st.executeQuery(sqlmasa);
        } catch (SQLException ex) {

        }

    }
   public void acilanMasaSilme(String TabloAdi, String no) {
        try {
            st = con.createStatement();
            String sqlAcmasa = "DELETE FROM  "
                    + TabloAdi
                    + " WHERE masaad='"
                    + no
                    + "';";
            st.executeQuery(sqlAcmasa);
        } catch (SQLException ex) {

        }

    }
    public void urunSilme(String TabloAdi, String no) {
        try {
            st = con.createStatement();
            String sqlAcmasa = "DELETE FROM  "
                    + TabloAdi
                    + " WHERE ur_id='"
                    + no
                    + "';";
            st.executeQuery(sqlAcmasa);
            JOptionPane.showMessageDialog(null, "Veri Başarıyla Silindi.. !!!.");
        } catch (SQLException ex) {

        }

    }
   
   public void menuGuncele(String adi, String d,int index) {
        try {
            
           
              String sqlmenu="";
              if(index==0)
              sqlmenu = "update menuTablo set menuAd='"  +adi+ "' where me_id='" +d+ "'";
              else if(index==1)
              sqlmenu = "update  menuTablo set fiyat='" +adi+ "' where  me_id='" +d+ "'";
             
            st.executeUpdate(sqlmenu);
           
            JOptionPane.showMessageDialog(null, "Başarıyla güncellendi..");
           
        } catch (SQLException ex) {

        }

    }
   public void personelGuncele(String adi, String d,int index) {
        try {
            
           
              String sqlper="";
              if(index==0)
              sqlper = "update personelTablo set evtelno='"  +adi+ "' where pe_id='" +d+ "'";
              else if(index==1)
              sqlper = "update  personelTablo set ceptelno='" +adi+ "' where  pe_id='" +d+ "'";
              else if(index==2)
              sqlper = "update  personelTablo set aciklama='" +adi+ "' where  pe_id='" +d+ "'";
              else if(index==3)
              sqlper = "update  personelTablo set adres='" +adi+ "' where  pe_id='" +d+ "'";
            st.executeUpdate(sqlper);
           
            JOptionPane.showMessageDialog(null, "Başarıyla güncellendi..");
           
        } catch (SQLException ex) {

        }

    }
   public void mekanGuncele(String adi, String d) {
        try {
            
           
              String sqlmekan="";
             
              sqlmekan = "update mekanTablo set mekanAd='"  +adi+ "' where mekan_id='" +d+ "'";
             
            st.executeUpdate(sqlmekan);
           
            JOptionPane.showMessageDialog(null, "Başarıyla güncellendi..");
           
        } catch (SQLException ex) {

        }

    }
   public void kullaniciGuncele(String degis, String d,int index) {
        try {
          
            String sqlkul = "";
            if (index == 0) {
                sqlkul = "update kullanici set sifre='" + degis + "' where kullan_id='" + d + "'";
            } else if (index == 1) 
            {
                sqlkul = "update kullanici set pin='" + degis + "' where kullan_id='" + d + "'";
            }
             else if (index ==2) 
            {
                sqlkul = "update kullanici set yetki='" + degis + "' where kullan_id='" + d + "'";
            }
            st.executeUpdate(sqlkul);
            JOptionPane.showMessageDialog(null, "Başarıyla güncellendi..");
          
        } catch (SQLException ex) {

        }

    }
   public void masaGuncele(String adi, String d) {
        try {
            
           
              String sqlmasa="";
             
            sqlmasa = "update masaTablo set masaAd='"  +adi+ "' where masa_id='" +d+ "'";
             
            st.executeUpdate(sqlmasa);
           
            JOptionPane.showMessageDialog(null, "Başarıyla güncellendi..");
           
        } catch (SQLException ex) {

        }

    }
   public void urunGuncele(String adi, String d) {
        try {
            
           
              String sqlurun="";
             
            sqlurun = "update urunTablo set urunadet='"  +adi+ "' where ur_id='" +d+ "'";
             
            st.executeUpdate(sqlurun);
           
            JOptionPane.showMessageDialog(null, "Başarıyla güncellendi..");
           
        } catch (SQLException ex) {

        }

    }
   
   
   
   
   public String[][] menufiltreListele(String aranan, String filtre) {
        int j = 0;

        try {
            rs = st.executeQuery("Select * from menutablo where " + filtre + "='" + aranan + "';");
            while (rs.next()) {
                j++;
            }
            count = j;
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }

        String dizi[][] = new String[count][7];
        try {
            int i = 0;
            rs = st.executeQuery("Select * from menutablo where " + filtre + "='" + aranan + "';");
            while (rs.next()) {
                //dizi[i][0] = String.valueOf(i + 1);
                dizi[i][0] = rs.getString("me_id");
                dizi[i][1] = rs.getString("menuAd");
                dizi[i][2] = rs.getString("fiyat");
             

                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dizi;
    }
   public String[][] personelfiltreListele(String aranan, String filtre) {
        int j = 0;

        try {
            rs = st.executeQuery("Select * from personeltablo where " + filtre + "='" + aranan + "';");
            while (rs.next()) {
                j++;
            }
            count = j;
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }

        String dizi[][] = new String[count][7];
        try {
            int i = 0;
            rs = st.executeQuery("Select * from personeltablo where " + filtre + "='" + aranan + "';");
            while (rs.next()) {
               // dizi[i][0] = String.valueOf(i + 1);
                dizi[i][0] = rs.getString("pe_id");
                dizi[i][1] = rs.getString("ad");
                dizi[i][2] = rs.getString("soyad");
                dizi[i][3] = rs.getString("evtelno");
                dizi[i][4] = rs.getString("ceptelno");
                dizi[i][5] = rs.getString("aciklama");
                dizi[i][6] = rs.getString("adres");

                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dizi;
    }
   public String[][] kullanicifiltListele(String aranan,String filtre) {
   int j=0;
        try {
            rs = st.executeQuery("Select * from kullanici where "+filtre+"='"+aranan+"';");
            while (rs.next()) {
                j++;
            }count=j;
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        String dizi[][] = new String[count][6];
        try {             
            int i = 0;
            rs = st.executeQuery("Select * from kullanici where "+filtre+"='"+aranan+"';");
            while (rs.next()) {
                //dizi[i][0]= String.valueOf(i+1);             
                dizi[i][0] = rs.getString("kullan_id");
                dizi[i][1] = rs.getString("ad");
                dizi[i][2] = rs.getString("soyad");
                dizi[i][3] = rs.getString("sifre");
                dizi[i][4] = rs.getString("pin");
                dizi[i][5] = rs.getString("yetki");  
                i++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dizi;
    }
   public String[][] urunfiltreListele(String aranan, String filtre) {
        int j = 0;

        try {
            rs = st.executeQuery("Select * from uruntablo where " + filtre + "='" + aranan + "';");
            while (rs.next()) {
                j++;
            }
            count = j;
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }

        String dizi[][] = new String[count][4];
        try {
            int i = 0;
            rs = st.executeQuery("Select * from uruntablo where " + filtre + "='" + aranan + "';");
            while (rs.next()) {
                //dizi[i][0] = String.valueOf(i + 1);
                dizi[i][0] = rs.getString("ur_id");
                dizi[i][1] = rs.getString("urunad");
                dizi[i][2] = rs.getString("urunfiyat");
                dizi[i][3] = rs.getString("urunadet");
             

                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dizi;
    }
   
   

 public String  kullanıcıDenetleme(String ad,String sifre)  {
     String deger=null;
        try {
            rs = st.executeQuery("select * from kullanici where ad='"+ad+ "' AND sifre='" + sifre + "';");
            rs = st.executeQuery("select * from kullanici where pin='"+ad+ "' OR sifre='" + sifre + "';");
            
            while(rs.next())
            deger=rs.getString("yetki");
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deger;
       
    }
 
public int SatirSayisi(String TabloAdi) {
        int say = 0;
        try {
            rs = st.executeQuery("select *from " + TabloAdi + ";");
            while (rs.next()) {
                say++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return say;
    }

public void durumdegis(String masa_ad,String mekan_ad){
    try {           
        String sqlmekan1 = "update masaTablo set durum='"+durum+"' where masaad='"+masa_ad+"' AND mekanad='" +mekan_ad+ "'";
             
            st.executeUpdate(sqlmekan1);
            
            System.out.println(durum);
             
        } catch (SQLException ex) {

        }
}
}