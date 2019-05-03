module Main where

import Crypto.Hash.SHA256
import Control.Monad
import qualified Data.ByteString as B
import qualified Data.ByteString.Char8 as BC

foreign import java unsafe "@static Entropy.get"
  getEntropy :: IO String

main :: IO ()
main = forever $ getEntropy >>= B.putStr . hash . BC.pack

