import Point 
import City 
import Link 
import Quality 
import Tunel 
import Region


-- Ciudades
laBoca = newC "laboca" (newP 1 2) 
nuñez = newC "nuñez" (newP 1 3) 
caballito = newC "caballito" (newP 1 4)
bsas = newC "bsas" (newP 1 5)
--Qualities:

q1 = newQ "Cobre" 18 0.5 
q2 = newQ "Fibra" 100 0.1
q3 = newQ "oro" 1 0.2
-- Region:
region = newR

-- Region con ciudades:
r1 = foundR region laBoca
r2 = foundR r1 nuñez
r3 = foundR r2 caballito
r4 = foundR r3 bsas
--Region con Links:

r5 = linkR r4 laBoca nuñez q1
r6 = linkR r5 nuñez caballito q2
r7 = linkR r6 caballito bsas q3

--Region con Tuneles:
r8 = tunelR r7 [laBoca,nuñez,caballito,bsas]





