module Point ( Point, newP, difP)
   where

data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
newP x y = Poi x y 

px :: Point -> Int
px (Poi x y) = x 

py :: Point -> Int
py (Poi x y) = y

difP :: Point -> Point -> Float  -- distancia absoluta
difP p1 p2 = sqrt ( fromIntegral((px p1) - (px p2))^2 + fromIntegral((py p1) - (py p2))^2 ) 