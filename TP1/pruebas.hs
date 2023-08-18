import Point 
import City 
import Link 
import Quality 
import Tunel 
p1 = newP 1 2 
c1 = newC "Hola" p1 
p2 = newP 1 3
c2 = newC "Gil" p2 
q1 = newQ "Cobre" 18 0.5 
l1 = newL c1 c2 q1 
p3 = newP 1 4
c3 = newC "pun" p3
t1 = newT [l1]