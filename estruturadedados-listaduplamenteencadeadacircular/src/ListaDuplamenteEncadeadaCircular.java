public class ListaDuplamenteEncadeadaCircular {
	private No primeiro;
	private No ultimo;
	
	public ListaDuplamenteEncadeadaCircular() {
		this.primeiro = null;
		this.ultimo = null;
	}
	
	public void AdicionarNoFinal(int dado) {
		No novoNo = new No(dado);
		if (primeiro == null) {
			primeiro = novoNo;
			ultimo = novoNo;
			primeiro.proximo = primeiro;
			primeiro.anterior = ultimo;
		} else {
			ultimo.proximo = novoNo;
			novoNo.anterior = ultimo;
			novoNo.proximo = primeiro;
			primeiro.anterior = novoNo;
			ultimo = novoNo;
		}
	}
	
	public void imprimirLista() {
        if (primeiro == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        No atual = primeiro;
        do {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        } while (atual != primeiro); // Parar quando voltar ao início
        System.out.println();
    }
	
	public void remover(int dado) {
        if (primeiro == null) return;

        No atual = primeiro;
        do {
            if (atual.dado == dado) {
                if (atual == primeiro) {
                    primeiro = atual.proximo;
                    ultimo.proximo = primeiro;
                    primeiro.anterior = ultimo;
                } else if (atual == ultimo) {
                    ultimo = atual.anterior;
                    ultimo.proximo = primeiro;
                    primeiro.anterior = ultimo;
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
                break;
            }
            atual = atual.proximo;
        } while (atual != primeiro);
    }
	
	
}
