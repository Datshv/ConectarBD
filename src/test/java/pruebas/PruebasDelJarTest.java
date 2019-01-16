package pruebas;

import org.junit.Test;

import conexionBD.ConexionBaseDeDatos;

public class PruebasDelJarTest {

	@Test
	public void test() {
		ConexionBaseDeDatos conexion = new ConexionBaseDeDatos();
		System.out.println(conexion.crearConexion());
		conexion.cerrarConexion();
	}

}
