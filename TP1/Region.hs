module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where
import City 
import Link 
import Tunel 

data Region = Reg [City] [Link] [Tunel]
newR :: Region
newR c1 (Lin c1 c2 q) tunel = Reg [c1] [Lin c1 c2 q] [tunel] 

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (c1 (Lin c1 c2) q tunel) c2 = Reg [c1,c2] [Lin c1 c2 q] [tunel]

newR :: Region
newR = Reg [] [] [] ""

nameRegion :: Region -> String -> Region
nameRegion (Reg cities links tunnels _) newName = Reg cities links tunnels newName

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunnels name) newCity = Reg (newCity : cities) links tunnels name




linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades