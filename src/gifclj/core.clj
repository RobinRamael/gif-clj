(ns gifclj.core
  (:require [clojure.java.io :refer [as-file file]])
  (:import gifclj.AnimatedGifEncoder))

(defn write-gif
  "create an animated gif from a series of images.
  (write-gif \"output.gif\" [image1 image2 image3])"
  [filename imgs & {:keys [delay loops lastdelay]
                    :or {delay 500 loops 0 lastdelay 500}}]
  (let [encoder (doto (AnimatedGifEncoder.)
                  (.start filename)
                  (.setDelay delay)
                  (.setRepeat loops))

        d       (into [] (repeat (count imgs) delay))
        delays (conj (butlast d) lastdelay)
        imgseq (partition 2 (interleave imgs delays))] ;; 0 is indefinite
    (do
      (doseq [[img imgdelay] imgseq ]
        (.addFrame encoder img imgdelay))
      (.finish encoder))))

(defn load-image [file]
  (try (javax.imageio.ImageIO/read (as-file file))
       (catch Exception _)))

(defn imgs-from-files [files]
  (map load-image files))
