class Ruoka:
    def __init__(self):
        self.tyyppi = "latz"
        self.maara = 100

class Kissa:
    def __init__(self):
        self.nimi = "eioleviela"
        self.poikaset = []
        self.vatsa = []
        paino = 3
        self.nalka = 1000
    def aantely(self):
        print("Miau")
    def syonti(self, ruokaa):
        self.vatsa.append(ruokaa)
        self.nalka -= ruokaa.maara
        ruokaa.maara = 0
        
latzpurkki = Ruoka()
munkissa = Kissa()
munkissa.nimi = "Miisu"
munkissa.aantely()
munkissa.syonti(latzpurkki)
#print("Oman kissa nalkaisyys:", munkissa.nalka)
#print("Purkin tila:", latzpurkki:,maara)

for n in range(5):
    tmpkissa = Kissa()
    tmpkissa.paino = .2
    munkissa.poikaset.append(tmpkissa)

print(munkissa.poikaset)