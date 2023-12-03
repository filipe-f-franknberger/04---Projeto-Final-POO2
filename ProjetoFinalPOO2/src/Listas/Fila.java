package Listas;

import java.util.Stack;
/**
 * Classe da estrutura de dados Fila.
 * @author filipefranciscof3@gmail.com
 * 
 * @param inicio Parâmetro que utiliza a classe nodo e marca o primeiro elemento presente na fila;
 * @param fim Parâmetro que utiliza a classe nodo e marca o último elemento presente na fila;
 * @param limite Parâmetro inteiro que informa o número máximo de elementos que a fila poderá ter;
 * @param tamanho Parâmetro do tipo inteiro que sinaliza o número de elementos da fila, sendo modificado após uma inserção ou remoção.
 */
public class Fila implements Lista{

	
		private Nodo inicio = null;
		private Nodo fim;
		private int limite = 0;
		private int tamanho = 0;
		
		/**
		 * Construtor da fila, recebe como parâmetro o limite máximo de elementos.
		 * @param limite Parâmetro inteiro que informa o número máximo de elementos que a fila poderá ter;
		 */
		public Fila(int limite) {
			this.limite=limite;
		}
		/**
		 * Método estaVazio
		 * @return retorna verdadeiro se o tamanho for igual a 0 (sem elementos na Fila).
		 */
		
		public boolean estaVazio() {
			return tamanho == 0;
		}
		/**
		 * Método tem espaço;
		 * @return retorna verdadeiro se o limite for maior que o tamanho.
		 */
		public boolean temEspaco() {
			return limite > tamanho;
		}
		/**
		 * getInicio
		 * @return retorna o nodo de inicio se a fila não estiver vazia, caso contrário retornará nulo. 
		 */
		public Nodo getInicio() {
			if(!estaVazio()) {
				return inicio;
			}else {
				System.out.println("Fila está vazia!");
				return null;
			}
		}
		public void inserir(int dado) {
			if(temEspaco()) {
				Nodo novo = new Nodo(dado);
				if(estaVazio()) {
					inicio = novo;
					fim = novo;
				}else {
					fim.setProx(novo);
					fim = novo;
				}
				tamanho++;
			}else {
				System.out.println("Fila cheia!");
			}
		}

		@Override
		public boolean buscar(int valor) {
			Nodo atual = inicio;
		    while (atual != null) {
		        if (atual.getDado() == valor) {
		            return true;
		        }
		        atual = atual.getProx();
		    }
		    return false;
		}

		@Override
		public void ordenar() {
		    Nodo atual, proximo;
		    boolean trocou;
		    do {
		        trocou = false;
		        atual = inicio;
		        while (atual != null && atual.getProx() != null) {
		            proximo = atual.getProx();
		            if (atual.getDado() > proximo.getDado()) {
		                int temp = atual.getDado();
		                atual.setDado(proximo.getDado());
		                proximo.setDado(temp);
		                trocou = true;
		            }
		            atual = atual.getProx();
		        }
		    } while (trocou);
		}

		@Override

		public int tamanho() {
		    return tamanho;
		}

		@Override
		public Lista copiar() {
		    Fila copia = new Fila(limite);
		    Nodo atual = inicio;
		    while (atual != null) {
		        copia.inserir(atual.getDado());
		        atual = atual.getProx();
		    }
		    return copia;
		}

		@Override
	
		public void inverter() {
		    Stack<Integer> pilha = new Stack<>();
		    Nodo atual = inicio;
		    while (atual != null) {
		        pilha.push(atual.getDado());
		        atual = atual.getProx();
		    }
		    atual = inicio;
		    while (!pilha.isEmpty()) {
		        atual.setDado(pilha.pop());
		        atual = atual.getProx();
		    }
		}

		@Override
		public void remover(int valor) {
		    Nodo atual = inicio;
		    Nodo anterior = null;

		    while (atual != null) {
		        if (atual.getDado() == valor) {
		            if (anterior == null) {
		                inicio = atual.getProx();
		            } else {
		                anterior.setProx(atual.getProx());
		            }
		            tamanho--;
		            if (atual == fim) {
		                fim = anterior;
		            }
		        } else {
		        	anterior = atual;
		        }
		        atual = atual.getProx();
		    }
		}

		@Override
		public void alterar(int valorAntigo, int novoValor) {
		    Nodo atual = inicio;
		    while (atual != null) {
		        if (atual.getDado() == valorAntigo) {
		            atual.setDado(novoValor);
		        }
		        atual = atual.getProx();
		    }
		}

		@Override
		public String mostrar() {
		    StringBuilder resultado = new StringBuilder();

		    Nodo atual = inicio;
		    while (atual != null) {
		        resultado.append(atual.getDado()).append(" ");
		        atual = atual.getProx();
		    }

		    return resultado.toString();
		}

}
