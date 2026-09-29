package mx.tec.tareas

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/** Pieza 1: la app avisa que usa Hilt. Aquí vive el contenedor que Hilt genera. */
@HiltAndroidApp
class MiApp : Application()