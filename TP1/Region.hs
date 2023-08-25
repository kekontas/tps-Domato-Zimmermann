module Region ( Region, newR, foundR, linkR , {- tunelR, -} connectedR, linkedR{- , delayR -}, availableCapacityForR)
   where

import Point
import City
import Quality
import Tunel
import Link

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] []

-- anda
foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región 
foundR region1 city | not(inRegion city region1) = addCity region1 city
                    | otherwise = region1


-- anda
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR region1 city1 city2 quality | inRegion city1 region1 && inRegion city2 region1 && not(sameCity city1 city2) = addLink region1 (newL city1 city2 quality)
                                  | otherwise = region1


addLink :: Region -> Link -> Region
addLink (Reg cities links tunels) link = Reg cities (link:links) tunels

addCity :: Region -> City -> Region
addCity (Reg cities links tunels) city = Reg (city:cities) links tunels


tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR region1 [city1, city2] | canTunelR region1 city1 city2 = addTunel region1 (newT (regionLinks region1))
                              | otherwise = error "No se puede crear un tunel entre estas ciudades"

addTunel :: Region -> Tunel -> Region
addTunel (Reg cities links tunels) tunel = Reg cities links (tunel:tunels)

canTunelR :: Region -> City -> City -> Bool 
canTunelR (Reg cities links tunels) city1 city2 | connectsT city1 city2 (newT links) && inRegion city1 (Reg cities links tunels) && inRegion city2 (Reg cities links tunels) = True
                                                | otherwise = error "No se puede crear un tunel entre estas ciudades"

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunels) city1 city2 = any (connectsT city1 city2) tunels

--anda
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunels) city1 city2 = any (linksL city1 city2) links


--delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora


availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cities links tunels) city1 city2 = 1


inRegion :: City -> Region -> Bool
inRegion city (Reg (c1:cs) links tunels) = sameCity city c1 || inRegion city (Reg cs links tunels)
inRegion city (Reg [] links tunels) = False


sameCity :: City -> City -> Bool
sameCity city1 city2 = (nameC city1 == nameC city2) && (distanceC city1 city2 == 0)






whichLink :: Region -> City -> City -> Link -- indica el enlace que conecta dos ciudades, si es que existe
whichLink (Reg cities links tunnels) city1 city2 = if linkedR (Reg cities links tunnels) city1 city2 then head (filter (linksL city1 city2) links) else error "No estan conectadas"

regionCities :: Region -> [City]
regionCities (Reg cities links tunels) = cities

regionLinks :: Region -> [Link]
regionLinks (Reg cities links tunels) = links

regionTunnels :: Region -> [Tunel]
regionTunnels (Reg cities links tunnels) = tunnels

areConnectedbyLinks :: Region -> City -> City -> Bool
areConnectedbyLinks (Reg cities links tunels) city1 city2 = connectsT city1 city2 (newT links)
-- Tests
laBoca = newC "laboca" (newP 1 2) 
nuñez = newC "nuñez" (newP 1 3) 
caballito = newC "caballito" (newP 1 4)
bsas = newC "bsas" (newP 1 5)
--Qualities:

q1 = newQ "Cobre" 18 0.5 
q2 = newQ "Fibra" 100 0.1
q3 = newQ "oro" 1 0.2

--Links:

--Tunels:

--Regions:
--r1 = newR

r1 = ( linkR ( linkR (foundR ( foundR ( foundR ( foundR newR laBoca) nuñez ) caballito ) bsas ) laBoca nuñez q1 ) nuñez caballito q2 ) 