import Point 
import City 
import Link 
import Quality 
import Tunel 
import Region
 
c1 = newC "Hola" (newP 1 2) 
c2 = newC "Gil" (newP 1 3) 
q1 = newQ "Cobre" 18 0.5 
l1 = newL c1 c2 q1 
c3 = newC "pun" (newP 1 4)
c4 = newC "pun" (newP 1 5)
l2 = newL c3 c4 q1
t1 = newT [l1, l2]