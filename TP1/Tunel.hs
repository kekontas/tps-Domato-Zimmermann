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
p3 = newP 1 4
c3 = newC "pun" p3
t1 = newT [l1]

newT :: [Link] -> Tunel
newT link = Tun link 


connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT c1 c2 (Tun links) = (connectsL c1 (head links) || connectsL c1  (last links)) &&
                              (connectsL c2 (head links) || connectsL c2  (last links))

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT l1 (Tun links) = l1 `elem`  links

esPrimera :: City -> Tunel -> Bool 
esPrimera c1 (Tun (l1:ls)) = connectsL c1 l1 && notInLinks c1 ls
 
notInLinks :: City -> [Link] -> Bool
notInLinks c1 (l1:ls) = not(connectsL c1 l1 && notInLinks c1 ls)
notInLinks c1 [] = True

--esUltima :: City

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun []) = 0
delayT (Tun (l:ls)) = delayL l + delayT (Tun ls)  

