package com.utn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBmanagment
{

    private   static final  String driver ="java.sql.Driver";
    private   static final  String db ="jdbc:mysql://localhost:3306/utn";
    private   static final String user="root";
    private   static final  String pass ="zas333";

    //importamos la libreria de java.sql para Connection
    private Connection ct;
    private Statement st;

    public DBmanagment(){
        try
        {
            Class.forName(driver);
            ct = DriverManager.getConnection(db,user,pass);
            st=ct.createStatement();
        System.out.println("Conexion exitosa");
        }
        catch (Exception e)
        {
            System.out.println("Nos se pudo establecer la conexion"+e);
        }
    }

    public void ShowAll()
    {
        try {
            ResultSet rs = st.executeQuery("Select *from person");
            while (rs.next()){
                System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta" + e);
        }
    }
}
