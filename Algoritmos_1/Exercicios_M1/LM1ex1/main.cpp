#include <iostream>

using namespace std;

int main()
{
    float p1,p2,p3,p4,mp,t1,t2,t3,t4,mt,mf;
    cout<<"Informe a primeira nota de prova: ";
    cin>>p1;
    cout<<"Informe a segunda nota de prova: ";
    cin>>p2;
    cout<<"Informe a terceira nota de prova: ";
    cin>>p3;
    cout<<"Informa a quarta nota de prova: ";
    cin>>p4;
    cout<<"Informe a primeira nota de trabalho: ";
    cin>>t1;
    cout<<"Informe a segunda nota de trabalho: ";
    cin>>t2;
    cout<<"Informe a terceira nota de trabalho: ";
    cin>>t3;
    cout<<"Informe a quarta nota de prova: ";
    cin>>t4;
    mp = (p1+p2+p3+p4)/4;
    mt = (t1+t2+t3+t4)/4;
    mf = 0.8*mp+0.2*mt;
    if(mf>=6.0)
    {
        cout<<endl<<"Aprovado";
    }
    else
    {
        cout<<endl<<"Reprovado";
    }
    return 0;
}
