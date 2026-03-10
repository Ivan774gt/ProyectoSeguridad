//Ferdynand Monroy & Anthony Hetzale marzo 2026
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Controlador.Aplicaciones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ferito
 */
public class AplicacionesDAO { //CRUD para la tabla
     private static final String SQL_SELECT = 
    "SELECT aplcodigo, aplnombre, aplestado FROM aplicaciones";

    private static final String SQL_INSERT = 
    "INSERT INTO aplicaciones(aplnombre, aplestado) VALUES(?,?)";

    private static final String SQL_UPDATE = 
    "UPDATE aplicaciones SET aplnombre=?, aplestado=? WHERE aplcodigo=?";

    private static final String SQL_DELETE = 
    "DELETE FROM aplicaciones WHERE aplcodigo=?";

    private static final String SQL_QUERY = 
    "SELECT aplcodigo, aplnombre, aplestado FROM aplicaciones WHERE aplcodigo=?";


    public List<Aplicaciones> select() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Aplicaciones aplicacion;
        List<Aplicaciones> aplicaciones = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int codigo = rs.getInt("aplcodigo");
                String nombre = rs.getString("aplnombre");
                String estado = rs.getString("aplestado");

                aplicacion = new Aplicaciones();
                aplicacion.setAplCodigo(codigo);
                aplicacion.setAplNombre(nombre);
                aplicacion.setAplEstado(estado);

                aplicaciones.add(aplicacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return aplicaciones;
    }


    public int insert(Aplicaciones aplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, aplicacion.getAplNombre());
            stmt.setString(2, aplicacion.getAplEstado());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    public int update(Aplicaciones aplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, aplicacion.getAplNombre());
            stmt.setString(2, aplicacion.getAplEstado());
            stmt.setInt(3, aplicacion.getAplCodigo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    public int delete(Aplicaciones aplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getAplCodigo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    public Aplicaciones query(Aplicaciones aplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, aplicacion.getAplCodigo());

            rs = stmt.executeQuery();

            while (rs.next()) {

                int codigo = rs.getInt("aplcodigo");
                String nombre = rs.getString("aplnombre");
                String estado = rs.getString("aplestado");

                aplicacion.setAplCodigo(codigo);
                aplicacion.setAplNombre(nombre);
                aplicacion.setAplEstado(estado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return aplicacion;
    }

}
