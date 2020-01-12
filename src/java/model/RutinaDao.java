package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RutinaDao {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Rutina rut= new Rutina();
    
    public List listar(){
        ArrayList<Rutina>list = new ArrayList<>();
        String sql="select * from rutina";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Rutina rut= new Rutina();
                rut.setId(rs.getInt("idrutina"));
                rut.setDescripcion(rs.getString("descripcion"));
                rut.setFecha_inicio(rs.getString("fecha_inicio"));
                rut.setFecha_fin(rs.getString("fecha_fin"));
                rut.setEstado(rs.getString("estado"));
                
                list.add(rut);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Rutina list (int id){
        String sql="select * from rutina where idrutina="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                rut.setId(rs.getInt("idrutina"));
                rut.setDescripcion(rs.getString("descripcion"));
                rut.setFecha_inicio(rs.getString("fecha_inicio"));
                rut.setFecha_fin(rs.getString("fecha_fin"));
                rut.setEstado(rs.getString("estado"));
                
            }
        } catch (Exception e) {
        }
        return rut;
    }
    public boolean add(Rutina rut){
        String sql="insert into rutina values('"+rut.getId()+"','"+rut.getDescripcion()+"','"+rut.getFecha_inicio()+"','"+rut.getFecha_fin()+"','"+rut.getEstado()+"')";
                try {
            con= cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
                return false;
    }
  public boolean edit(Rutina rut){
      String sql="update rutina set descripcion='"+rut.getDescripcion()+"',fecha_inicio='"+rut.getFecha_inicio ()+"',fecha_fin='"+rut.getFecha_fin()+"',estado='"+rut.getEstado()+"' where idRutina="+rut.getId();
      try {
          con= cn.Conexion();
          ps=con.prepareStatement(sql);
          ps.executeUpdate();
      } catch (Exception e) {
      }
      return false;
  }    
  
  public boolean Estado(Rutina rut,int idrutina){
        String sql="update rutina set estado = '"+rut.getEstado()+"' where idRutina="+idrutina;
     
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
            String sql="select estado from rutina where idrutina="+id;
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