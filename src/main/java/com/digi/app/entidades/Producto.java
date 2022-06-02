package com.digi.app.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "productos")
public class Producto implements Serializable {


	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;




	

	public Producto(Long idProd, String nombre, PrestamoHipotecario tipoProdHip, PrestamoAutomotor tipoProdAuto,
			Deposito tipoProdDep, List<SegmentoCliente> segCli, double montoMaximo) {
		super();
		this.idProd = idProd;
		this.nombre = nombre;
		this.tipoProdHip = tipoProdHip;
		this.tipoProdAuto = tipoProdAuto;
		this.tipoProdDep = tipoProdDep;
		this.segCli = segCli;
		this.montoMaximo = montoMaximo;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProd;
	
	
	@Column(unique=true)
	private String nombre;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn()
	private PrestamoHipotecario tipoProdHip;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn()
	private PrestamoAutomotor tipoProdAuto;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn()
	private Deposito tipoProdDep;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idprod_segm_client")
	private List <SegmentoCliente> segCli;
	private double montoMaximo;




	public Long getIdProd() {
		return idProd;
	}

	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public PrestamoHipotecario getTipoProdHip() {
		return tipoProdHip;
	}

	public void setTipoProdHip(PrestamoHipotecario tipoProdHip) {
		this.tipoProdHip = tipoProdHip;
	}

	public PrestamoAutomotor getTipoProdAuto() {
		return tipoProdAuto;
	}

	public void setTipoProdAuto(PrestamoAutomotor tipoProdAuto) {
		this.tipoProdAuto = tipoProdAuto;
	}

	public Deposito getTipoProdDep() {
		return tipoProdDep;
	}

	public void setTipoProdDep(Deposito tipoProdDep) {
		this.tipoProdDep = tipoProdDep;
	}

	public double getMontoMaximo() {
		return montoMaximo;
	}

	public void setMontoMaximo(double montoMaximo) {
		this.montoMaximo = montoMaximo;
	}
	
	public List<SegmentoCliente> getSegCli() {
		return segCli;
	}
	public void setSegCli(List<SegmentoCliente> segCli) {
		this.segCli = segCli;
	}
	
	public void addSegmentoCliente(SegmentoCliente sCli) {
		this.segCli.add(sCli);
		}
	
	/*public double calcularMontoMaximo(TipoProducto tipoProd) {
		if(tipoProd!= null) {
			return tipoProd.getPrestamoHipoteca().getCantCuota() * tipoProd.getPrestamoHipoteca().getValorCuota();
		}
		else {
			return 0;
		}
	}*/
	
	
	
}
