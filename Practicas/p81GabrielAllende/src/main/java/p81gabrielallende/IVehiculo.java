package p81gabrielallende;

import java.sql.SQLException;
import java.util.List;


//Definición del Interface
public interface IVehiculo {

	// Método para obtener todos los registros de la tabla
    List<VehiculoVO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    VehiculoVO findByPk(String pk) throws SQLException;
    
    // Método para insertar un registro
    int insertVehiculo (VehiculoVO vehiculo) throws SQLException;
    
    // Método para insertar varios registros
    int insertVehiculo (List<VehiculoVO> lista) throws SQLException;
    
    // Método para borrar un vehiculo
    int deleteVehiculo (VehiculoVO v) throws SQLException;
    
    // Método para borrar toda la tabla
    int deleteVehiculo() throws SQLException;
    
    // Método para modificar un Vehiculo. Se modifica al Vehiculo que tenga esa 'pk'
    // con los nuevos datos que traiga el Vehiculo --> 'nuevosDatos'
    int updateVehiculo (String pk, VehiculoVO nuevosDatos) throws SQLException;
}
