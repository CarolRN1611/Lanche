package org.testeprojeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {
    private String descricao;
    private int codigo;
    private double valor;
    private String caminhoimagem;

    public Produto(int codigo, double valor, String caminhoimagem, String descricao) {
        this.codigo = codigo;
        this.valor = valor;
        this.caminhoimagem = caminhoimagem;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCaminhoimagem() {
        return caminhoimagem;
    }

    public void setCaminhoimagem(String caminhoimagem) {
        this.caminhoimagem = caminhoimagem;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "descricao='" + descricao + '\'' +
                ", codigo=" + codigo +
                ", valor=" + valor +
                ", caminhoimagem='" + caminhoimagem + '\'' +
                '}';
    }

    public static int encontrarProduto(List<Produto> listaProduto, int codigo) {
        for (int i = 0; i < listaProduto.size(); i++) {
            if (listaProduto.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Produto> listaProduto = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("1-Cadastrar Produto");
            System.out.println("2-Fazer Venda");
            System.out.println("Qualquer outra tecla para sair");
            int resposta = scanner.nextInt();
            scanner.nextLine();

            if (resposta == 1) {
                System.out.println("Informe o nome do produto");
                String descricao = scanner.nextLine();

                System.out.println("Informe o caminho da imagem do produto");
                String imagem = scanner.nextLine();

                System.out.println("Informe o codigo do produto");
                int codigo = scanner.nextInt();

                System.out.println("Informe o preço do produto");
                double preco = scanner.nextDouble();
                scanner.nextLine();

                Produto p = new Produto(codigo, preco, imagem, descricao);
                listaProduto.add(p);
                System.out.println("Produto cadastrado com sucesso!");

            } else if (resposta == 2) {
                System.out.println("Informe o codigo do produto");
                int codigo = scanner.nextInt();

                int i = encontrarProduto(listaProduto, codigo);

                if (i != -1) {
                    Produto p = listaProduto.get(i);

                    System.out.println("Informe a quantidade do produto");
                    int quantidade = scanner.nextInt();

                    System.out.println("Valor da Compra");
                    System.out.println("Produto: " + p.getDescricao());
                    System.out.println("Valor unitário: " + p.getValor());
                    System.out.println("Quantidade: " + quantidade);
                    System.out.println("Total: " + (p.getValor() * quantidade));
                } else {
                    System.out.println("Código do produto inválido!");
                }

            } else {
                sair = true;
            }
        }
    }
}
