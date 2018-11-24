package contrato;

import java.io.Serializable;
import java.util.Date;

import cliente.Cliente;

public class Contrato implements Serializable {
	
	private static final long serialVersionUID = 7546461218388905298L;

	private Cliente cliente;
	private TipoContrato tipoContrato;
	private double valor;
	private Date dataEmissao;
	private Date inicioValidade;
	private Date fimValidade;
	private String descricao;
	private int numero;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getInicioValidade() {
		return inicioValidade;
	}

	public void setInicioValidade(Date inicioValidade) {
		this.inicioValidade = inicioValidade;
	}

	public Date getFimValidade() {
		return fimValidade;
	}

	public void setFimValidade(Date fimValidade) {
		this.fimValidade = fimValidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "" + cliente 
				+ "\n" + tipoContrato 
				+ "\nValor: " + valor 
				+ "\n" + "Descrição: " + descricao 
				+ "\nDataEmissao: " + dataEmissao 
				+ "\nValidade: " + inicioValidade + " até " + fimValidade;
	}
	
}
