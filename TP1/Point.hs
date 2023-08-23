module Point ( Point, newP, difP)
   where

data Point = Poi Int Int deriving (Eq, Show)

listaP = []

newP :: Int -> Int -> Point
newP x y = if not(alreadyExistsP (Poi x y) listaP) then error "El punto ya existe"
           else Poi x y

px :: Point -> Int
px (Poi x y) = x 

py :: Point -> Int
py (Poi x y) = y

difP :: Point -> Point -> Float  -- distancia absoluta
difP p1 p2 = sqrt ( fromIntegral((px p1) - (px p2))^2 + fromIntegral((py p1) - (py p2))^2 ) 

sameP :: Point -> Point -> Bool
sameP p1 p2 = (px p1 == px p2) && (py p1 == py p2)

alreadyExistsP :: Point -> [Point] -> Bool
alreadyExistsP p1 (p2:ps) = sameP p1 p2 || alreadyExistsP p1 ps