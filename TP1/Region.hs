module Region ( Region, newR, foundR, linkR , tunelR, connectedR{-, linkedR, delayR, availableCapacityForR-})
   where

import City
import Quality
import Tunel
import Link


data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunels) city = if inRegion city (Reg cities links tunels) 
                                        then Reg cities links tunels
                                        else Reg (city: cities) links tunels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 quality = Reg cities (links ++ [newL city1 city2 quality]) tunels

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cities links tunels) [city1, city2] = 

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunels) city1 city2 = any (connectsT city1 city2) tunels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunels) city1 city2 = any (linksL city1 city2) links

--delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora

--availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
--availableCapacityForR (Reg cities links tunels) city1 city2 = 

inRegion :: City -> Region -> Bool
inRegion city (Reg (c1:cs) links tunels) = sameCity city c1 || inRegion city (Reg cs links tunels)
inRegion city (Reg [] links tunels) = False

sameCity :: City -> City -> Bool
sameCity city1 city2 = (nameC city1 == nameC city2) && (distanceC city1 city2 == 0)


equalR :: Region -> Region -> Bool
equalR (Reg cities1 links1 tunels1) (Reg cities2 links2 tunels2) = (cities1 == cities2) && (links1 == links2) && (tunels1 == tunels2)

linkedR :: Region -> City -> City -> Bool
linkedR (Reg cities (l1:ls) tunels) city1 city2 = if linksL city1 city2 l1 then True
                                                   else linkedR (Reg cities ls tunels) city1 city2
linkedR (Reg cities [] tunels) city1 city2 = False

whichLink :: Region -> City -> City -> Link
whichLink (Reg cities (l1:ls) tunels) city1 city2 = if length ls == 0   then if linksL city1 city2 l1 then l1
                                                         else whichLink (Reg cities ls tunels) city1 city2
                                                    else if linksL city1 city2 l1
                                                         then l1
                                                         else whichLink (Reg cities ls tunels) city1 city2
                                                      
whichLink (Reg cities [] tunels) city1 city2 = error "Las ciudades no estan conectadas" 

