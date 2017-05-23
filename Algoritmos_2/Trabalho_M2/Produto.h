#ifndef PRODUTO_H_INCLUDED
#define PRODUTO_H_INCLUDED

#include <iostream>
#include <fstream>


class Produto {
        char nome[100];
        int qtde;
        float preCust;
     public:
        Produto(int = 0, float = 0);
        void set_nome();
        void set_qtde();
        void set_preCust();
        std::string get_nome();
        int get_qtde();
        float get_preCust();
        void mostra();
        void grava(std::ofstream &);
        Produto recupera(std::ifstream &);
        friend std::ostream& operator<<(std::ofstream&, Produto&);
        friend std::istream& operator>>(std::ifstream&, Produto&);
};


#endif // PRODUTO_H_INCLUDED
