package co.com.kallsonys.oms.backend.entity.oracle;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CIUDAD database table.
 * 
 */
@Entity
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CiudadPK id;

	private String nombre;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="IDPAIS")
	private Pais pais;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="ciudad")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Orden
	@OneToMany(mappedBy="ciudad")
	private List<Orden> ordens;

	public Ciudad() {
	}

	public CiudadPK getId() {
		return this.id;
	}

	public void setId(CiudadPK id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setCiudad(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setCiudad(null);

		return cliente;
	}

	public List<Orden> getOrdens() {
		return this.ordens;
	}

	public void setOrdens(List<Orden> ordens) {
		this.ordens = ordens;
	}

	public Orden addOrden(Orden orden) {
		getOrdens().add(orden);
		orden.setCiudad(this);

		return orden;
	}

	public Orden removeOrden(Orden orden) {
		getOrdens().remove(orden);
		orden.setCiudad(null);

		return orden;
	}

}