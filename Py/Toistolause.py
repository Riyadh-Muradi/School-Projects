#1.1
for x in range(10,20):
    print(x)

#1.2
for x in range(0,100):
    print(x)
    
#1.3
laskuri = 100
while laskuri !=0:
    print(laskuri)
    laskuri -=1
 
#1.4
Diar = [1,3,5,6,7,9]
Diar [::2]
print(Diar)
 
#2.1
hedemla = ["Bananii", "Omena", "Appelsiin", "Guava", "Papaja"]
print(hedemla)

#2.2
ika = [18, 20, 59, 16, 32, 29]
for i in ika:
    print (i)
    if i < 18:
        print("Olet alaikäinen")
    if i >= 18:
        print("Olet täysi-ikäinen")
        
#2.3
numero = 5
viisi = []
for i in range (10):
    viisi.append(numero)
    numero+= 5
for x in viisi:
    print(x)
    
#2.3
elain = ["Ronja", "Miisu", "Koira", "Kissa"]
elain.reverse()
for i in elain:
    print(i)