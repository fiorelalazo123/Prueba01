package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Trabajador tra = new Trabajador();
    
    
    public Trabajador validar(String user,String pass){
        Trabajador t = new Trabajador();
        String sql = "select * from trabajador where usuario=? and password=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            
            while (rs.next()) {                
                t.setUsuario(rs.getString("usuario"));
                t.setPassword(rs.getString("password"));
                
            }
            
        } catch (Exception e) {
        }
        return t;
    }
     public List listar() {
         
        ArrayList<Trabajador>list=new ArrayList<>();
        String sql="select * from trabajador";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Trabajador tra=new Trabajador();
                tra.setId(rs.getInt("idTrabajador"));
                tra.setNombres(rs.getString("nombres"));
                tra.setApellidos(rs.getString("apellidos"));
                tra.setCorreo(rs.getString("correo"));
                tra.setCelular(rs.getString("celular"));
                tra.setUsuario(rs.getString("usuario"));
                tra.setPassword(rs.getString("password"));
                tra.setEstado(rs.getString("estado"));
                tra.setCargo(rs.getString("tipo_trabajador"));
                list.add(tra);
            }
        } catch (Exception e) {
        }
        return list;
    }
     
      public Trabajador list(int id) {
        String sql="select * from trabajador where idTrabajador="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                tra.setId(rs.getInt("idTrabajador"));
                tra.setNombres(rs.getString("nombres"));
                tra.setApellidos(rs.getString("apellidos"));
                tra.setCorreo(rs.getString("correo"));
                tra.setCelular(rs.getString("celular"));
                tra.setUsuario(rs.getString("usuario"));
                tra.setPassword(rs.getString("password"));
                tra.setCargo(rs.getString("tipo_trabajador"));
                tra.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }
        return tra;
    }


    
       
    public boolean add(Trabajador tra) {
       String sql="insert into trabajador values('"+tra.getId()+"','"+tra.getNombres()+"','"+tra.getApellidos()+"','"+tra.getCorreo()+"','"
               +tra.getCelular()+"','"+tra.getUsuario()+"','"+tra.getPassword()+"','"+tra.getCargo()+"','"+tra.getEstado()+"')";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    public boolean edit(Trabajador tra) {
        String sql="update trabajador set nombres='"+tra.getNombres()+"',apellidos='"+tra.getApellidos()+"',correo='"+tra.getCorreo()+"',celular='"+tra.getCelular()+"',usuario='"+tra.getUsuario()+"',password='"+tra.getPassword()+"',estado='"+tra.getEstado()+"',tipo_trabajador='"+tra.getCargo()+"' where idTrabajador="+tra.getId();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    
     
     public boolean Estado(Trabajador p,int idtrabajador){
        String sql="update trabajador set estado = '"+p.getEstado()+"' where idtrabajador="+idtrabajador;
     
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
            String sql="select estado from trabajador where idtrabajador="+id;
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


