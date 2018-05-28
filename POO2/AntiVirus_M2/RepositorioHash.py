import pickle


class RepositorioHash(object):
    __hashs = []

    def __init__(self, fileName=""):
        if (fileName):
            self.__load(fileName)

    def __load(self, fileName):
        self.__hashs = pickle.load(open(fileName, 'rb'))

    def save(self, fileName):
        pickle.dump(self.__hashs, open(fileName, 'wb'))

    def add(self, hash1):
        self.__hashs.append(hash1)

    def remove(self, hash1):
        self.__hashs.remove(hash1)

    def getHash(self):
        return self.__hashs
