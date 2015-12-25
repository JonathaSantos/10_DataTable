package edu.fanese.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import edu.fanese.entidade.Empregado;

@ManagedBean(name = "empregadoMB")
@SessionScoped
public class EmpregadoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private static List<Empregado> empregados;
	private Empregado empregadoSelecionado;
	private Empregado novoEmpregado;

	static {
		empregados = new ArrayList<Empregado>();
		empregados.add(new Empregado("Luciano", "TI", 1000f));
		empregados.add(new Empregado("Zara", "RH", 2000f));
		empregados.add(new Empregado("Carlos", "ADM", 3000f));
		empregados.add(new Empregado("David", "Gerencia", 4500f));
		empregados.add(new Empregado("Pedro Manoel", "TI", 5000f));
	}

	public List<Empregado> getEmpregados() {
		return empregados;
	}

	public String editarEmpregado() {
		getEmpregadoSelecionado().setPodeEditar(true);

		return null;
	}

	public String deletarEmpregado() {
		empregados.remove(getEmpregadoSelecionado());

		return null;
	}

	public String salvarEmpregados() {
		for (Empregado empregado : empregados) {
			empregado.setPodeEditar(false);
		}

		return null;
	}

	public Empregado getEmpregadoSelecionado() {
		return empregadoSelecionado;
	}

	public void setEmpregadoSelecionado(Empregado empregadoSelecionado) {
		this.empregadoSelecionado = empregadoSelecionado;
	}

	public String adicionarEmpregado(String redirect2) {
		Empregado temporario = novoEmpregado;

		empregados.add(temporario);

		novoEmpregado = new Empregado();

		FacesContext faces = FacesContext.getCurrentInstance();
		ExternalContext context = faces.getExternalContext();
		String redirect = context.getRequestParameterMap().get("redirect");

		if ("true".equals(redirect)) {
			return "listar_empregados?faces-redirect=true";
		} else {
			return null;
		}
	}

	public Empregado getNovoEmpregado() {
		if (null == novoEmpregado) {
			novoEmpregado = new Empregado();
		}

		return novoEmpregado;
	}

	public void setNovoEmpregado(Empregado novoEmpregado) {
		this.novoEmpregado = novoEmpregado;
	}

}
