package br.com.fiap.principal;

import java.util.Calendar;

import br.com.fiap.Entity.ProdutoEntity;

public class Produto {

		private long uuid;
		
		private String nome;

		private Calendar dataCadastro;
		
		private Calendar dataAtualizacao;

		private boolean produtoHabilitado;
		
		public Produto(ProdutoEntity produto) {
			this.nome = produto.getNome();
			this.dataCadastro = produto.getDataCadastro();
			this.dataAtualizacao = produto.getDataAtualizacao();
			this.produtoHabilitado = produto.isProdutoHabilitado();
		}
		
		public Produto() {}
		
		public Produto(String nome, Calendar dataCadastro, Calendar dataAtualizacao, boolean produtoHabilitado) {
			this.nome = nome;
			this.dataCadastro = dataCadastro;
			this.dataAtualizacao = dataAtualizacao;
			this.produtoHabilitado = produtoHabilitado;
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


