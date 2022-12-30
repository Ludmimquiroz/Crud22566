/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import  Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class AfiliadosDAO 
{
    Connection conexion;
    
    public AfiliadosDAO()
    {
        Conexion con=new Conexion();
        conexion=con.getConnection();
    }
  
    public List<Afiliados> listarAfiliados()
    {
        PreparedStatement ps;
        ResultSet rs;
        List<Afiliados> lista=new ArrayList<>();
        try
        {
            ps=conexion.prepareStatement("select * from afiliados");
            rs=ps.executeQuery();
            while(rs.next())
            {
             int id=rs.getInt("idAfiliados");
             String nombre=rs.getString("nombre");
             String apellido=rs.getString("apellido");
             String direccion=rs.getString("direccion");
             String localidad=rs.getString("localidad");
             String nacionalidad=rs.getString("nacionalidad");
             LocalDate fnac=rs.getDate("fnac").toLocalDate();
             String mail=rs.getString("mail");
             String telefono=rs.getString("telefono");
             boolean activo=rs.getBoolean("activo");
             
             
             
             
             Afiliados a1=new Afiliados(id,nombre,apellido,direccion,localidad,nacionalidad,fnac,mail,telefono,activo);
             
             lista.add(a1);
            
            }
            
            return lista;
            
            
                    
        }
        catch(SQLException e)
        {
             System.out.println(e);
             return null;
             
        }
    }
    
 public Afiliados mostrarAfiliado(int _id)
 {
      PreparedStatement ps;
        ResultSet rs;
        Afiliados a1=null;
        try
        {
             ps=conexion.prepareStatement("select * from afiliados where idAfiliados=?");
            ps.setInt(1, _id);
            rs=ps.executeQuery();
            while(rs.next())
            {
             int id=rs.getInt("idAfiliados");
             String nombre=rs.getString("nombre");
             String apellido=rs.getString("apellido");
             String direccion=rs.getString("direccion");
             String localidad=rs.getString("localidad");
             String nacionalidad=rs.getString("nacionalidad");
             LocalDate fnac=rs.getDate("fnac").toLocalDate();
             String mail=rs.getString("mail");
             String telefono=rs.getString("telefono");
             boolean activo=rs.getBoolean("activo");
             a1=new Afiliados(id, nombre,apellido,direccion,localidad,nacionalidad,fnac,mail,telefono,activo);
            }
            return a1;
        }
        
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
 }
 
 
    public boolean agregarAfiliado(Afiliados a1)
    {
        PreparedStatement ps;
        
        try
        {
            ps=conexion.prepareStatement("insert into afiliados (nombre,apellido,direccion,localidad,nacionalidad,fnac,email,telefono,activo) values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, a1.getNombre());
            ps.setString(2, a1.getApellido());
            ps.setString(3, a1.getDireccion());
            ps.setString(4, a1.getLocalidad());
            ps.setString(5, a1.getNacionalidad());
            ps.setObject(6, a1.getFnac()); 
            ps.setString(7, a1.getMail());
            ps.setString(8, a1.getTelefono());
            ps.setBoolean(9, true);
            ps.execute();
            return true;        
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    public boolean eliminarAfiliado( int _id)
    {
        PreparedStatement ps;
        
        try
        {
            ps=conexion.prepareStatement("delete from afiliados where idAfiliados=?");
            ps.setInt(1,_id);            
            ps.execute();
            return true;  
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean ActualizarAfiliados(Afiliados a1)
    {
        PreparedStatement ps;        
        try
        {
            ps=conexion.prepareStatement("update afiliados set nombre=?,apellido=?,direccion=?,localidad=?, nacionalidad=?,fnac=?,email=?,telefono=?,activo=? where idAfiliados=?");
            ps.setString(1, a1.getNombre());
            ps.setString(2, a1.getApellido());
            ps.setString(3, a1.getDireccion());
            ps.setString(4, a1.getLocalidad());
            ps.setString(5, a1.getNacionalidad());
            ps.setObject(6, a1.getFnac()); 
            ps.setString(7, a1.getMail());
            ps.setString(8, a1.getTelefono());
            ps.setBoolean(9, a1.isActivo());
            ps.setInt(10,a1.getIdAfiliados());
            ps.execute();
            return true;          
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
}
