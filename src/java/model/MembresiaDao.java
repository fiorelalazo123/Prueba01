package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MembresiaDao {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Membresia menb= new Membresia();
    
    public List listar(){
        ArrayList<Membresia>list = new ArrayList<>();
        String sql="select * from membresia";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Membresia memb= new Membresia();
                memb.setId(rs.getInt("idmembresia"));
                memb.setTipo(rs.getString("tipo"));
                memb.setPrecio(rs.getDouble("precio"));
                memb.setEstado(rs.getString("estado"));
                
                list.add(memb);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Membresia list (int id){
        String sql="select * from membresia where idMembresia="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                menb.setId(rs.getInt("idmembresia"));
                menb.setTipo(rs.getString("tipo"));
                menb.setPrecio(rs.getDouble("precio"));
                menb.setEstado(rs.getString("estado"));
                
            }
        } catch (Exception e) {
        }
        return menb;
    }
    public boolean add(Membresia mem){
        String sql="insert into membresia values('"+mem.getId()+"','"+mem.getTipo()+"','"+mem.getPrecio()+"','"+mem.getEstado()+"')";
                try {
            con= cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
                return false;
    }
  public boolean edit(Membresia mem){
      String sql="update membresia set tipo='"+mem.getTipo()+"',precio='"+mem.getPrecio()+"',estado='"+mem.getEstado()+"' where idmembresia="+mem.getId();
      try {
          con= cn.Conexion();
          ps=con.prepareStatement(sql);
          ps.executeUpdate();
      } catch (Exception e) {
      }
      return false;
  } 
     public boolean Estado(Membresia mem,int idmembresia){
        String sql="update membresia set estado = '"+mem.getEstado()+"' where idmembresia="+idmembresia;
     
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
            String sql="select estado from membresia where idmembresia="+id;
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


