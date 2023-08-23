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

--Links:
laBoca_nunez = newL laBoca nuñez q1
nuñez_Caballito = newL nuñez caballito q2
laboca_Caballito = newL laBoca caballito q3

--Tunels:
t1 = newT [laBoca_nunez, nuñez_Caballito, laboca_Caballito]

--Regions:
r1 = newR

--Tests:



