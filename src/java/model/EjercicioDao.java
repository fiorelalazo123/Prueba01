package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EjercicioDao {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Ejercicio ej = new Ejercicio();
           
    public List listar(){
        ArrayList<Ejercicio> list= new ArrayList<>();
        String sql ="select * from ejercicio";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Ejercicio ej= new Ejercicio();
                ej.setId(rs.getInt("idEjercicio"));
                ej.setNombre(rs.getString("nombre"));
                ej.setMusculo(rs.getString("musculo"));
                ej.setEstado(rs.getString("estado"));
                list.add(ej);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Ejercicio list(int id) { //no//*
        String sql="select * from ejercicio where idEjercicio="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                ej.setId(rs.getInt("idEjercicio"));
                ej.setNombre(rs.getString("nombre"));
                ej.setMusculo(rs.getString("musculo"));
                ej.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            
        }
   
        return ej;
    }
    public boolean add(Ejercicio ej){
        String sql="insert into ejercicio values('"+ej.getId()+"','"+ej.getNombre()+"','"+ej.getMusculo()+"','"+ej.getEstado()+"')";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return false;
    }
    public boolean edit(Ejercicio ej){
        String sql="update ejercicio set nombre='"+ej.getNombre()+"',musculo='"+ej.getMusculo()+"',estado='"+ej.getEstado()+"' where idEjercicio="+ej.getId();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return false;
    }
    
    
     public boolean Estado(Ejercicio p,int idejercicio){
        String sql="update ejercicio set estado = '"+p.getEstado()+"' where idejercicio="+idejercicio;
     
     try {
          con=cn.getConnection();
         ps=con.prepareStatement(sql);
         ps.executeUpdate();
     } catch (Exception e) {
     }
     

 return  false;
 }
     
     
     public static String getestado(int id){
      try {
            String sql="select estado from ejercicio where idejercicio="+id;
            Connection connection=Conexion.Conectar();
            PreparedStatement prepare=connection.prepareStatement(sql);
            ResultSet resultSet=prepare.executeQuery();
          if(resultSet.next()) {
            return resultSet.getString("estado");
            
            }
          return "--";
            
        } catch (Exception e) {
            return "--";
        }
 }
    }


