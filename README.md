# gif-clj

gif-clj is a small animated-gif encoder using [this](http://www.java2s.com/Code/Java/2D-Graphics-GUI/AnimatedGifEncoder.htm) java implementation.

## Usage

```clojure
(write-gif "out.gif"        ;; output filename
  (imgs-from-files <files>) ;; input files (imgs-from-files reads the images lazily)
  100                       ;; delay in ms
  0)                        ;; nr of loops (0 = never stop)
```

write-gif returns false if an IOException occured (this is because of the java implementation).


## Todo

 * provide better exception (or any) handling
 * tests
 * reimplementing the java implementation.


## License

Copyright (C) 2011 Robin Ramael

Distributed under the Eclipse Public License, the same as Clojure.
