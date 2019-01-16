package pruebas;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import conexionBD.ConexionBaseDeDatos;
import consultas.ConsultasBD;

public class PruebasDelJarTest {

	@Test
	public void test() {
		ConexionBaseDeDatos conexion = new ConexionBaseDeDatos();
		System.out.println(conexion.crearConexion());
		conexion.cerrarConexion();
	}
	
	@Test
	public void testConsulta(){
		ConsultasBD consulta = new ConsultasBD();
		System.out.println(consulta.consultarEnBaseDatos("SELECT TRAN_AMT FROM TBAADM.DTD WHERE TRIM(TRAN_ID) = 'M15' AND PART_TRAN_TYPE = 'C'"));
		assertNotNull(consulta.consultarEnBaseDatos("SELECT TRAN_AMT FROM TBAADM.DTD WHERE TRIM(TRAN_ID) = 'M15' AND PART_TRAN_TYPE = 'C'"));
		consulta = null;
	}
	
	@Test
	public void testConsultaMultiple() {
		ConsultasBD consulta = new ConsultasBD();
		System.out.println(consulta.consultarEnBaseDatosRecibirVariasFilas("SELECT GAM.FORACID,GAM.CLR_BAL_AMT, PDT.POCKET_TYPE , PDT.POCKET_BALANCE, PDT.POCKET_NAME , GAM.FREZ_REASON_CODE, PDT.CARD_BLOCKED\r\n" + 
				"FROM TBAADM.SMT SMT \r\n" + 
				"INNER JOIN TBAADM.GAM GAM ON SMT.ACID = GAM.ACID \r\n" + 
				"INNER JOIN CUSTOM.CCSPDT PDT ON PDT.FORACID = GAM.FORACID\r\n" + 
				"WHERE \r\n" + 
				"ACCT_STATUS = 'A' AND SMT.BANK_ID = 1500   AND SCHM_CODE = 'SHCAS' AND CLR_BAL_AMT >0 AND GAM.FORACID='87041052095'\r\n" + 
				"AND FREZ_REASON_CODE IS NULL"));
		assertNotNull(consulta.consultarEnBaseDatosRecibirVariasFilas("SELECT GAM.FORACID,GAM.CLR_BAL_AMT, PDT.POCKET_TYPE , PDT.POCKET_BALANCE, PDT.POCKET_NAME , GAM.FREZ_REASON_CODE, PDT.CARD_BLOCKED\r\n" + 
				"FROM TBAADM.SMT SMT \r\n" + 
				"INNER JOIN TBAADM.GAM GAM ON SMT.ACID = GAM.ACID \r\n" + 
				"INNER JOIN CUSTOM.CCSPDT PDT ON PDT.FORACID = GAM.FORACID\r\n" + 
				"WHERE \r\n" + 
				"ACCT_STATUS = 'A' AND SMT.BANK_ID = 1500   AND SCHM_CODE = 'SHCAS' AND CLR_BAL_AMT >0 AND GAM.FORACID='87041052095'\r\n" + 
				"AND FREZ_REASON_CODE IS NULL"));
		consulta = null;
	}


}
