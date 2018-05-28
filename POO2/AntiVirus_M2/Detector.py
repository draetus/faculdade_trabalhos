from hashlib import md5
import os


class Detector(object):

    @staticmethod
    def pegaHash(fileName):

        hasher = md5()
        with open(os.path.abspath(fileName), 'rb') as file:
            buf = file.read()
            hasher.update(buf)
        return hasher.hexdigest()

    @staticmethod
    def DetectaVirus(virus, fileName):
        return virus.getHash().__contains__(Detector.pegaHash(fileName))
