module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where
import City 
import Link 


data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT link = Tun link 

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT c1 c2 (Tun links) = {- agregar -} True

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT l1 (Tun links) = if (elem l1 links) then True else False 

--tunel2list (Tun [x:xs]) = links 
--tunel2list :: Tunel -> [Link]

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun []) = 0
delayT (Tun (l:ls)) = delayL l + delayT (Tun ls)  

