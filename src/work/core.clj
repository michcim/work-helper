(ns work.core
  (:require [jdk.awt.SystemTray :as SystemTray]
            [jdk.awt.TrayIcon   :as TrayIcon]
            [jdk.awt.Toolkit    :as Toolkit]
            [jdk.awt.PopupMenu  :as PopupMenu]
            [jdk.awt.TrayIcon$MessageType :refer [ERROR WARNING INFO]])
  (:gen-class))


(defn -main [& args]
  (println "Work Helper started:" (str args)))


(comment
  (-main "arg1")


  )
