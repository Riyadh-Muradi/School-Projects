#1.1
def Dikke(num1, num2):
     return num1 + num2
print(Dikke(1,2))
print(Dikke(3,2))

#1.2
def Dikke1(yksi, kaksi, kolme):
    return (yksi + kaksi + kolme) / 3
print(Dikke1(2,3,4))

#1.3
def Dikke2 (num):
    num3 = []
    for i in range(len(num)):
        if num[i] %2==0:
            num3.append(num[i])
    return(num3)
print(Dikke2([1,2,3,4,6,8,11,19]))

#1.4
def Dikke3 (num1):
    num2 = []
    for i in range(len(num1)):
        if num1[i] %2==1:
            num2.append(num1[i])
    return(num2)
print(Dikke3([1,2,3,4,6,8,11,19]))

#2.1
def Dikke4(Diar12):
    return Diar12 +1
print(Dikke4(1))

#2.2
def Dikke5(Diar13):
    if Diar13 <0:
        return Diar13 *-1
    else:
        return Diar13
print(Dikke5(2))

#2.3
def Dikke5(Diar15):
    suurin = Diar15[0]
    for i in range(len(Diar15)):
        if Diar15[i] > suurin:
            suurin = Diar15[i]
    return suurin
print(Dikke5([1,2,3,4,6,8,11,19]))

def Dikke6(Diar16):
    pienin = Diar16[0]
    for i in range(len(Diar16)):
        if Diar16[i] < pienin:
            pienin = Diar16[i]
    return pienin
print(Dikke6([1,2,3,4,6,8,11,19]))

def keskiarvo(luku):
    kesk = 0
    for i in range(len(luku)):
        kesk+=luku[i]
        kesk/=len(luku)
    print(kesk)
keskiarvo([1,2,3,4,6,8,11,19])

#2.4
def fibonacciteh(luku):
    lista=[0,1]
    eka=0
    toka=1
    while max(lista)<luku:
        lista.append(lista[eka]+lista[toka])
        print(lista)
        eka+=1
        toka+=1
        
        
fibonacciteh(288)


    
    
    