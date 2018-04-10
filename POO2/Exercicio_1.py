class Product(object):
    __name = ""
    __description = ""
    managementFee = 0.0

    def __init__(self, name):
        self.__name = name
        print(name)
        print("Product")


class Loan(Product):
    __interest = 0.0
    __lenders = []


class ManagedFund(Product):
    __fundId = ""
    __distribution = 0.0
    __currentUnitPrice = 0.0


class Cash(Product):
    __interest = 0.0

    def __init__(self):
        super(Cash, self).__init__("Jorge")
        print("Cash")

a = Cash()
