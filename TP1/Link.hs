
module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where
import City 
import Quality
data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL c1 c2 q = Lin c1 c2 q
connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL c1 (Lin c2 c3 q) = (c1 == c2) || (c1 == c3)

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL c1 c2 (Lin c3 c4 q) = (c1 == c3 || c1 == c4) && (c2 == c3 || c2 == c4)

capacityL :: Link -> Int
capacityL (Lin c1 c2 q) = capacityQ q

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin c1 c2 q) = delayQ q