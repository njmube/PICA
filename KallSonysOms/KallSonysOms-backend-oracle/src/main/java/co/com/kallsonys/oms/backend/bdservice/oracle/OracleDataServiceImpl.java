package co.com.kallsonys.oms.backend.bdservice.oracle;

import java.util.List;

import co.com.kallsonys.oms.backend.dao.oracle.CampanaDao;
import co.com.kallsonys.oms.backend.dao.oracle.ClienteDao;
import co.com.kallsonys.oms.backend.dao.oracle.OrdenDao;
import co.com.kallsonys.oms.backend.dao.oracle.TarjetaDao;
import co.com.kallsonys.oms.backend.entity.oracle.Campana;
import co.com.kallsonys.oms.backend.entity.oracle.Cliente;
import co.com.kallsonys.oms.backend.entity.oracle.Orden;
import co.com.kallsonys.oms.backend.entity.oracle.Tarjeta;

public class OracleDataServiceImpl extends OracleDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8998750844680817948L;
	
	private static OracleDataServiceImpl INSTANCE;
	private CampanaDao campanaDao = new CampanaDao();
	private ClienteDao clienteDao = new ClienteDao();
	private OrdenDao ordenDao = new OrdenDao();
	private TarjetaDao tarjetaDao = new TarjetaDao();
	
	public synchronized static OracleDataServiceImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new OracleDataServiceImpl();
		}
		return INSTANCE;
	}
	
	public static OracleDataService get() {
        return OracleDataServiceImpl.getInstance();
    }
	
	@Override
	public List<Campana> getAllCampanas(){
		return campanaDao.getAllCampanas();
	}
	
	@Override
	public void actualizarCampanas( Campana c ){
		campanaDao.actualizarCampanas(c);
	}
	
	@Override
	public List<Cliente> getAllClientes(){
		return clienteDao.getAll();
	}
	
	@Override
	public  void actualizarCliente( Cliente c ){
		clienteDao.actualizar(c);
	}
	
	@Override
	public void eliminarCampana( Campana c ){
		campanaDao.eliminarCampana(c);
	}
	
	@Override
	public List<Orden> getOrdenesParaCancelar(){
		return ordenDao.getOrdenesParaCancelar();
	}
	
	@Override
	public  Tarjeta getTarjetaXId( long idTarjeta ){
		return tarjetaDao.getTarjetaXId(idTarjeta);
	}
	
	@Override
	public  void cancelarOrden( Orden o ){
		ordenDao.cancelar(o);
	}
	
}
