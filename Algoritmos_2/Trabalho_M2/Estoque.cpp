#include "Estoque.h"
#include <string>
#include <stdlib.h>

using namespace std;

/*void operator<<(std::ostream& os, Produto &produto)
{
    os.write((char *)&produto, sizeof(Produto));
}*/


Estoque::Estoque(){
    qtdeProdutos = 0;
}

void Estoque::inclui_produto(){
    Produto novo_nome;
    novo_nome.set_nome();
    int i;
    string conome;
    conome = novo_nome.get_nome(); //variável para consulta no estoque
    bool nenhum = true; //se nenhum produto foi encontrado
    for (i=0;i<qtdeProdutos;i++){
        if(conome==this->produtos[i].get_nome()){
            //system("cls");
            system("clear");
            cout << "Produto ja existente no estoque!" << endl;
            nenhum = false; //se encontrar, retorna falso
            return;
        }
    }
    if (nenhum){
    novo_nome.set_preCust();
    novo_nome.set_qtde();
    this->produtos.push_back(novo_nome); //popula o vector
    qtdeProdutos++; //incrementa a quantidade total de produtos
    system("cls");
    cout << "Produto incluso com sucesso!" << endl;
    }
}

void Estoque::consulta_produto(){
    int i;
    string conome; //variável para consulta no estoque
    bool nenhum = true; //se nenhum produto foi encontrado
    cout << "Informe o nome do produto a ser consultado: " << endl;
    cin.ignore();
    getline(cin,conome);
    for (i=0;i<qtdeProdutos;i++){
        if(conome==this->produtos[i].get_nome()){
            produtos[i].mostra();
            nenhum = false; //se encontrar, retorna falso
            break;
        }
    }
    if (nenhum)
    {
        cout << "Produto nao encontrado!" << endl;
    }

}

void Estoque::relatorio(){
    int i;
    for(i=0;i<qtdeProdutos;i++){
        produtos[i].mostra();
        cout << endl;
    }
}

void Estoque::grava(){
    int i;
    char filename[50];
    ofstream file;
    cout << "Informe o nome do arquivo a ser criado: " << endl;
    cin.ignore();
    gets(filename);
    file.open(filename, ios::binary);
    if(!file){
        cout << "Nao foi possivel criar o arquivo.";
		return;
    }
    cout << "\nArquivo criado com sucesso!" << endl;

    file.write(reinterpret_cast<const char *>(&qtdeProdutos),sizeof(int));
    for(i=0;i<qtdeProdutos;i++){
        file << produtos[i];
    }
    system("pause");
    file.close();
}

void Estoque::recupera(){
    ifstream file;
    char nome[50];
    Produto aux;
    int i=0;

    cout << "Qual arquivo deseja recuperar: ";
    cin.ignore();
    gets(nome);

    file.open(nome, ios::binary);
    if (!file)
    {
        cout << "Nao foi possivel abrir o arquivo";
        return;
    }

    file.read((char *)&qtdeProdutos,sizeof(int));

    for (i=0;i<qtdeProdutos;i++)
    {
        produtos.push_back(aux);
        file >> produtos[i];
        cout << endl;
        produtos[i].mostra();
    }
    file.close();
}
