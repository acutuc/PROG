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
				
				c.setPk(res.getInt("codvehi"));
				c.setMatricula(res.getString("matricula"));
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
	public VehiculoVO findByPk(int pk) throws SQLException {
		ResultSet res = null;
		VehiculoVO vehiculo= new VehiculoVO();
		
		String sql = "SELECT * FROM vehiculos WHERE codvehi = ?";
		
		try (PreparedStatement prest = con.prepareStatement(sql)){
			
			prest.setInt(1, pk);
			
			res = prest.executeQuery();
			
			if(res.next()) {
				//Recojo los datos del Cliente y los guardo en un objeto
				vehiculo.setPk(res.getInt("codvehi"));
				vehiculo.setMatricula(res.getString("matricula"));
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
		
        String sql = "INSERT INTO vehiculos VALUES (?, ?, ?, ?, ?, ?)";

        if (findByPk(vehiculo.getPk()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
            	prest.setInt(1, vehiculo.getPk());
                prest.setString(2, vehiculo.getMatricula());
                prest.setString(3, vehiculo.getMarca());
                prest.setString(4, vehiculo.getModelo());
                prest.setInt(5, vehiculo.getPuertas());
                prest.setBoolean(6, vehiculo.isAuto());

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

        String sql = "DELETE FROM vehiculos WHERE codvehi = ?";

        // Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            // Establecemos los parámetros de la sentencia
            prest.setInt(1, vehiculo.getPk());
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
	public int updateVehiculo(int pk, VehiculoVO nuevosDatos) throws SQLException {
		int numFilas = 0;
        String sql = "UPDATE vehiculos SET matricula = ?, marca = ?, modelo = ?, puertas = ?, automatico = ? WHERE codvehi = ?";

        if (findByPk(pk) == null) {
            // El Cliente a actualizar no existe
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
            	prest.setString(1, nuevosDatos.getMatricula());
                prest.setString(2, nuevosDatos.getMarca());
                prest.setString(3, nuevosDatos.getModelo());
                prest.setInt(4, nuevosDatos.getPuertas());
                prest.setBoolean(5, nuevosDatos.isAuto());
                prest.setInt(6, pk);

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
	}
}


	