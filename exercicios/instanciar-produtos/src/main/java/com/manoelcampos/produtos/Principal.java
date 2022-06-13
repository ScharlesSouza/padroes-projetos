package com.mycompany.exerciciobuilder;
import com.mycompany.exerciciobuilder.model.ProdutoBuilder;

/**
 *
 * @author Scharles
 */
public class Principal {

    public static void main(String[] args) {
        ProdutoBuilder builder = new ProdutoBuilder();
        //ProdutoBuilder builder = new ProdutoBuilder(2, "TV 55 polegadas","LG",2000, "Eletronico");
        try {
            var produto = builder
                    .id(2)
                    .modelo("Smart TV")
                    .marca("LG")//se remover ou comentar esse parametro vai retornar uma msg de erro.
                    .preco(2000)
                    .preco(-1)
                    .build();

            System.out.println(produto.toString());

        }catch (Exception erro){
            System.out.println(erro.getMessage());

        }
    }
}
