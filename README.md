# gif-clj

gif-clj is a small set of functions wrapping [this java encoder](http://www.java2s.com/Code/Java/2D-Graphics-GUI/AnimatedGifEncoder.htm).

#### Usage

```clojure
; write-gif is a simple utility for creating a gif from a set of images
; :delay sets the timing between images (ms)
; :lastdelay sets the timing for the last image
; :loops determines how many times the gif will loop. The default (0) is to loop forever

(write-gif "out.gif"  [images] )
(write-gif "out.gif"  [images] :delay 100 )
(write-gif "out.gif"  [images] :delay 100 :lastdelay 2000)
(write-gif "out.gif"  [images] :delay 100 :loops 1)

```

write-gif returns false if an IOException occured (this is because of the java implementation).


#### Todo

 * provide better exception (or any) handling
 * tests
 * reimplementing the java implementation.


#### License

Copyright (C) 2011 Robin Ramael

Distributed under the Eclipse Public License, the same as Clojure.
