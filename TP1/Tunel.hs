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
l3 = newL c2 c3 q1
t1 = newT [l1,l3,l2]

newT :: [Link] -> Tunel
newT links = Tun links 


connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT c1 c2 (Tun links) = (esPrimera c1 links) && (esUltima c2 links) && (notInLinks c1 (listaMedio links)) && (notInLinks c2 (listaMedio links)) ||
                              (esPrimera c2 links) && (esUltima c1 links) && (notInLinks c1 (listaMedio links)) && (notInLinks c2 (listaMedio links)) 
                           

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT l1 (Tun links) =  l1 `elem` links
 

notInLinks :: City -> [Link] -> Bool
notInLinks c1 (l1:ls) = not(connectsL c1 l1 && notInLinks c1 ls)
notInLinks c1 [] = True

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun []) = 0
delayT (Tun (l:ls)) = delayL l + delayT (Tun ls)  

esPrimera :: City -> [Link] -> Bool
esPrimera c (a:b:ls) = connectsL c a && not(connectsL c b)
esPrimera c [] = False
esPrimera c (a:[]) = connectsL c a

esUltima :: City -> [Link] -> Bool
esUltima c [] = False
esUltima c (a:[]) = connectsL c a
esUltima c (a:ls) = connectsL c (last ls) && not(connectsL c a)

listaMedio :: [Link] -> [Link]
listaMedio links = (init . tail) links


