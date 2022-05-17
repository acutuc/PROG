package p81gabrielallende;

import java.sql.SQLException;
import java.util.List;


//Definición del Interface
public interface ICliente {

	// Método para obtener todos los registros de la tabla
    List<ClienteVO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    ClienteVO findByPk(int pk) throws SQLException;
    
    // Método para insertar un registro
    int insertCliente (ClienteVO cliente) throws SQLException;
    
    // Método para insertar varios registros
    int insertCliente (List<ClienteVO> lista) throws SQLException;
    
    // Método para borrar una persona
    int deleteCliente (ClienteVO c) throws SQLException;
    
    // Método para borrar toda la tabla
    int deleteCliente() throws SQLException;
    
    // Método para modificar un Cliente. Se modifica al Cliente que tenga esa 'pk'
    // con los nuevos datos que traiga el Cliente --> 'nuevosDatos'
    int updateCliente (int pk, ClienteVO nuevosDatos) throws SQLException;
}
