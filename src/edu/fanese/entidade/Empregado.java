package edu.fanese.entidade;

import java.io.Serializable;

public class Empregado extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private String departamento;
	private float salario;
	private boolean podeEditar;

	public Empregado() {
	}

	public Empregado(String nome, String departamento, float salario) {
		super(nome);
		this.departamento = departamento;
		this.salario = salario;
		this.podeEditar = false;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public boolean isPodeEditar() {
		return podeEditar;
	}

	public void setPodeEditar(boolean podeEditar) {
		this.podeEditar = podeEditar;
	}
}
