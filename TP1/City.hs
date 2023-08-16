module City ( City, newC, nameC, distanceC )
   where

import Point 

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC name loc = Cit name loc 

nameC :: City -> String
nameC (Cit name loc) = name

pointC :: City -> Point
pointC (Cit name loc) = loc

distanceC :: City -> City -> Float
distanceC c1 c2 = difP  (pointC c1) (pointC c2)
