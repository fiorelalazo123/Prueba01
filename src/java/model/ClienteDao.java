package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Cliente cli= new Cliente();
    
    public List listar(){
        ArrayList<Cliente>list = new ArrayList<>();
        String sql="select * from cliente";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cli= new Cliente();
                cli.setId(rs.getInt("idCliente"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("apellido"));
                cli.setCorreo(rs.getString("correo"));
                cli.setCelular(rs.getString("celular"));
                cli.setDni(rs.getString("dni"));
                cli.setEdad(rs.getString("edad"));
                cli.setEstado(rs.getString("estado"));
                list.add(cli);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Cliente list (int id){
        String sql="select * from cliente where idCliente="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cli.setId(rs.getInt("idCliente"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("apellido"));
                cli.setCorreo(rs.getString("correo"));
                cli.setCelular(rs.getString("celular"));
                cli.setDni(rs.getString("dni"));
                cli.setEdad(rs.getString("edad"));
                cli.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }
        return cli;
    }
    public boolean add(Cliente cli){
        String sql="insert into cliente values('"+cli.getId()+"','"+cli.getNombre()+"','"+cli.getApellido()+"','"+cli.getCorreo()+"','"+cli.getCelular()+"','"+cli.getDni()+"','"+cli.getEdad()+"','"+cli.getEstado()+"')";
                try {
            con= cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
                return false;
    }
  public boolean edit(Cliente cli){
      String sql="update cliente set nombre='"+cli.getNombre()+"',apellido='"+cli.getApellido()+"',correo='"+cli.getCorreo()+"',celular='"+cli.getCelular()+"',dni='"+cli.getDni()+"',edad='"+cli.getEdad()+"',estado='"+cli.getEstado()+"' where idCliente="+cli.getId();
      try {
          con= cn.Conexion();
          ps=con.prepareStatement(sql);
          ps.executeUpdate();
      } catch (Exception e) {
      }
      return false;
  } 
     public boolean Estado(Cliente cli,int idcliente){
        String sql="update cliente set estado = '"+cli.getEstado()+"' where idcliente="+idcliente;
     
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
            String sql="select estado from cliente where idcliente="+id;
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


