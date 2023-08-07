#Ihminen jolla on kahta kättä
#Kädellä voi laskea, Kättä voi liikuttaa, Värjätä, Piirtää...

class Ihminen:
    def __init__(self):
        self.nimi = "Diar"
        self.kadet = []
        

class Kasi:
    def __init__(self):
        self.nimi = "Kadet"
        self.sormet = ["Pikkurilli", "Nimeton", "Keskisormi", "Etusormi", "Peukalo"] 
        self.maara = 1
        self.koko = "Normaali"
        self.henkilo = "EiOle"
    def aantely(self):
        print("Clap")
    
        
        
munkasi = Kasi()
munkasi.nimi = "Kadet"
munkasi.aantely()
mundiar = Ihminen()

for i in range(2):
    tempkasi = Kasi()

    mundiar.kadet.append(tempkasi)
print(mundiar.kadet)

#Laske monta sormea henkilolla on
totalsormet = 0
for k in mundiar.kadet:
    for s in k.sormet:
        totalsormet += 1
print(totalsormet)
