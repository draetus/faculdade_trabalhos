from AntiVirus import AntiVirus
from Detector import Detector

class Interface(object):

    def __init__(self):
        self.__antiVirus = AntiVirus()

    def run(self):
        x = 0
        while (True):
            print("Informe a opcao: ")
            print("1. Verificar Arquivo/Pasta")
            print("2. Adicionar Virus")
            print("3. Listar Virus")
            print("4. Listar Quarentena")
            print("5. Sair")
            x = int(input())

            if (x==1):
                self.__opcao1()
            elif (x==2):
                self.__opcao2()
            elif (x==3):
                self.__opcao3()
            elif (x==4):
                self.__opcao4()
            elif (x==5):
                break

    def __opcao1(self):
        #print("Informe a pasta ou arquivo que deseja verificar:")
        #x = input()
        self.__antiVirus.run('Arquivos')

    def __opcao2(self):
        print('hash do novo virus: ' + Detector.pegaHash('NovoVirus.txt'))
        print("Informe o hash do novo virus:")
        x = input()
        self.__antiVirus.addVirus(x)

    def __opcao3(self):
        print(self.__antiVirus.getVirus())

    def __opcao4(self):
        print(self.__antiVirus.getQuarentena())


x = Interface()
x.run()


