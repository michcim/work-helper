(ns work.core
  (:require [cljfx.api :as fx]
            [jdk.awt.SystemTray :as SystemTray]
            [jdk.awt.TrayIcon   :as TrayIcon]
            [jdk.awt.Toolkit    :as ToolKit]
            [jdk.awt.PopupMenu  :as PopupMenu]
            [jdk.awt.TrayIcon$MessageType :refer [ERROR WARNING INFO]])
  (:import [javafx.scene.input KeyCode KeyEvent])
 )


(defonce *runtime-state (atom {:system-tray nil}))

(defn get-system-tray! []
  (let [system-tray (SystemTray/*get-system-tray)]
    (swap! *runtime-state assoc :system-tray system-tray)))


(defn show-tray []
  )

(defn hide-tray []
  )

(defn make-menu []
  )


(defn -main [& args]
  (println "Work Helper started:" (str args))
  {:res :ok})

(def *state
  (atom {:fx/type :stage
         :always-on-top true
         :style :transparent
         :showing true
         :scene {:fx/type :scene
                 :fill :transparent
                 :on-key-pressed {:event/type :event/scene-key-press}
                 :stylesheets #{"styles.css"}
                 :root {:fx/type :v-box
                        :children [{:fx/type :label :text "Hi! What's your name?"}
                                   {:fx/type :text-field}]}}}))

(defn map-event-handler [e]
  (when (and (= :event/scene-key-press (:event/type e))
             (= KeyCode/ESCAPE (.getCode ^KeyEvent (:fx/event e))))
    (reset! *state nil)))

(def renderer
  (fx/create-renderer
    :opts {:fx.opt/map-event-handler map-event-handler}))

(fx/mount-renderer *state renderer)


(comment
  (-main "arg1")
  (get-system-tray!)
  @*runtime-state
  @*state
  )
