#ifndef ESTOQUE_H_INCLUDED
#define ESTOQUE_H_INCLUDED

#include "Produto.h"
#include <vector>

class Estoque {
        std::vector<Produto> produtos;
        int qtdeProdutos;
     public:
        Estoque();
        void consulta_produto();
        void inclui_produto();
        void verifica_nome();
        int get_qtdeProdutos();
        void relatorio();
        void grava();
        void recupera();
};


#endif // ESTOQUE_H_INCLUDED
