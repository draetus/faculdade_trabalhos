class Exercicios():
    
    def Ex_1(self):
        cores = ["azul", 'vermelho', 'amarelo', 'verde', 'roxo']
        print (cores)
        
    def Ex_2(self, lista, elemento):
        lista.insert(0, elemento)
        print(lista)
        
    def Ex_3(self, lista, indice):
        return lista[indice]
        
    def Ex_4(self, lista, elemento, novoValor):
        if (lista.__contains__(elemento)):
            x = lista.index(elemento)
            lista[x] = novoValor
            
    def Ex_5(self, lista):
        if (lista.__len__ > 2):
            lista.pop(2)
            
    def Ex_6(self, lista, elemento):
        return lista.__contains__(elemento)
        
    def Ex_7(self, lista1, lista2):
        lista1.append(lista2)
        
    def Ex_8(self, lista):
        lista.sort()
        
    def Ex_9(self, lista):
        lista.reverse()
        
    def Ex_10(self, lista1, lista2):
        lista.extend(lista2)
        
    def Ex_11(self, lista):
        while(lista):
            lista.pop(0)
            
    def Ex_12(self, lista1, lista2):
        lista1.append(lista2)
        
    def Ex_13(self, lista):
        if (lista):
            return False
        else:
            return True
            
###################        
x = Exercicios()
lista = []
lista2 = [1,2,3]
###################

x.Ex_1()

###################

x.Ex_2(lista, 1)
x.Ex_2(lista, 2)
x.Ex_2(lista, 3)
x.Ex_2(lista, 4)

###################

print(x.Ex_3(lista, 0))

###################

x.Ex_4(lista, 2, 3)
print(lista)

###################

x.Ex_5(lista)
print(lista)

###################

print (x.Ex_6(lista, 3))

###################

x.Ex_7(lista, lista2)
print (lista)

####################

x.Ex_8(lista)
print (lista)

####################

x.Ex_9(lista)
print (lista)

####################

x.Ex_10(lista, lista2)
print(lista)

####################

x.Ex_11(lista)
print(lista)

####################

x.Ex_12(lista, lista2)
print (lista)

####################

print(x.Ex_13(lista))