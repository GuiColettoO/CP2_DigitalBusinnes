package br.com.fiap.Entity;

import java.util.Calendar;

import br.com.fiap.principal.Produto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="T_PRODUTO")
@SequenceGenerator(name="produto", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class ProdutoEntity {
	
	@Id
	@Column(name = "cd_produto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private long uuid;
	
	@Column(name = "ds_name")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Calendar dataCadastro;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_atualizacao")
	private Calendar dataAtualizacao;
	
	@Column(name="ds_produtoHabilitado")
	private boolean produtoHabilitado;
	
	public ProdutoEntity() {}
	
	public ProdutoEntity(Produto produto) {
		this.nome = produto.getNome();
		this.dataCadastro = produto.getDataCadastro();
		this.dataAtualizacao = produto.getDataAtualizacao();
		this.produtoHabilitado = produto.isProdutoHabilitado();
	}

	public long getUuid() {
		return uuid;
	}

	public void setUuid(long uuid) {
		this.uuid = uuid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public boolean isProdutoHabilitado() {
		return produtoHabilitado;
	}

	public void setProdutoHabilitado(boolean produtoHabilitado) {
		this.produtoHabilitado = produtoHabilitado;
	}
}
