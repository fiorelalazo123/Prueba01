/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ELIAS
 */
public class EquiposDao {
    
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
   Equipos equi = new Equipos();
    
    
    
    
    
    public List listar() {
         
        ArrayList<Equipos>list=new ArrayList<>();
        String sql="select * from equipos";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Equipos equi=new Equipos();
                equi.setId(rs.getInt("idEquipos"));
                equi.setNombre(rs.getString("nombre"));
                equi.setCantidad(rs.getInt("cantidad"));
                equi.setDescripcion(rs.getString("descripcion"));
                equi.setEstado(rs.getString("estado"));
                list.add(equi);
            }
        } catch (Exception e) {
        }
        return list;
    }

    
    public Equipos list(int id) {
        String sql="select * from equipos where idEquipos="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                equi.setId(rs.getInt("idEquipos"));
                equi.setNombre(rs.getString("nombre"));
                equi.setCantidad(rs.getInt("cantidad"));
                equi.setDescripcion(rs.getString("descripcion"));
                equi.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }
        return equi;
    }

    
    public boolean add(Equipos per) {
       String sql="insert into equipos values('"+per.getId()+"','"+per.getNombre()+"','"+per.getCantidad()+"','"+per.getDescripcion()+"','"+per.getEstado()+"')";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    public boolean edit(Equipos per) {
        String sql="update equipos set nombre='"+per.getNombre()+"',cantidad='"+per.getCantidad()+"',descripcion='"+per.getDescripcion()+"',estado='"+per.getEstado()+"' where idEquipos="+per.getId();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    
     public boolean Estado(Equipos p,int idequipos){
         
        String sql="update ejercicio set estado = '"+p.getEstado()+"' where idejercicio="+idequipos;
     
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


