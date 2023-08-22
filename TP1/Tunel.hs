module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where
import City 
import Link
import Point
import Quality


data Tunel = Tun [Link] deriving (Eq, Show)

c1 = newC "Hola" (newP 1 2) 
c2 = newC "Gil" (newP 1 3) 
q1 = newQ "Cobre" 18 0.5 
l1 = newL c1 c2 q1 
c3 = newC "pun" (newP 1 4)
c4 = newC "pun" (newP 1 5)
l2 = newL c3 c4 q1
t1 = newT [l1, l2]

newT :: [Link] -> Tunel
newT links = Tun links 


connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT c1 c2 (Tun (l1:ls)) = if length ls == 0 then connectsL c1 l1 && connectsL c2 l1
                        else 
                           if ((connectsL c1 l1) && connectsL c2 (last ls)) || ((connectsL c2 l1) && connectsL c1 (last ls)) && notInLinks c1 (l1:ls) && notInLinks c2 (l1:ls)
                           then True
                           else connectsT c1 c2 (Tun ls)

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT l1 (Tun links) = l1 `elem`  links
 

notInLinks :: City -> [Link] -> Bool
notInLinks c1 (l1:ls) = not(connectsL c1 l1 && notInLinks c1 ls)
notInLinks c1 [] = True

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun []) = 0
delayT (Tun (l:ls)) = delayL l + delayT (Tun ls)  

