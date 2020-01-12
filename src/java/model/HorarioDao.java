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
public class HorarioDao {
    
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
   Horario hora = new Horario();
    
    
    
    
    
    public List listar() {
         
        ArrayList<Horario>list=new ArrayList<>();
        String sql="select * from horario";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Horario hora=new Horario();
                hora.setId(rs.getInt("idHorario"));
                hora.setDia(rs.getString("dia"));
                hora.setHoras(rs.getInt("horas"));
                hora.setEstado(rs.getString("estado"));
                list.add(hora);
            }
        } catch (Exception e) {
        }
        return list;
    }

    
    public Horario list(int id) {
        String sql="select * from horario where idHorario="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                hora.setId(rs.getInt("idHorario"));
                hora.setDia(rs.getString("dia"));
                hora.setHoras(rs.getInt("horas"));
                hora.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }
        return hora;
    }

    
    public boolean add(Horario hora) {
       String sql="insert into horario values('"+hora.getId()+"','"+hora.getDia()+"','"+hora.getHoras()+"','"+hora.getEstado()+"')";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    public boolean edit(Horario hora) {
        String sql="update horario set dia='"+hora.getDia()+"',horas='"+hora.getHoras()+"',estado='"+hora.getEstado()+"' where idHorario="+hora.getId();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    
   
     public boolean Estado(Horario h,int idhorario){
        String sql="update horario set estado = '"+h.getEstado()+"' where idhorario="+idhorario;
     
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
            String sql="select estado from horario where idhorario="+id;
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


