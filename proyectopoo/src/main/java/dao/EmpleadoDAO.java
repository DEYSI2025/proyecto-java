package dao;

import modelo.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    public List<Empleado> listar() {

        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleado";

        try (
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {
                Empleado e = new Empleado();
                e.setId(rs.getInt("id"));
                e.setNombres(rs.getString("nombres"));
                e.setApellidos(rs.getString("apellidos"));
                e.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                e.setCorreo(rs.getString("correo"));
                e.setCargo(rs.getString("cargo"));
                e.setSueldo(rs.getDouble("sueldo"));
                e.setEstado(rs.getString("estado"));
                lista.add(e);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    
    public void eliminar(int id) {

        String sql = "DELETE FROM empleado WHERE id=?";

        try (
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= INSERTAR =================
    public void insertar(Empleado e) {

        String sql = "INSERT INTO empleado " +
                "(nombres, apellidos, fecha_nacimiento, correo, cargo, sueldo, estado) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, e.getNombres());
            ps.setString(2, e.getApellidos());
            ps.setDate(3, e.getFechaNacimiento()); // 👈 AQUÍ ESTÁ LA CLAVE
            ps.setString(4, e.getCorreo());
            ps.setString(5, e.getCargo());
            ps.setDouble(6, e.getSueldo());
            ps.setString(7, e.getEstado());

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public Empleado obtenerPorId(int id) {

        Empleado e = new Empleado();
        String sql = "SELECT * FROM empleado WHERE id = ?";

        try (
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                e.setId(rs.getInt("id"));
                e.setNombres(rs.getString("nombres"));
                e.setApellidos(rs.getString("apellidos"));
                e.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                e.setCorreo(rs.getString("correo"));
                e.setCargo(rs.getString("cargo"));
                e.setSueldo(rs.getDouble("sueldo"));
                e.setEstado(rs.getString("estado"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }
    
 // === ACTUALIZAR ===
    public void actualizar(Empleado e) {

        String sql = "UPDATE empleado SET nombres=?, apellidos=?, fecha_nacimiento=?, correo=?, cargo=?, sueldo=?, estado=? WHERE id=?";

        try (
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, e.getNombres());
            ps.setString(2, e.getApellidos());
            ps.setDate(3, e.getFechaNacimiento()); // 👈 YA ES Date, TODO BIEN
            ps.setString(4, e.getCorreo());
            ps.setString(5, e.getCargo());
            ps.setDouble(6, e.getSueldo());
            ps.setString(7, e.getEstado());
            ps.setInt(8, e.getId());

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
