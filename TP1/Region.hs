module Region ( Region, newR, foundR, linkR {-, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR  -})
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
                                        else Reg (cities ++ [city]) links tunels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 quality = Reg cities (links ++ [newL city1 city2 quality]) tunels

--tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
--tunelR (Reg cities links tunels) (c1:c2) = if c1 == c2 then error "Las ciudades deben ser distintas"
                                           --else if not(inRegion c1 (Reg cities links tunels)) || not(inRegion c2 (Reg cities links tunels)) then error "Las ciudades deben estar en la region"
                                           --else Reg cities links (tunels ++ [newT (tunelLinks (Reg cities links tunels) (c1:c2))])
{-connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel

zinkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
 -}
inRegion :: City -> Region -> Bool
inRegion city (Reg cities links tunels) = city `elem` cities


equalR :: Region -> Region -> Bool
equalR (Reg cities1 links1 tunels1) (Reg cities2 links2 tunels2) = (cities1 == cities2) && (links1 == links2) && (tunels1 == tunels2)

