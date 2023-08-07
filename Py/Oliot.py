class Auto:
    def __init__(self):
        self.merkki = ""
        self.vari = ""
        self.paino = 0
        self.vuosimalli = 0
        self.kilometrit = 0
    def hinta(self):
        ikakerroin=1+(1/(2023-self.vuosimalli))*100
        kmkerroin=1+(1/self.kilometrit)*100
        hinta=(ikakerroin+kmkerroin)*1000
        return int(hinta)
    
autot = []    
    
auto1=Auto()

auto1.merkki = "Volvo"
auto1.vari = "Valkoinen"
auto1.paino = 620
auto1.vuosimalli = 2005
auto1.kilometrit = 18400
autot.append(auto1)

auto2=Auto()

auto2.merkki = "Nissan"
auto2.vari = "Sininen"
auto2.paino = 420
auto2.vuosimalli = 1895
auto2.kilometrit = 300000
autot.append(auto2)

auto3=Auto()

auto3.merkki = "Ford"
auto3.vari = "Keltainen"
auto3.paino = 800
auto3.vuosimalli = 2011
auto3.kilometrit = 14000
autot.append(auto3)