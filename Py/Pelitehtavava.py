#Pelitehtavava 17.11.2022
#Tee oliopohjainen peli.
#Paahenkilo kulkee 10x10 kentalla, aluksi hanella on 100 energiaa.
#Kentta on kaksiulotteinen taulukko.
#Kulkeminen tapahtuu nuoli- tai wasd nappaimilla.
#kentalla on 10 hyttysta (hyttysolioita) satunnaisissa paikoissa.
#Jos pelaaja menee samaan ruutuun kuin hyttynen, hanen energiansa vahenee 20.
#Pelissa on aarre satunnaisessa ruudussa.
#Jos pelaaja menee aarre-ruutuun, han voittaa.
#Peliluuppi voidaan toteuttaa "while-input"-rakenteella, Pygamea tai hiirta ei tarvita

#A) Toteuta ja testaa peli.

#B) Paranna pelia, niin, etta se on oikeasti pelattava, eika voitto ole vain satunnainen.
import random
               #9   #8   #7   #6   #5   #4   #3   #2   #1   #0 
Pelikentta = [["■", "■", "■", "■", "■", "■", "■", "■", "■", "■"],#0
              ["■", "■", "■", "■", "■", "■", "■", "■", "■", "■"],#1
              ["■", "■", "■", "■", "■", "■", "■", "■", "■", "■"],#2
              ["■", "■", "■", "■", "■", "■", "■", "■", "■", "■"],#3
              ["■", "■", "■", "■", "■", "p", "■", "■", "■", "■"],#4
              ["■", "■", "■", "■", "■", "■", "■", "■", "■", "■"],#5
              ["■", "■", "■", "■", "■", "■", "■", "■", "■", "■"],#6
              ["■", "■", "■", "■", "■", "■", "■", "■", "■", "■"],#7
              ["■", "■", "■", "■", "■", "■", "■", "■", "■", "■"],#8
              ["■", "■", "■", "■", "■", "■", "■", "■", "■", "■"]],#9

class Pelaajat:
    def __init__(self):
        self.merkki = "p"
        self.pos = (0, 0)
        self.energia = 100
        self.posY
        self.posX
class Hyttynen:
    def __init__(self):
        self.posY = random.randint(0,10)
        self.posX = random.randint(0,10)
class Aarre:
    def __init__(self):
        self.posY
        self.posX
        
posX = 6
posY = 7

def hyttynenspawn():
    for i in range(0,10):
        tmphyttynen1 = Hyttynen()
        tmphyttynen1.posY = random.randint(0,9)
        tmphyttynen1.posX = random.randint(0,9)
        if tmphyttynen1.posX==5 and tmphyttynen1.posY==5:
            tmphyttynen1.posx=random.randint(0,9)
            tmphyttynen1.posx=random.randint(0,9)
        if Pelikentta [tmphyttynen1.posx, tmphyttynen1.pos]:
            

def kenttajuttu():
    for i in range(len(Pelikentta)):
        print(Pelikentta[i])
kenttajuttu()
while True:
    liikkuttaa=input("")
    if liikkuttaa == "w" or liikkuttaa == "w":
        posY -= 1
        Pelikentta[posY][posX] = "P"
        Pelikentta[posY+1][posX] = "■"
        kenttajuttu()
    if liikkuttaa == "s" or liikkuttaa == "s":
        posY -= 1
        Pelikentta[posY][posX] = "P"      
        Pelikentta[posY+1][posX] = "■"
        kenttajuttu()   
    if liikkuttaa == "d" or liikkuttaa == "d":
        posY += 1
        Pelikentta[posY][posX] = "P"   
        Pelikentta[posY][posX-1] = "■"
        kenttajuttu()  
    if liikkuttaa == "a" or liikkuttaa == "a":
        posY -= 1
        Pelikentta[posY][posX] = "P"    
        Pelikentta[posY+1][posX] = "■"
        kenttajuttu()   

