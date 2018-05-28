import os
from RepositorioHash import RepositorioHash
from Detector import Detector


class AntiVirus(object):

    #virus = RepositorioHash()
    #quarentena = RepositorioHash()
    __arquivos = []

    def __init__(self):
        if (os.path.isfile("Virus/Virus.bin")):
            self.__virus = RepositorioHash("Virus/Virus.bin")
        else:
            self.__virus = RepositorioHash()

        if (os.path.isfile("Quarentena/Quarentena.bin")):
            self.__quarentena = RepositorioHash("Quarentena/Quarentena.bin")
        else:
            self.__quarentena = RepositorioHash()

    def __loadFiles(self, filepath):
        if (os.path.isdir(os.path.abspath(filepath))):
            for files in os.listdir(filepath):
                if (os.path.isdir(os.path.abspath(files))):
                    self.__loadFiles(filepath + "/" + files)
                else:
                    self.__arquivos.append(filepath + "/" + files)
        else:
            self.__arquivos.append(filepath)

    def run(self, filepath):
        self.__loadFiles(filepath)
        x = True
        for files in self.__arquivos:
            if (Detector.DetectaVirus(self.__virus, files)):
                x = False
                opc = 0
                while (opc < 1 or opc > 3):
                    print("Virus Detectado: O que deseja fazer?")
                    print("1-Colocar na Quarentena")
                    print("2-Deletar Arquivo")
                    print("3-Ignorar Ameaça")
                    opc = int(input("Seleciona uma opcao: "))

                if (opc == 1):
                    self.__addToQuarentena(os.path.abspath(files))
                elif (opc == 2):
                    os.remove(files)

        self.__saveAll()
        if (x):
            print('Nenhuma Ameaça Foi Detectada')

    def __addToQuarentena(self, filename):
        self.__quarentena.add(Detector.pegaHash(filename))
        os.rename(filename, "Quarentena/" + os.path.basename(filename))

    def __saveAll(self):
        self.__virus.save("Virus/Virus.bin")
        self.__quarentena.save("Quarentena/Quarentena.bin")

    def addVirus(self, virus):
        if (not (self.__virus.getHash().__contains__(virus))):
            self.__virus.add(virus)

    def getVirus(self):
        return self.__virus.getHash()

    def getQuarentena(self):
        return self.__quarentena.getHash()
