package p81gabrielallende;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

//Definición de la clase. Implementa el Interface ICliente
public class ClienteDAO implements ICliente{
	//Atributo privado de tipo Connection
	private Connection con = null;
	
	//Constructor
	public ClienteDAO() {
		con = Conexion.getInstance();
	}


	@Override
	public List<ClienteVO> getAll() throws SQLException {
		List<ClienteVO> lista = new ArrayList<>();
		
		try (Statement st = con.createStatement()){
			
			ResultSet res = st.executeQuery("SELECT * FROM clientes");
			
			while (res.next()) {
				ClienteVO c = new ClienteVO();
				
				c.setPk(res.getInt("codcli"));
				c.setNombre(res.getString("nomcli"));
				c.setApellido1(res.getString("ape1cli"));
				c.setApellido2(res.getString("ape2cli"));
				c.setTelefono(res.getString("telcli"));
				
				//Añado el objeto a la lista
				lista.add(c);
			}
		}
		return lista;
	}

	@Override
	public ClienteVO findByPk(int pk) throws SQLException {
		ResultSet res = null;
		ClienteVO cliente = new ClienteVO();
		
		String sql = "SELECT * FROM clientes WHERE codcli = ?";
		
		try (PreparedStatement prest = con.prepareStatement(sql)){
			
			prest.setInt(1, pk);
			
			res = prest.executeQuery();
			
			if(res.next()) {
				//Recojo los datos del Cliente y los guardo en un objeto
				cliente.setPk(res.getInt("codcli"));
				cliente.setNombre(res.getString("nomcli"));
				cliente.setApellido1(res.getString("ape1cli"));
				cliente.setApellido2(res.getString("ape2cli"));
				cliente.setTelefono(res.getString("telcli"));
				
				return cliente;
			}
			return null;
		}
	}

	@Override
	public int insertCliente(ClienteVO cliente) throws SQLException {
		int numFilas = 0;
		
        String sql = "INSERT INTO clientes VALUES (?, ?, ?, ?, ?)";

        if (findByPk(cliente.getPk()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, cliente.getPk());
                prest.setString(2, cliente.getNombre());
                prest.setString(3, cliente.getApellido1());
                prest.setString(4, cliente.getApellido2());
                prest.setString(5, cliente.getTelefono());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
	}

	@Override
	public int insertCliente(List<ClienteVO> lista) throws SQLException {
		 int numFilas = 0;

	        for (ClienteVO tmp : lista) {
	            numFilas += insertCliente(tmp);
	        }

	        return numFilas;
	}

	@Override
	//Método delete PARAMETRIZADO.
	public int deleteCliente(ClienteVO cliente) throws SQLException {

		int numFilas = 0;

        String sql = "DELETE FROM clientes WHERE codcli = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, cliente.getPk());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
	}

	@Override
	public int deleteCliente() throws SQLException {
		String sql = "DELETE FROM clientes";

        int nfilas = 0;

        // Preparamos el borrado de datos  mediante un Statement
        // No hay parámetros en la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecución de la sentencia
            nfilas = st.executeUpdate(sql);
        }

        // El borrado se realizó con éxito, devolvemos filas afectadas
        return nfilas;
	}

	@Override
	public int updateCliente(int pk, ClienteVO nuevosDatos) throws SQLException {
		int numFilas = 0;
        String sql = "UPDATE clientes SET nomcli = ?, ape1cli = ?, ape2cli = ?, telcli = ? WHERE codcli = ?";

        if (findByPk(pk) == null) {
            // El Cliente a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setString(1, nuevosDatos.getNombre());
                prest.setString(2, nuevosDatos.getApellido1());
                prest.setString(3, nuevosDatos.getApellido2());
                prest.setString(4, nuevosDatos.getTelefono());
                prest.setInt(5, pk);

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
	}

}
