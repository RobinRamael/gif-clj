(ns gif-clj.core
  (:import AnimatedGifEncoder))

(defn write-gif [filename imgs {:keys [delay loops]}
                                :or {delay 1000 loops 0}]
  (let [encoder
	(doto (AnimatedGifEncoder.)
	  (.start filename)
	  (.setDelay delay)
	  (.setRepeat loops))] ;; 0 is indefinite
    (do
      (doseq
	  [img imgs]
	(if img (.addFrame encoder img)))
      (.finish encoder))))


(defn load-image [file]
  (try (javax.imageio.ImageIO/read file)
       (catch Exception _)))

(defn imgs-from-files [files]
  (map load-image files))