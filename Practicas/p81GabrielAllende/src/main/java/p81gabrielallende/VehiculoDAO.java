package p81gabrielallende;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

//Definición de la clase. Implementa el Interface ICliente
public class VehiculoDAO implements IVehiculo{
	//Atributo privado de tipo Connection
	private Connection con = null;
	
	//Constructor
	public VehiculoDAO() {
		con = Conexion.getInstance();
	}

	@Override
	public List<VehiculoVO> getAll() throws SQLException {
		List<VehiculoVO> lista = new ArrayList<>();
		
		try (Statement st = con.createStatement()){
			
			ResultSet res = st.executeQuery("SELECT * FROM vehiculos");
			
			while (res.next()) {
				VehiculoVO c = new VehiculoVO();
				
				c.setPk(res.getString("matricula"));
				c.setMarca(res.getString("marca"));
				c.setModelo(res.getString("modelo"));
				c.setPuertas(res.getInt("puertas"));
				c.setAuto(res.getBoolean("automatico"));
				
				//Añado el objeto a la lista
				lista.add(c);
			}
		}
		return lista;
	}

	@Override
	public VehiculoVO findByPk(String pk) throws SQLException {
		ResultSet res = null;
		VehiculoVO vehiculo= new VehiculoVO();
		
		String sql = "SELECT * FROM vehiculos WHERE matricula = ?";
		
		try (PreparedStatement prest = con.prepareStatement(sql)){
			
			prest.setString(1, pk);
			
			res = prest.executeQuery();
			
			if(res.next()) {
				//Recojo los datos del Cliente y los guardo en un objeto
				vehiculo.setPk(res.getString("matricula"));
				vehiculo.setMarca(res.getString("marca"));
				vehiculo.setModelo(res.getString("modelo"));
				vehiculo.setPuertas(res.getInt("puertas"));
				vehiculo.setAuto(res.getBoolean("automatico"));
				
				return vehiculo;
			}
			return null;
		}
	}

	@Override
	public int insertVehiculo(VehiculoVO vehiculo) throws SQLException {
		int numFilas = 0;
		
        String sql = "INSERT INTO vehiculos VALUES (?, ?, ?, ?, ?)";

        if (findByPk(vehiculo.getPk()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setString(1, vehiculo.getPk());
                prest.setString(2, vehiculo.getMarca());
                prest.setString(3, vehiculo.getModelo());
                prest.setInt(4, vehiculo.getPuertas());
                prest.setBoolean(5, vehiculo.isAuto());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
	}

	@Override
	public int insertVehiculo(List<VehiculoVO> lista) throws SQLException {
		 int numFilas = 0;

	        for (VehiculoVO tmp : lista) {
	            numFilas += insertVehiculo(tmp);
	        }

	        return numFilas;
	}

	@Override
	//Método delete PARAMETRIZADO.
	public int deleteVehiculo(VehiculoVO vehiculo) throws SQLException {

		int numFilas = 0;

        String sql = "DELETE FROM vehiculos WHERE matricula = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setString(1, vehiculo.getPk());
            // Ejecutamos la sentencia
            numFilas = prest.executeUpdate();
        }
        return numFilas;
	}

	@Override
	public int deleteVehiculo() throws SQLException {
		String sql = "DELETE FROM vehiculos";

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
	public int updateVehiculo(String pk, VehiculoVO nuevosDatos) throws SQLException {
		int numFilas = 0;
        String sql = "UPDATE vehiculos SET marca = ?, modelo = ?, puertas = ?, automatico = ? WHERE matricula = ?";

        if (findByPk(pk) == null) {
            // El Cliente a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setString(1, nuevosDatos.getMarca());
                prest.setString(2, nuevosDatos.getModelo());
                prest.setInt(3, nuevosDatos.getPuertas());
                prest.setBoolean(4, nuevosDatos.isAuto());
                prest.setString(5, pk);

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
	}
}


	